package controller;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;

import javax.swing.JOptionPane;

import epi.ServerInterface;
import app.ConventionException;
import app.Project;
import view.CreateProjectView;

public class CreateProjectController {
	private CreateProjectView 	_view;	//View to create a project
	
	/**
	 * Constructor of the controller
	 */
	public CreateProjectController() {
		this._view = new CreateProjectView();
	}

	/**
	 * Initialize the controller
	 */
	public void init(){
		boolean check = false;
		while(!check){
			int result = JOptionPane.showConfirmDialog(null, _view,"New project",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
			
			if(result==JOptionPane.OK_OPTION){
				try {
					Project project = new Project(0, _view.get_projectNameTxtField().getText(),Calendar.getInstance().get(Calendar.YEAR),Integer.valueOf(_view.get_versionComboBox().getSelectedItem().toString()),Calendar.getInstance().getTime(),_view.get_fullNameTxtField().getText(),_view.get_emailTxtField().getText());
					int res = create_project(project);
					if(res==1){
						JOptionPane.showMessageDialog(null, project+" has been created.","Success!",JOptionPane.CLOSED_OPTION);
					}
					check = true;
				} catch (Exception e1) {
					check = false;
					JOptionPane.showMessageDialog(null, e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
			}else{
				check = true;
			}
		}
	}
	
	/**
	 * Send a project to the server
	 * @param project					The project to send
	 * @throws NotBoundException 		The project is not bounded to rmi
	 * @throws IOException 				The project folder cannot me created. mkdir failed
	 * @throws ConventionException 		The convention is not respected
	 * @throws RemoteException 			The server is not reachable
	 * @return	1 if the folder is created
	 */
	public int create_project(Project project) throws RemoteException, ConventionException, IOException, NotBoundException{
		return ServerInterface.getInstance().get_stub().createProjectFolder(project);
	}
	
	/**
	 * Return the view
	 * @return The view
	 */
	public CreateProjectView get_view() {
		return _view;
	}
	
	/**
	 * Assign a view
	 * @param _view	A view
	 */
	public void set_view(CreateProjectView _view) {
		this._view = _view;
	}
}
