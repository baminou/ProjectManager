import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;

import app.ProjectManagerImplementation;
import app.ProjectManagerInterface;

public class Main {
	public static void main(String[] args){
		try {
			ProjectManagerImplementation obj = new ProjectManagerImplementation();
			ProjectManagerInterface stub = (ProjectManagerInterface) UnicastRemoteObject.exportObject(obj,0);
			
			Properties prop = new Properties();
			prop.load(Main.class.getClassLoader().getResourceAsStream("config.properties"));
			prop.getProperty("port");
			
			Registry reg = LocateRegistry.createRegistry(Integer.valueOf(prop.getProperty("port")));
			reg.rebind("project_manager", stub);

			System.out.println("Server is ready");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
