package app;

import java.io.Serializable;

public class ProjectConventionException extends ConventionException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1071992270725891990L;

	public ProjectConventionException(String message) {
		super("Project - "+message);
	}

}
