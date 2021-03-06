package app;

import java.io.File;
import java.io.Serializable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

/**
 * Display a file system in a JTree view
 * 
 * @version $Id: FileTree.java,v 1.9 2004/02/23 03:39:22 ian Exp $
 * @author Ian Darwin
 */
public class FileTree extends JTree implements Serializable
{   
   /**
	 * 
	 */
	private static final long serialVersionUID = 1183579160165784456L;

public FileTree(String path)
   {
      super(scan(new File(path)));
   }

   private static MutableTreeNode scan(File node)
   {
	   DefaultMutableTreeNode ret = new DefaultMutableTreeNode(node.getName());
	   for(File child : node.listFiles()){
		   if(child.isDirectory() && !child.isHidden()){
			   DefaultMutableTreeNode projectRet = new DefaultMutableTreeNode(child.getName());
			   ret.add(projectRet);
			   for(File grand_child : child.listFiles()){
				   if(grand_child.isDirectory()&&!grand_child.isHidden()){
					   projectRet.add(new DefaultMutableTreeNode(grand_child.getName()));
				   }
			   }
		   }
	   }
	   return ret;
   }
}