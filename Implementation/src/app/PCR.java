package app;

import java.util.Calendar;

public class PCR extends SubProject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -454991589861267394L;
	
	private String _labelProtocol;
	private String _valueDefinition;
	
	public PCR(){
		
	}

	public PCR(int _id, Calendar _creation_date, String _title, String _species,
			String _description, Project _project, String _summary,
			String _overall_design, String _contributors, String _experiment,
			String _growthProtocol, String _treatmentProtocol,
			String _extractProtocol, String _dataProcessing,
			String _labelProtocol, String _valueDefinition)
			throws ConventionException {
		super(_id, _creation_date, _title, _species, _description, _project,
				_summary, _overall_design, _contributors, _experiment,
				_growthProtocol, _treatmentProtocol, _extractProtocol,
				_dataProcessing);
		this.set_labelProtocol(_labelProtocol);
		this.set_valueDefinition(_valueDefinition);
	}

	public String get_labelProtocol() {
		return _labelProtocol;
	}

	public void set_labelProtocol(String _labelProtocol) {
		this._labelProtocol = _labelProtocol;
	}

	public String get_valueDefinition() {
		return _valueDefinition;
	}

	public void set_valueDefinition(String _valueDefinition) {
		this._valueDefinition = _valueDefinition;
	}
	
}
