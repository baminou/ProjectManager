package app;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.lang3.text.WordUtils;

public abstract class SubProject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8807444600760098064L;
	
	protected int _id;				//ID of the sub-project for database
	protected Calendar _creation_date;	//Creation date of the sub-project
	protected String _title;			//Title of the experiment
	protected String _species;		//Species analyzed in the experiment
	protected String _description;	//Description of the experiment
	protected Project _project;		//Project related
	protected String _summary;		//Summary of the experiment
	protected String _overall_design;	//Overall design of the experiment
	protected String _contributors;	//Contributors in the experiment
	protected String _experiment;		//Type of experiment
	protected String _growthProtocol;	//Growth protocol of the experiment
	protected String _treatmentProtocol;	//Treatment protocol of the experiment
	protected String _extractProtocol;	//Extract protocol of the experiment
	protected String _dataProcessing;	//Data processing steps of the experiment
	
	public SubProject(){
		
	}

	public SubProject(int _id, Calendar _creation_date, String _title,
			String _species, String _description, Project _project,
			String _summary, String _overall_design, String _contributors,
			String _experiment, String _growthProtocol,
			String _treatmentProtocol, String _extractProtocol,
			String _dataProcessing) throws ConventionException {
		this.set_id(_id);
		this.set_creation_date(_creation_date);
		this.set_title(_title);
		this.set_species(_species);
		this.set_description(_description);
		this.set_project(_project);
		this.set_summary(_summary);
		this.set_overall_design(_overall_design);
		this.set_contributors(_contributors);
		this.set_experiment(_experiment);
		this.set_growthProtocol(_growthProtocol);
		this.set_treatmentProtocol(_treatmentProtocol);
		this.set_extractProtocol(_extractProtocol);
		this.set_dataProcessing(_dataProcessing);
	}

	/**
	 * Return the project related to the experiment
	 * @return	Project related to the experiment
	 */
	public Project get_project() {
		return _project;
	}

	/**
	 * Assign a project to the experiment
	 * @param _project	A project
	 * @throws ConventionException 	The project cannot be null
	 */
	public void set_project(Project _project) throws ConventionException {
		if(_project == null) throw new ConventionException("No project assign to the experiment.");
		this._project = _project;
	}
	
	/**
	 * Return the summary of the experiment
	 * @return	The summary of the experiment
	 */
	public String get_summary() {
		return _summary;
	}

	/**
	 * Assign the summary to the experiment
	 * @param _summary	The summary of the experiment
	 * @throws ConventionException 
	 */
	public void set_summary(String _summary) throws ConventionException {
		if(_summary.isEmpty()) throw new ConventionException("The summary is missing.");
		this._summary = _summary;
	}
	
	/**
	 * Return the overall design of the experiment
	 * @return	The overall design of the experiment
	 */
	public String get_overall_design() {
		return _overall_design;
	}
	
	/**
	 * Assign an overall design to the experiment
	 * @param _overall_design	An overall design
	 */
	public void set_overall_design(String _overall_design) {
		this._overall_design = _overall_design;
	}
	
	/**
	 * Return the contributors to the experiment
	 * @return	The contributors of the experiment
	 */
	public String get_contributors() {
		return _contributors;
	}
	
	/**
	 * Assign the contributors to the experiment
	 * @param _contributors	The list of contributors
	 * @throws ConventionException 	The contributors cannot be null
	 */
	public void set_contributors(String _contributors) throws ConventionException {
		if(_contributors.isEmpty()) throw new ConventionException("No contributors added to the experiment.");
		this._contributors = _contributors;
	}
	
	/**
	 * Return the experiment type
	 * @return	The experiment type
	 */
	public String get_experiment() {
		return _experiment;
	}
	
	/**
	 * Assign an experiment type
	 * @param _experiment	The experiment type
	 */
	public void set_experiment(String _experiment) {
		this._experiment = _experiment;
	}
	
	/**
	 * Return the ID of the experiment
	 * @return	The ID of the experiment
	 */
	public int get_id() {
		return _id;
	}
	
	/**
	 * Assign an ID
	 * @param _id	An ID to assign
	 */
	public void set_id(int _id) {
		this._id = _id;
	}
	
	/**
	 * Return the creation date
	 * @return	The creation date of the experiment
	 */
	public Calendar get_creation_date() {
		return _creation_date;
	}
	
	/**
	 * Assign the creation date
	 * @param _creation_date	A creation date
	 */
	public void set_creation_date(Calendar _creation_date) {
		this._creation_date = _creation_date;
	}
	
	/**
	 * Return the title of the experiment
	 * @return	The title of the experiment
	 */
	public String get_title() {
		return _title;
	}
	
	/**
	 * Assign the title of the experiment
	 * @param _title	The title of the experiment
	 * @throws ConventionException The title cannot be null
	 */
	public void set_title(String _title) throws ConventionException {
		if(_title.isEmpty()) throw new ConventionException("The title is missing.");
		this._title = _title;
	}
	
	/**
	 * Return the species of the experiment
	 * @return	The species of the experiment
	 */
	public String get_species() {
		return _species;
	}
	
	/**
	 * Assign a species to the experiment
	 * @param _species	The species of the experiment
	 * @throws ConventionException 
	 */
	public void set_species(String _species) throws ConventionException {
		if(_species.isEmpty()) throw new ConventionException("The species is missing.");
		this._species = _species;
	}
	
	/**
	 * Assign a description to the experiment
	 * @return	The description of the experiment
	 */
	public String get_description() {
		return _description;
	}
	
	/**
	 * Assign a description to the experiment
	 * @param _description	The description of the experiment
	 * @throws ConventionException 
	 */
	public void set_description(String _description) throws ConventionException {
		if(_description.isEmpty()) throw new ConventionException("The description is missing.");
		this._description = _description;
	}

	public String get_growthProtocol() {
		return _growthProtocol;
	}

	public void set_growthProtocol(String _growthProtocol) {
		this._growthProtocol = _growthProtocol;
	}

	public String get_treatmentProtocol() {
		return _treatmentProtocol;
	}

	public void set_treatmentProtocol(String _treatmentProtocol) {
		this._treatmentProtocol = _treatmentProtocol;
	}

	public String get_extractProtocol() {
		return _extractProtocol;
	}

	public void set_extractProtocol(String _extractProtocol) {
		this._extractProtocol = _extractProtocol;
	}

	public String get_dataProcessing() {
		return _dataProcessing;
	}

	public void set_dataProcessing(String _dataProcessing) {
		this._dataProcessing = _dataProcessing;
	}
	
	public String get_folder_name(){
		Calendar cal = this._creation_date;
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.format("%02d",cal.get(Calendar.MONTH)+1);
		String day = String.format("%02d",cal.get(Calendar.DAY_OF_MONTH));
		
		String modified_title = WordUtils.capitalizeFully(_title).replaceAll("\\s+", "");
		String modified_description = WordUtils.capitalizeFully(_description).replaceAll("\\s", "");
		return _project.get_folder_name()+"/"+year+month+day+"_"+_project.get_title()+"_"+modified_title+"_"+_species+"_"+modified_description+"/";
	}
	
	public static boolean validateGeneric(File metadata) throws BiffException, IOException, ConventionException
	{
		Workbook wrk1 = Workbook.getWorkbook(metadata);
		
		Sheet sheet1 = wrk1.getSheet(0);
		
		Cell titleCell = sheet1.getCell(1, 9);
		Cell summaryCell = sheet1.getCell(1, 10);
		Cell overallDesignCell = sheet1.getCell(1, 11);
		Cell contributorCell = sheet1.getCell(1, 12);
		Cell platformCell = sheet1.getCell(0, 46);
		
		Generic generic = new Generic();
		generic.set_title(titleCell.getContents());
		generic.set_summary(summaryCell.getContents());
		generic.set_overall_design(overallDesignCell.getContents());
		generic.set_contributors(contributorCell.getContents());
		generic.set_platform(platformCell.getContents());
		
		System.out.println("Title: " + titleCell.getContents());
		System.out.println("Summary: "+summaryCell.getContents());
		System.out.println("Overall design: "+overallDesignCell.getContents());
		System.out.println("Contributors: "+contributorCell.getContents());
		System.out.println("Platform: "+platformCell.getContents());
		
		return true;
	}
	
	public static boolean validateIllumina(File metadata) throws BiffException, IOException, ConventionException
	{
		Workbook wrk1 = Workbook.getWorkbook(metadata);
		
		Sheet sheet1 = wrk1.getSheet(0);
		
		Cell titleCell = sheet1.getCell(1, 9);
		Cell summaryCell = sheet1.getCell(1, 10);
		Cell overallDesignCell = sheet1.getCell(1, 11);
		Cell contributorCell = sheet1.getCell(1, 12);
		
		Illumina illumina = new Illumina();
		illumina.set_title(titleCell.getContents());
		illumina.set_summary(summaryCell.getContents());
		illumina.set_overall_design(overallDesignCell.getContents());
		illumina.set_contributors(contributorCell.getContents());
		
		System.out.println("Title: " + titleCell.getContents());
		System.out.println("Summary: "+summaryCell.getContents());
		System.out.println("Overall design: "+overallDesignCell.getContents());
		System.out.println("Contributors: "+contributorCell.getContents());
		
		return true;
	}
	
	public static boolean validateMicroarray(File metadata) throws BiffException, IOException, ConventionException
	{
		Workbook wrk1 = Workbook.getWorkbook(metadata);
		
		Sheet sheet1 = wrk1.getSheet(0);
		
		Cell titleCell = sheet1.getCell(1, 9);
		Cell summaryCell = sheet1.getCell(1, 10);
		Cell overallDesignCell = sheet1.getCell(1, 11);
		Cell contributorCell = sheet1.getCell(1, 12);
		
		Microarray microarray = new Microarray();
		microarray.set_title(titleCell.getContents());
		microarray.set_summary(summaryCell.getContents());
		microarray.set_overall_design(overallDesignCell.getContents());
		microarray.set_contributors(contributorCell.getContents());
		
		System.out.println("Title: " + titleCell.getContents());
		System.out.println("Summary: "+summaryCell.getContents());
		System.out.println("Overall design: "+overallDesignCell.getContents());
		System.out.println("Contributors: "+contributorCell.getContents());
		
		return true;
	}
	
	public static boolean validatePCR(File metadata) throws BiffException, IOException, ConventionException
	{
		Workbook wrk1 = Workbook.getWorkbook(metadata);
		
		Sheet sheet1 = wrk1.getSheet(0);
		
		Cell titleCell = sheet1.getCell(1, 10);
		Cell summaryCell = sheet1.getCell(1, 11);
		Cell overallDesignCell = sheet1.getCell(1, 13);
		Cell contributorCell = sheet1.getCell(1, 14);
		
		PCR pcr = new PCR();
		pcr.set_title(titleCell.getContents());
		pcr.set_summary(summaryCell.getContents());
		pcr.set_overall_design(overallDesignCell.getContents());
		pcr.set_contributors(contributorCell.getContents());
		
		System.out.println("Title: " + titleCell.getContents());
		System.out.println("Summary: "+summaryCell.getContents());
		System.out.println("Overall design: "+overallDesignCell.getContents());
		System.out.println("Contributors: "+contributorCell.getContents());
		
		return true;
	}
	
	public static boolean validateSequencing(File metadata) throws BiffException, IOException, ConventionException
	{
		Workbook wrk1 = Workbook.getWorkbook(metadata);
		
		Sheet sheet1 = wrk1.getSheet(0);
		
		Cell titleCell = sheet1.getCell(1, 8);
		Cell summaryCell = sheet1.getCell(1, 9);
		Cell overallDesignCell = sheet1.getCell(1, 10);
		Cell contributorCell = sheet1.getCell(1, 11);
		
		Sequencing sequencing = new Sequencing();
		sequencing.set_title(titleCell.getContents());
		sequencing.set_summary(summaryCell.getContents());
		sequencing.set_overall_design(overallDesignCell.getContents());
		sequencing.set_contributors(contributorCell.getContents());
		
		System.out.println("Title: " + titleCell.getContents());
		System.out.println("Summary: "+summaryCell.getContents());
		System.out.println("Overall design: "+overallDesignCell.getContents());
		System.out.println("Contributors: "+contributorCell.getContents());
		
		return true;
	}
}
