package app;

import java.io.File;
import java.io.Serializable;
import java.util.Vector;

public class FileTree2 implements Serializable {
	
	private Node _root;
	
	public static void main(String args[]){
		FileTree2 f = new FileTree2(new File("/Users/briceaminou/test"),1);
		f.show();
	}
	
	public Node get_root() {
		return _root;
	}

	public void set_root(Node _root) {
		this._root = _root;
	}

	public FileTree2(File file, int depth){
		_root = scan(file, depth, 0, true);
	}
	
	public void show(){
		show(_root);
	}
	
	private static void show(Node root){
		for(Node node : root.get_children()){
			show(node);
		}
	}
	
	private static Node scan(File file, int depth, int cpt, boolean only_dir){
		Node node = new Node(file);
		if(node.get_file().isDirectory() && cpt<depth){
			cpt++;
			for(File f : node.get_file().listFiles()){
				if(only_dir){
					if(f.isDirectory()){
						node.get_children().add(scan(f, depth, cpt, only_dir));
					}
				}else{
					node.get_children().add(scan(f, depth, cpt++, only_dir));
				}
			}
		}
		return node;
	}
	
	public static class Node implements Serializable{
		private File _file;
		private Vector<Node> _children;
		
		public Node(File file){
			_file = file;
			_children = new Vector<Node>();
		}

		public File get_file() {
			return _file;
		}

		public void set_file(File _file) {
			this._file = _file;
		}

		public Vector<Node> get_children() {
			return _children;
		}

		public void set_children(Vector<Node> _children) {
			this._children = _children;
		}
	}

}
