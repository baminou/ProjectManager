package controller;

import java.awt.BorderLayout;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;

import app.FileTree2;
import app.Project;
import app.ProjectConventionException;
import epi.ServerInterface;

/**
 * Select an existing project on the server
 * @author briceaminou
 *
 */
public class SelectExistingProjectController {
	
	private final JTree tree = new JTree();
	
	public SelectExistingProjectController(){
	}
	
	public static DefaultMutableTreeNode transformNode(FileTree2.Node node){
		DefaultMutableTreeNode panel_node = new DefaultMutableTreeNode(node.get_file().getName());
		for(FileTree2.Node n : node.get_children()){
			panel_node.add(transformNode(n));
		}
		return panel_node;
		
	}
	
	public Project show() throws ProjectConventionException, RemoteException, IOException, NotBoundException{
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		panel.add(new JScrollPane(tree));
		
		//DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
		//model.setRoot((TreeNode)ServerInterface.getInstance().get_stub().getScratchTreeStructure().getModel().getRoot());
		DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
		model.setRoot(transformNode(ServerInterface.getInstance().get_stub().getScratchTreeStructure().get_root()));
		
		tree.setModel(model);
		
		int result = JOptionPane.showConfirmDialog(null, panel,"Sync folder",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
		if(result==JOptionPane.OK_OPTION){
			Project project = new Project(tree.getSelectionPath().getLastPathComponent().toString());
			return project;
		}
		return null;
	}

}
