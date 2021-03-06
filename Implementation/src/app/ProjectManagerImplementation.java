package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.tree.TreePath;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.lang3.StringUtils;


public class ProjectManagerImplementation implements ProjectManagerInterface, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3640780814240522967L;
	
	private Properties _prop = new Properties();

	public ProjectManagerImplementation() throws RemoteException, IOException {
		super();
		InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
		_prop.load(input);
	}

	@Override
	public File getScratchDirectory() throws RemoteException {
		return new File(_prop.getProperty("scratch_directory"));
	}

	@Override
	public File getArchiveDirectory() throws RemoteException {
		return new File(_prop.getProperty("archive_directory"));
	}

	@Override
	public FileTree2 getScratchTreeStructure() throws RemoteException {
		return new FileTree2(this.getScratchDirectory(),2);
	}

	@Override
	public void archivePath(TreePath tree) throws RemoteException, IOException, ConventionException, Exception {
		//Object[] path = (Object[]) java.util.Arrays.copyOfRange(tree.getPath(), 1, tree.getPath().length);
		File scratch = new File(this.getScratchDirectory().getAbsolutePath()+"/"+StringUtils.join((Object[]) java.util.Arrays.copyOfRange(tree.getPath(), 1, tree.getPath().length), "/"));
		File archive = this.getArchiveDirectory();
		
		//Check if the archive drive exists
		if(!archive.exists()){
			throw new ConventionException("Archive drive doesn't exist. Check the server configurations.");
		}
		
		//Check if the scratch folder exists
		if(!scratch.exists()){
			throw new ConventionException("Scratch folder doesn't exist on the server.");
		}
		
		
		
		//If the User wants to transfer the whole project
		if(scratch.getName().matches(_prop.getProperty("project_pattern"))){
			System.out.println("test");
			File tmp = new File(getArchiveDirectory()+"/"+scratch.getName());
			tmp.mkdirs();
			for(File sub_folder : scratch.listFiles()){
				if(sub_folder.isDirectory()){
					transfer_subfolder(sub_folder, tmp);
				}
			}
			return;
		}
		
		File tmp = new File(archive+"/"+StringUtils.join(Arrays.copyOf(tree.getPath(),tree.getPath().length-1),"/"));
		tmp.mkdirs();
		transfer_subfolder(scratch, tmp);
	}
	
	void transfer_subfolder(File src, File dest) throws IOException, InterruptedException, ConventionException{
		if(src.getName().matches(_prop.getProperty("subproject_pattern"))){
			String command = "rsync -aP --remove-source-files --chmod=Dug-w --chmod=o-wrx "+src.getAbsolutePath()+" "+dest.getAbsolutePath();
			System.out.println(command);
			Process proc = Runtime.getRuntime().exec(command);
			proc.waitFor();
			if(src.listFiles().length==0){
				src.delete();
			}
			return;
		}
		throw new ConventionException(src.getName()+" does not respect the convention.");
	}
	
	boolean isRunning(Process process){
		try{
			process.exitValue();
			return false;
		}catch(Exception e){
			return true;
		}
	}
	
	@Override
	public void createScratchDirectory(String path) throws RemoteException{
		new File(getScratchDirectory()+"/"+path).mkdirs();
	}

	@Override
	public int createProjectFolder(Project project) throws RemoteException, ConventionException {
		if(!project.toString().matches(_prop.getProperty("project_pattern"))) throw new ConventionException("Invalid Project name is generated.");
		new File(getScratchDirectory()+"/"+project).mkdir();
		return 1;
	}
	@Override
	public String getProjectConvention() throws RemoteException {
		return _prop.getProperty("project_convention");
	}

	@Override
	public String getProjectPattern() throws RemoteException {
		return _prop.getProperty("project_pattern");
	}

	@Override
	public String getSupportName() throws RemoteException {
		return _prop.getProperty("support_name");
	}

	@Override
	public String getSupportEmail() throws RemoteException {
		return _prop.getProperty("support_email");
	}

	@Override
	public String getSupportExtension() throws RemoteException {
		return _prop.getProperty("support_extension");
	}

	@Override
	public String getSubProjectConvention() throws RemoteException {
		return _prop.getProperty("subproject_convention");
	}

	@Override
	public String getSubProjectPattern() throws RemoteException {
		return _prop.getProperty("subproject_pattern");
	}

	public Properties get_prop() {
		return _prop;
	}

	public void set_prop(Properties _prop) {
		this._prop = _prop;
	}
	
	@SuppressWarnings("resource")
	public boolean CheckWord(String theWord, File theFile) throws FileNotFoundException
	{
		return new Scanner(theFile).useDelimiter("\\Z").next().contains(theWord);
	}

	@Override
	public void createPCRDirectory(PCR pcr) throws RowsExceededException, WriteException, BiffException, IOException {
		String folder_name = pcr.get_folder_name();
		createScratchDirectory(folder_name);
		
		Workbook template = Workbook.getWorkbook(getClass().getClassLoader().getResourceAsStream("PCR_template.xls"));
		WritableWorkbook wbCopy = Workbook.createWorkbook(new File(getScratchDirectory()+"/"+folder_name+"metadata.xls"),template);
		
		WritableSheet sheet = wbCopy.getSheet("TEMPLATE");
		
		sheet.addCell(new Label(1,10,pcr.get_title()));
		sheet.addCell(new Label(1,11,pcr.get_summary()));
		sheet.addCell(new Label(1,13,pcr.get_overall_design()));
		sheet.addCell(new Label(1,14,pcr.get_contributors()));
				
		sheet.addCell(new Label(1,30,pcr.get_growthProtocol()));
		sheet.addCell(new Label(1,31,pcr.get_treatmentProtocol()));
		sheet.addCell(new Label(1,32,pcr.get_extractProtocol()));
		sheet.addCell(new Label(1,33,pcr.get_labelProtocol()));
		sheet.addCell(new Label(1,36,pcr.get_dataProcessing()));
		sheet.addCell(new Label(1,37,pcr.get_valueDefinition()));
		wbCopy.write();
		wbCopy.close();
		
		PrintWriter writer = new PrintWriter(getScratchDirectory()+"/"+folder_name+"README", "UTF-8");
		writer.println("1. PCR experiment");
		writer.close();
	}

	@Override
	public void createGenericDirectory(Generic generic) throws RowsExceededException, WriteException, BiffException, IOException {
		String folder_name = generic.get_folder_name();
		createScratchDirectory(folder_name);
		
		Workbook template = Workbook.getWorkbook(getClass().getClassLoader().getResourceAsStream("GA_affy.xls"));
		WritableWorkbook wbCopy = Workbook.createWorkbook(new File(getScratchDirectory()+"/"+folder_name+"metadata.xls"),template);
		
		WritableSheet sheet = wbCopy.getSheet("Metadata Template");
		
		sheet.addCell(new Label(1,9,generic.get_title()));
		sheet.addCell(new Label(1,10,generic.get_summary()));
		sheet.addCell(new Label(1,11,generic.get_overall_design()));
		sheet.addCell(new Label(1,12,generic.get_contributors()));
		
		sheet.addCell(new Label(1,37,generic.get_growthProtocol()));
		sheet.addCell(new Label(1,38,generic.get_treatmentProtocol()));
		sheet.addCell(new Label(1,39,generic.get_extractProtocol()));
		sheet.addCell(new Label(1,40,generic.get_labelProtocol()));
		sheet.addCell(new Label(1,41,generic.get_hybProtocol()));
		sheet.addCell(new Label(1,42,generic.get_scanProtocol()));
		sheet.addCell(new Label(1,43,generic.get_dataProcessing()));
		sheet.addCell(new Label(1,44,generic.get_additionalResultsFiles()));
		sheet.addCell(new Label(1,45,generic.get_resultsFileDescriptions()));
		sheet.addCell(new Label(0,46,generic.get_platform()));
		wbCopy.write();
		wbCopy.close();
		
		PrintWriter writer = new PrintWriter(getScratchDirectory()+"/"+folder_name+"README", "UTF-8");
		writer.println("2. Generic Microarray experiment");
		writer.close();
	}

	@Override
	public void createIlluminaDirectory(Illumina illumina) throws RowsExceededException, WriteException, BiffException, IOException {
		String folder_name = illumina.get_folder_name();
		createScratchDirectory(folder_name);
		
		Workbook template = Workbook.getWorkbook(getClass().getClassLoader().getResourceAsStream("GA_illumina.xls"));
		WritableWorkbook wbCopy = Workbook.createWorkbook(new File(getScratchDirectory()+"/"+folder_name+"metadata.xls"),template);
		
		WritableSheet sheet = wbCopy.getSheet("Metadata Template");
		
		sheet.addCell(new Label(1,9,illumina.get_title()));
		sheet.addCell(new Label(1,10,illumina.get_summary()));
		sheet.addCell(new Label(1,11,illumina.get_overall_design()));
		sheet.addCell(new Label(1,12,illumina.get_contributors()));
		
		sheet.addCell(new Label(1,31,illumina.get_growthProtocol()));
		sheet.addCell(new Label(1,32,illumina.get_treatmentProtocol()));
		sheet.addCell(new Label(1,33,illumina.get_extractProtocol()));
		sheet.addCell(new Label(1,34,illumina.get_labelProtocol()));
		sheet.addCell(new Label(1,35,illumina.get_hybProtocol()));
		sheet.addCell(new Label(1,36,illumina.get_scanProtocol()));
		sheet.addCell(new Label(1,37,illumina.get_dataProcessing()));
		sheet.addCell(new Label(1,38,illumina.get_matrixProcessed()));
		sheet.addCell(new Label(1,39,illumina.get_matrixSignal()));
		wbCopy.write();
		wbCopy.close();
		
		PrintWriter writer = new PrintWriter(getScratchDirectory()+"/"+folder_name+"README", "UTF-8");
		writer.println("3. Illumina experiment");
		writer.close();
	}

	@Override
	public void createSequencingDirectory(Sequencing sequencing) throws BiffException, IOException, RowsExceededException, WriteException {
		String folder_name = sequencing.get_folder_name();
		createScratchDirectory(folder_name);
		
		Workbook template = Workbook.getWorkbook(getClass().getClassLoader().getResourceAsStream("seq_template.xls"));
		WritableWorkbook wbCopy = Workbook.createWorkbook(new File(getScratchDirectory()+"/"+folder_name+"metadata.xls"),template);
		
		WritableSheet sheet = wbCopy.getSheet("TEMPLATE");

		sheet.addCell(new Label(1,8,sequencing.get_title()));
		sheet.addCell(new Label(1,9,sequencing.get_summary()));
		sheet.addCell(new Label(1,10,sequencing.get_overall_design()));
		sheet.addCell(new Label(1,11,sequencing.get_contributors()));
		
		sheet.addCell(new Label(1,26,sequencing.get_growthProtocol()));
		sheet.addCell(new Label(1,27,sequencing.get_treatmentProtocol()));
		sheet.addCell(new Label(1,28,sequencing.get_extractProtocol()));
		sheet.addCell(new Label(1,29,sequencing.get_libraryConstruction()));
		sheet.addCell(new Label(1,30,sequencing.get_libraryStrategy()));
		sheet.addCell(new Label(1,36,sequencing.get_dataProcessing()));
		sheet.addCell(new Label(1,37,sequencing.get_genomeBuild()));
		sheet.addCell(new Label(1,38,sequencing.get_processedData()));
		wbCopy.write();
		wbCopy.close();// TODO Auto-generated method stub
		
		PrintWriter writer = new PrintWriter(getScratchDirectory()+"/"+folder_name+"README", "UTF-8");
		writer.println("4. Sequencing experiment");
		writer.close();
	}

	@Override
	public void createMicroarrayDirectory(Microarray microarray)
			throws RowsExceededException, WriteException, BiffException,
			IOException {
		String folder_name = microarray.get_folder_name();
		createScratchDirectory(folder_name);
		
		Workbook template = Workbook.getWorkbook(getClass().getClassLoader().getResourceAsStream("GA_affy.xls"));
		WritableWorkbook wbCopy = Workbook.createWorkbook(new File(getScratchDirectory()+"/"+folder_name+"metadata.xls"),template);
		
		WritableSheet sheet = wbCopy.getSheet("Metadata Template");
		
		sheet.addCell(new Label(1,9,microarray.get_title()));
		sheet.addCell(new Label(1,10,microarray.get_summary()));
		sheet.addCell(new Label(1,11,microarray.get_overall_design()));
		sheet.addCell(new Label(1,12,microarray.get_contributors()));
		
		sheet.addCell(new Label(1,37,microarray.get_growthProtocol()));
		sheet.addCell(new Label(1,38,microarray.get_treatmentProtocol()));
		sheet.addCell(new Label(1,39,microarray.get_extractProtocol()));
		sheet.addCell(new Label(1,40,microarray.get_labelProtocol()));
		sheet.addCell(new Label(1,41,microarray.get_hybProtocol()));
		sheet.addCell(new Label(1,42,microarray.get_scanProtocol()));
		sheet.addCell(new Label(1,43,microarray.get_dataProcessing()));
		sheet.addCell(new Label(1,44,microarray.get_additionalResultsFiles()));
		sheet.addCell(new Label(1,45,microarray.get_resultsFileDescriptions()));
		wbCopy.write();
		wbCopy.close();
		
		PrintWriter writer = new PrintWriter(getScratchDirectory()+"/"+folder_name+"README", "UTF-8");
		writer.println("5. Microarray experiment");
		writer.close();
	}


}
