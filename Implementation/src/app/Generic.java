package app;

import java.util.Calendar;

public class Generic extends Microarray {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6524704159864813560L;

	public Generic(int _id, Calendar _creation_date, String _title,
			String _species, String _description, Project _project,
			String _summary, String _overall_design, String _contributors,
			String _experiment, String _growthProtocol,
			String _treatmentProtocol, String _extractProtocol,
			String _dataProcessing, String additionalResultsFiles,
			String labelProtocol, String hybProtocol,
			String resultsFileDescriptions, String scan_protocol, String platform)
			throws ConventionException {
		super(_id, _creation_date, _title, _species, _description, _project, _summary,
				_overall_design, _contributors, _experiment, _growthProtocol,
				_treatmentProtocol, _extractProtocol, _dataProcessing,
				additionalResultsFiles, labelProtocol, hybProtocol,
				resultsFileDescriptions, scan_protocol);
		this.set_platform(platform);
	}

	public Generic() {
		// TODO Auto-generated constructor stub
	}

	private String _platform;

	public String get_platform() {
		return _platform;
	}

	public void set_platform(String _platform) throws ConventionException {
		if(_platform.isEmpty()) throw new ConventionException("The platform name is missing.");
		this._platform = _platform;
	}
}
