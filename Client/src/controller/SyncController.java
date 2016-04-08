package controller;

import java.io.IOException;
import java.rmi.NotBoundException;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

import app.FileTree2;
import epi.ServerInterface;
import view.SyncView;

public class SyncController {
	
	private SyncView _view;
	private ServerInterface _model = ServerInterface.getInstance();
	
	public SyncController() throws IOException, NotBoundException{
		_view = new SyncView();
	}
	
	public static DefaultMutableTreeNode transformNode(FileTree2.Node node){
		DefaultMutableTreeNode panel_node = new DefaultMutableTreeNode(node.get_file().getName());
		for(FileTree2.Node n : node.get_children()){
			panel_node.add(transformNode(n));
		}
		return panel_node;
		
	}

	public void show() throws IOException, NotBoundException {
		
		//DefaultTreeModel model = (DefaultTreeModel)_view.get_scratchTree().getModel();
		//model.setRoot((TreeNode)ServerInterface.getInstance().get_stub().getScratchTreeStructure().getModel().getRoot());
		
		DefaultTreeModel model = (DefaultTreeModel)_view.get_scratchTree().getModel();
		model.setRoot(transformNode(ServerInterface.getInstance().get_stub().getScratchTreeStructure().get_root()));
		_view.get_scratchTree().setModel(model);

		int result = JOptionPane.showConfirmDialog(null, _view,"Sync folder",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
		
		if(result==JOptionPane.OK_OPTION){
			try {
				_model.sync_files(_view.get_scratchTree().getSelectionPaths());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
