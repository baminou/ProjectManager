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
	public String getScratchDirectory() throws RemoteException {
		return _prop.getProperty("scratch_directory");
	}

	@Override
	public String getArchiveDirectory() throws RemoteException {
		return _prop.getProperty("archive_directory");
	}

	@Override
	public FileTree2 getScratchTreeStructure() throws RemoteException {
		System.out.println(new File(this.getScratchPath()).getAbsolutePath());
		return new FileTree2(new File(this.getScratchPath()),2);
		//return new FileTreeModel(new File(this.getScratchPath()));
	}

	@Override
	public void archivePath(TreePath tree) throws RemoteException, IOException, ConventionException, Exception {
		String scratch = getScratchDrive()+StringUtils.join(tree.getPath(), "/");
		String archive = this.getArchiveDrive();
		File scratchFolder = new File(scratch);
		File archiveFolder = new File(archive);
		
		
		
		//Check if the archive drive exists
		if(!archiveFolder.exists()){
			throw new ConventionException("Archive drive doesn't exist. Check the server configurations.");
		}
		
		//Check if the scratch folder exists
		if(!scratchFolder.exists()){
			throw new ConventionException("Scratch folder doesn't exist on the server.");
		}
		
		if(tree.getLastPathComponent().toString().matches(_prop.getProperty("subproject_pattern"))){
			for(File file : scratchFolder.listFiles()){
				if(file.isHidden()){
					throw new ConventionException("This hidden file or directory cannot be synchronized. "+file.getAbsolutePath());
				}
				if(!file.isDirectory()){
					throw new ConventionException("This folder contains a non-valid file. "+file.getAbsolutePath());
				}
				if(!file.getName().matches(_prop.getProperty("subproject_pattern"))){
					throw new ConventionException("This folder does not respect the convention. "+file.getAbsolutePath());
				}
			}
		}
		
		String folder_to_sync = tree.getLastPathComponent().toString();
		if(folder_to_sync.matches(_prop.getProperty("project_pattern"))){
			File project = new File(scratch);
			if(!project.exists()) throw new ConventionException(project.getAbsolutePath()+" does not exist on the server.");
			System.out.println(project.getAbsolutePath());
			for(File sub_project : project.listFiles()){
				File metadata_file = new File(sub_project.getAbsolutePath()+"/metadata.xls");
				File readme_file = new File(sub_project.getAbsolutePath()+"/README");
				
				if(!sub_project.getName().matches(_prop.getProperty("subproject_pattern"))){
					throw new ConventionException(sub_project.getName()+" name does not respect the convention.");
				}
				if(!metadata_file.exists()){
					throw new ConventionException(sub_project.getName()+" - Metadata sheet does not exist.");
				}
				if(!readme_file.exists()){
					throw new ConventionException(sub_project.getName()+" - README file does not exist.");
				}
				if(CheckWord("1",readme_file)){
					SubProject.validatePCR(metadata_file);
				}
				
				if(CheckWord("2",readme_file)){
					SubProject.validateGeneric(metadata_file);
				}
				
				if(CheckWord("3",readme_file)){
					SubProject.validateIllumina(metadata_file);
				}
				
				if(CheckWord("4",readme_file)){
					SubProject.validateSequencing(metadata_file);
				}
				
				if(CheckWord("5",readme_file)){
					SubProject.validateMicroarray(metadata_file);
				}
			}
		}

		
		File tmp = new File(archive+"/"+StringUtils.join(Arrays.copyOf(tree.getPath(),tree.getPath().length-1),"/"));
		tmp.mkdirs();
		System.out.println(tmp.getAbsolutePath());
		
		String command = "rsync -a "+scratch+" "+tmp.getAbsolutePath();
		//System.out.println(command);
		Process proc = Runtime.getRuntime().exec(command);
		proc.waitFor();
	}
	
	@Override
	public String getScratchDrive() throws RemoteException {
		return _prop.getProperty("scratch_drive");
	}

	@Override
	public String getArchiveDrive() throws RemoteException {
		return _prop.getProperty("archive_drive");
	}

	@Override
	public String getScratchPath() throws RemoteException {
		return this.getScratchDrive()+this.getScratchDirectory();
	}

	@Override
	public String getArchivePath() throws RemoteException {
		return this.getArchiveDrive()+this.getArchiveDirectory();
	}
	
	@Override
	public void createScratchDirectory(String path) throws RemoteException{
		new File(getScratchPath()+"/"+path).mkdirs();
	}

	@Override
	public int createProjectFolder(Project project) throws RemoteException, ConventionException {
		if(!project.toString().matches(_prop.getProperty("project_pattern"))) throw new ConventionException("Invalid Project name is generated.");
		new File(getScratchPath()+"/"+project).mkdir();
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
		WritableWorkbook wbCopy = Workbook.createWorkbook(new File(getScratchPath()+"/"+folder_name+"metadata.xls"),template);
		
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
		
		PrintWriter writer = new PrintWriter(getScratchPath()+"/"+folder_name+"README", "UTF-8");
		writer.println("1. PCR experiment");
		writer.close();
	}

	@Override
	public void createGenericDirectory(Generic generic) throws RowsExceededException, WriteException, BiffException, IOException {
		String folder_name = generic.get_folder_name();
		createScratchDirectory(folder_name);
		
		Workbook template = Workbook.getWorkbook(getClass().getClassLoader().getResourceAsStream("GA_affy.xls"));
		WritableWorkbook wbCopy = Workbook.createWorkbook(new File(getScratchPath()+"/"+folder_name+"metadata.xls"),template);
		
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
		
		PrintWriter writer = new PrintWriter(getScratchPath()+"/"+folder_name+"README", "UTF-8");
		writer.println("2. Generic Microarray experiment");
		writer.close();
	}

	@Override
	public void createIlluminaDirectory(Illumina illumina) throws RowsExceededException, WriteException, BiffException, IOException {
		String folder_name = illumina.get_folder_name();
		createScratchDirectory(folder_name);
		
		Workbook template = Workbook.getWorkbook(getClass().getClassLoader().getResourceAsStream("GA_illumina.xls"));
		WritableWorkbook wbCopy = Workbook.createWorkbook(new File(getScratchPath()+"/"+folder_name+"metadata.xls"),template);
		
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
		
		PrintWriter writer = new PrintWriter(getScratchPath()+"/"+folder_name+"README", "UTF-8");
		writer.println("3. Illumina experiment");
		writer.close();
	}

	@Override
	public void createSequencingDirectory(Sequencing sequencing) throws BiffException, IOException, RowsExceededException, WriteException {
		String folder_name = sequencing.get_folder_name();
		createScratchDirectory(folder_name);
		
		Workbook template = Workbook.getWorkbook(getClass().getClassLoader().getResourceAsStream("seq_template.xls"));
		WritableWorkbook wbCopy = Workbook.createWorkbook(new File(getScratchPath()+"/"+folder_name+"metadata.xls"),template);
		
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
		
		PrintWriter writer = new PrintWriter(getScratchPath()+"/"+folder_name+"README", "UTF-8");
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
		WritableWorkbook wbCopy = Workbook.createWorkbook(new File(getScratchPath()+"/"+folder_name+"metadata.xls"),template);
		
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
		
		PrintWriter writer = new PrintWriter(getScratchPath()+"/"+folder_name+"README", "UTF-8");
		writer.println("5. Microarray experiment");
		writer.close();
	}


}