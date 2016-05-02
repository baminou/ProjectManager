package app;

import java.io.File;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.swing.tree.TreePath;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public interface ProjectManagerInterface extends Remote{
	public File getScratchDirectory() throws RemoteException, IOException;
	public File getArchiveDirectory() throws RemoteException, IOException;
	public FileTree2 getScratchTreeStructure() throws RemoteException;
	//public FileTree getArchiveTreeStructure() throws RemoteException;
	public void archivePath(TreePath tree) throws RemoteException, IOException, Exception;
	
	/**
	 * Create a project folder on the server
	 * @param project				The project to create
	 * @throws RemoteException		The host is unreachable
	 * @throws ConventionException	The convention is not respected
	 */
	public int createProjectFolder(Project project) throws RemoteException, ConventionException;
	public void createScratchDirectory(String path) throws RemoteException;
	
	public String getProjectConvention() throws RemoteException;
	public String getProjectPattern() throws RemoteException;
	public String getSubProjectConvention() throws RemoteException;
	public String getSubProjectPattern() throws RemoteException;
	
	public String getSupportName() throws RemoteException;
	public String getSupportEmail() throws RemoteException;
	public String getSupportExtension() throws RemoteException;
	public void createPCRDirectory(PCR pcr) throws RowsExceededException, WriteException, BiffException, IOException;
	public void createGenericDirectory(Generic generic) throws RowsExceededException, WriteException, BiffException, IOException;
	public void createMicroarrayDirectory(Microarray microarray) throws RowsExceededException, WriteException, BiffException, IOException;
	public void createIlluminaDirectory(Illumina illumina) throws RowsExceededException, WriteException, BiffException, IOException;
	public void createSequencingDirectory(Sequencing sequencing) throws RemoteException, BiffException, IOException, RowsExceededException, WriteException;
}
