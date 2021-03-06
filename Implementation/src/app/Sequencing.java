package app;

import java.util.Calendar;

public class Sequencing extends SubProject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6018065974079777247L;
	
	private String _libraryConstruction;
	private String _libraryStrategy;
	private String _genomeBuild;
	private String _processedData;
	
	public Sequencing(){
		
	}
	
	public Sequencing(int _id, Calendar _creation_date, String _title,
			String _species, String _description, Project _project,
			String _summary, String _overall_design, String _contributors,
			String _experiment, String _growthProtocol,
			String _treatmentProtocol, String _extractProtocol,
			String _dataProcessing, String libraryConstruction,
			String genomeBuild, String processedData, String libraryStrategy) throws ConventionException {
		super(_id, _creation_date, _title, _species, _description, _project, _summary,
				_overall_design, _contributors, _experiment, _growthProtocol,
				_treatmentProtocol, _extractProtocol, _dataProcessing);
		this.set_libraryConstruction(libraryConstruction);
		this.set_genomeBuild(genomeBuild);
		this.set_processedData(processedData);
		this.set_libraryStrategy(libraryStrategy);
	}
	
	public String get_libraryStrategy() {
		return _libraryStrategy;
	}

	public void set_libraryStrategy(String _libraryStrategy) {
		this._libraryStrategy = _libraryStrategy;
	}

	public String get_libraryConstruction() {
		return _libraryConstruction;
	}
	public void set_libraryConstruction(String _libraryConstruction) {
		this._libraryConstruction = _libraryConstruction;
	}
	public String get_genomeBuild() {
		return _genomeBuild;
	}
	public void set_genomeBuild(String _genomeBuild) {
		this._genomeBuild = _genomeBuild;
	}
	public String get_processedData() {
		return _processedData;
	}
	public void set_processedData(String _processedData) {
		this._processedData = _processedData;
	}
}
