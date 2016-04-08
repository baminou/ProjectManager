package app;

import java.io.Serializable;

public class ConventionException extends Exception implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7791277808043182892L;

	public ConventionException(String message){
		super("Convention - "+message);
	}
}
