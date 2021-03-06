package app;

import java.io.IOException;
import java.rmi.NotBoundException;
import controller.CreateProjectController;
import controller.ServerController;
import controller.SyncController;

public class Model {
	public void create_new_project(){
		new CreateProjectController().init();
	}
	
	public void edit_server_status() throws IOException, NotBoundException{
		new ServerController().show();
	}

	public void sync_files() throws IOException, NotBoundException {
		new SyncController().show();
	}
}
