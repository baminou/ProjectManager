package app;

import java.util.Calendar;

public class Illumina extends SubProject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 386589191880562091L;
	
	private String _labelProtocol;
	private String _scanProtocol;
	private String _matrixProcessed;
	private String _matrixSignal;
	private String _hybProtocol;
	
	public Illumina(){
		
	}
	
	public Illumina(int _id, Calendar _creation_date, String _title,
			String _species, String _description, Project _project,
			String _summary, String _overall_design, String _contributors,
			String _experiment, String _growthProtocol,
			String _treatmentProtocol, String _extractProtocol,
			String _dataProcessing, String labelProtocol, String scanProtocol,
			String matrixProcessed, String matrixSignal, String hybProtocol) throws ConventionException {
		super(_id, _creation_date, _title, _species, _description, _project, _summary,
				_overall_design, _contributors, _experiment, _growthProtocol,
				_treatmentProtocol, _extractProtocol, _dataProcessing);
		_labelProtocol = labelProtocol;
		_scanProtocol = scanProtocol;
		_matrixProcessed = matrixProcessed;
		_matrixSignal = matrixSignal;
		_hybProtocol = hybProtocol;
	}

	public String get_labelProtocol() {
		return _labelProtocol;
	}

	public void set_labelProtocol(String _labelProtocol) {
		this._labelProtocol = _labelProtocol;
	}

	public String get_scanProtocol() {
		return _scanProtocol;
	}

	public void set_scanProtocol(String _scanProtocol) {
		this._scanProtocol = _scanProtocol;
	}

	public String get_matrixProcessed() {
		return _matrixProcessed;
	}

	public void set_matrixProcessed(String _matrixProcessed) {
		this._matrixProcessed = _matrixProcessed;
	}

	public String get_matrixSignal() {
		return _matrixSignal;
	}

	public void set_matrixSignal(String _matrixSignal) {
		this._matrixSignal = _matrixSignal;
	}

	public String get_hybProtocol() {
		return _hybProtocol;
	}

	public void set_hybProtocol(String _hybProtocol) {
		this._hybProtocol = _hybProtocol;
	}
}
