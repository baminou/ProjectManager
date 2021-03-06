package app;

import java.util.Calendar;

public class Microarray extends SubProject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2948960002009209378L;
	
	protected String _additionalResultsFiles;
	protected String _resultsFileDescriptions;
	protected String _labelProtocol;
	protected String _hybProtocol;
	protected String _scanProtocol;
	
	public Microarray(){
		
	}
	
	public Microarray(int _id, Calendar _creation_date, String _title,
			String _species, String _description, Project _project,
			String _summary, String _overall_design, String _contributors,
			String _experiment, String _growthProtocol,
			String _treatmentProtocol, String _extractProtocol,
			String _dataProcessing, String additionalResultsFiles,
			String labelProtocol, String hybProtocol, String resultsFileDescriptions,
			String scan_protocol) throws ConventionException {
		super(_id, _creation_date, _title, _species, _description, _project, _summary,
				_overall_design, _contributors, _experiment, _growthProtocol,
				_treatmentProtocol, _extractProtocol, _dataProcessing);
		this.set_labelProtocol(labelProtocol);
		this.set_hybProtocol(hybProtocol);
		this.set_additionalResultsFiles(additionalResultsFiles);
		this.set_resultsFileDescriptions(resultsFileDescriptions);
		this.set_scanProtocol(scan_protocol);
	}

	public String get_additionalResultsFiles() {
		return _additionalResultsFiles;
	}

	public void set_additionalResultsFiles(String _additionalResultsFiles) {
		this._additionalResultsFiles = _additionalResultsFiles;
	}

	public String get_resultsFileDescriptions() {
		return _resultsFileDescriptions;
	}

	public void set_resultsFileDescriptions(String _resultsFileDescriptions) {
		this._resultsFileDescriptions = _resultsFileDescriptions;
	}


	public String get_labelProtocol() {
		return _labelProtocol;
	}


	public void set_labelProtocol(String _labelProtocol) {
		this._labelProtocol = _labelProtocol;
	}

	public String get_hybProtocol() {
		return _hybProtocol;
	}

	public void set_hybProtocol(String _hybProtocol) {
		this._hybProtocol = _hybProtocol;
	}

	public String get_scanProtocol() {
		return _scanProtocol;
	}

	public void set_scanProtocol(String _scanProtocol) {
		this._scanProtocol = _scanProtocol;
	}
}
