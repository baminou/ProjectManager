package epi;

import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

public class JTextFieldNoSymbol extends JTextField {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8950692402375123450L;
	public Vector<Character> _exceptions = new Vector<Character>();
	
	public JTextFieldNoSymbol(Character... exceptions){
		super();
		
		for(Character exception : exceptions) _exceptions.addElement(exception);

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(arg0.getKeyChar()==KeyEvent.VK_BACK_SPACE){
					return;
				}
				if(_exceptions.contains(arg0.getKeyChar())) return;
				if(!Character.toString(arg0.getKeyChar()).matches("[a-zA-Z0-9\\s]")){
					arg0.consume();
				}
			}
		});
	}
}
