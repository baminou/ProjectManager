
package app;

import java.io.Serializable;

public class Convention implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2450182148972248533L;
	
	private static String project_pattern = "[A-Z]{1}[a-zA-Z]+_[1-9][0-9][0-9][0-9]_[0-9][0-9][0-9]";
	private static String project_title_pattern = "[A-Z]{1}[a-zA-Z]+";
	
	public static boolean project_validation(String folder_name){
		return folder_name.matches(project_pattern);
	}
	
	public static String get_project_title(String folder_name) throws ProjectConventionException{
		if(project_validation(folder_name)){
			return folder_name.split("_")[0];
		}else{
			throw new ProjectConventionException("Invalid folder name.");
		}
	}
	
	public static String get_project_year(String folder_name) throws ProjectConventionException{
		if(project_validation(folder_name)){
			return folder_name.split("_")[1];
		}else{
			throw new ProjectConventionException("Invalid folder name.");
		}
	}
	
	public static String get_project_version(String folder_name) throws ProjectConventionException{
		if(project_validation(folder_name)){
			return folder_name.split("_")[2];
		}else{
			throw new ProjectConventionException("Invalid folder name.");
		}
	}
	
	public static boolean is_project(String folder_name){
		return project_validation(folder_name);
	}
	
	public static boolean projectTitleIsValid(String title){
		return title.matches(project_title_pattern);
	}
	
}
