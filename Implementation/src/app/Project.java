package app;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.text.WordUtils;

public class Project implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4244772242088386882L;
	
	private int		_id;				//ID of the project for database
	private String 	_title;				//Title of the project
	private int		_year;				//Creation year of the project
	private int		_version;			//Version number of the project
	private Date 	_creation_date;		//Creation data for database purposes
	private String	_original_folder;	//The name of the original folder
	private String	_creatorName;		//Name of the creator
	private String 	_creatorEmail;		//Email of the creator
	
	/**
	 * Constructor from a conventional folder name
	 * @param folder_name					A folder name
	 * @throws ProjectConventionException	The folder's name must respect the convention
	 */
	public Project(String folder_name) throws ProjectConventionException{
		if(Convention.project_validation(folder_name)){
			_title = Convention.get_project_title(folder_name);
			this.set_year(Integer.valueOf(Convention.get_project_year(folder_name)));
			this.set_version(Integer.valueOf(Convention.get_project_version(folder_name)));
			this.set_original_folder(folder_name);
			this.set_creation_date(Calendar.getInstance().getTime());
		}else{
			throw new ProjectConventionException("Invalid folder name. "+folder_name);
		}
	}
	
	/**
	 * Constructor from parameters
	 * @param id							ID to assign
	 * @param _title						The title of the project
	 * @param _year							Creation year of the project
	 * @param _version						Version of the project
	 * @param _creation_date				Creation date of the project
	 * @param creator_name					Creator name of the project
	 * @param creator_email					Creator's email
	 * @throws ProjectConventionException	The parameters must respect the convention
	 */
	public Project(int id, String _title, int _year, int _version, Date _creation_date, String creator_name, String creator_email) throws ProjectConventionException{
		this.set_id(id);
		this.set_title(_title);
		this.set_year(_year);
		this.set_version(_version);
		this.set_creation_date(_creation_date);
		this.set_creatorName(creator_name);
		this.set_creatorEmail(creator_email);
	}
	
	/**
	 * Return the original folder's name
	 * @return The name of the original folder.
	 */
	public String get_original_folder() {
		return _original_folder;
	}

	/**
	 * Set the original folder's name
	 * @param _original_folder The name of the original folder
	 */
	public void set_original_folder(String _original_folder) {
		this._original_folder = _original_folder;
	}

	/**
	 * The title of the project
	 * @return The title of the project
	 */
	public String get_title() {
		return _title;
	}
	
	/**
	 * Set the title of the project
	 * @param _title	The title to assign
	 * @throws ProjectConventionException The project title must follow the convention.
	 */
	public void set_title(String _title) throws ProjectConventionException {
		String t = WordUtils.capitalizeFully(_title).replaceAll("\\s+", "");
		if(!Convention.projectTitleIsValid(t)) throw new ProjectConventionException("The title pattern of the project is invalid. "+_title);
		if(t.length()<2) throw new ProjectConventionException("The title of the project must contains at least 2 caracters. "+_title);
		this._title = t;
	}
	
	/**
	 * Get the creation year of the project
	 * @return	The creation year.
	 */
	public int get_year() {
		return _year;
	}
	
	/**
	 * Assign the creation year to a project
	 * @param _year	The creation year
	 */
	public void set_year(int _year) {
		this._year = _year;
	}
	
	/**
	 * Return the version of the project
	 * @return The version of the project
	 */
	public int get_version() {
		return _version;
	}
	
	/**
	 * Assign a version to the project
	 * @param _version	A version to assign
	 * @throws ProjectConventionException The _version number must be greater than 1
	 */
	public void set_version(int _version) throws ProjectConventionException {
		if(_version<1) throw new ProjectConventionException("The version of the project must be greater than one.");
		this._version = _version;
	}

	/**
	 * The creation date of the project
	 * @return	The creation date
	 */
	public Date get_creation_date() {
		return _creation_date;
	}

	/**
	 * Set the creation date of the project
	 * @param _creation_date	The creation date
	 */
	public void set_creation_date(Date _creation_date) {
		this._creation_date = _creation_date;
	}

	/**
	 * Return the ID of the project
	 * @return	The ID of the project
	 */
	public int get_id() {
		return _id;
	}

	/**
	 * Assign an ID to the project
	 * @param _id	An id to assign
	 */
	public void set_id(int _id) {
		this._id = _id;
	}
	
	/**
	 * Return the conventional folder name
	 * @return	The conventional folder name of the project
	 */
	public String get_folder_name(){
		return _title+"_"+_year+"_"+String.format("%03d",_version);
	}
	
	/**
	 * Return the creator name of the project
	 * @return	The creator name of the project
	 */
	public String get_creatorName() {
		return _creatorName;
	}

	/**
	 * Assign a creator name to the project
	 * @param _creatorName	The creator name
	 * @throws ProjectConventionException The name must contain at least 2 letters
	 */
	public void set_creatorName(String _creatorName) throws ProjectConventionException {
		if(_creatorName.isEmpty()) throw new ProjectConventionException("Enter a valid full name.");
		if(_creatorName.length()<2) throw new ProjectConventionException("The full name's length must contain at least 2 characters.");
		this._creatorName = _creatorName;
	}

	/**
	 * Get the creator's email address
	 * @return	The creator's email
	 */
	public String get_creatorEmail() {
		return _creatorEmail;
	}

	/**
	 * Assign the creator's email address
	 * @param _creatorEmail	An email address
	 * @throws ProjectConventionException A valid an not-null email 
	 */
	public void set_creatorEmail(String _creatorEmail) throws ProjectConventionException {
		if(_creatorEmail.isEmpty()) throw new ProjectConventionException("Enter a valid email.");
		if(!_creatorEmail.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")) throw new ProjectConventionException("Enter a valid email.");
		this._creatorEmail = _creatorEmail;
	}
	
	@Override
	public String toString() {
		return this.get_folder_name();
	}
}
