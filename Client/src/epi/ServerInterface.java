package epi;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

import javax.swing.tree.TreePath;

import app.ProjectManagerInterface;

public class ServerInterface {
	private String _ip;
	private int _port;
	private String _scratch_directory;
	private String _archive_directory;
	private Registry _registry;
	private ProjectManagerInterface _stub;
	private static ServerInterface instance = null;
	
	public static ServerInterface getInstance() throws IOException, NotBoundException{
		if(instance == null){
			instance = new ServerInterface();
		}
		return instance;
	}
	
	private ServerInterface() throws IOException, NotBoundException{
		Properties prop = new Properties();
		InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
		prop.load(input);
		
		_ip = prop.getProperty("ip");
		_port = Integer.valueOf(prop.getProperty("port"));
		_registry = LocateRegistry.getRegistry(prop.getProperty("ip"),Integer.valueOf(prop.getProperty("port")));
		_stub = (ProjectManagerInterface) _registry.lookup("project_manager");
		_scratch_directory = _stub.getScratchDirectory().getAbsolutePath();
		_archive_directory = _stub.getArchiveDirectory().getAbsolutePath();
	}
	
	public void sync_files(TreePath[] paths) throws RemoteException, IOException, NotBoundException, Exception{
		if(paths==null) return;
		for(int i=0;i<paths.length;i++){
			ServerInterface.getInstance().get_stub().archivePath(paths[i]);
		}
	}
	

	public String get_ip() {
		return _ip;
	}
	public void set_ip(String _ip) {
		this._ip = _ip;
	}
	public int get_port() {
		return _port;
	}
	public void set_port(int _port) {
		this._port = _port;
	}
	public String get_scratch_directory() {
		return _scratch_directory;
	}
	public void set_scratch_directory(String _scratch_directory) {
		this._scratch_directory = _scratch_directory;
	}
	public String get_archive_directory() {
		return _archive_directory;
	}
	public void set_archive_directory(String _archive_directory) {
		this._archive_directory = _archive_directory;
	}

	public Registry get_registry() {
		return _registry;
	}

	public void set_registry(Registry _registry) {
		this._registry = _registry;
	}

	public ProjectManagerInterface get_stub() {
		return _stub;
	}

	public void set_stub(ProjectManagerInterface _stub) {
		this._stub = _stub;
	}
}
