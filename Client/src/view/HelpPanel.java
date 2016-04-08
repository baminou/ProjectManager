package view;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import epi.ServerInterface;

import java.awt.GridLayout;
import java.io.IOException;
import java.rmi.NotBoundException;

public class HelpPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextPane _mainPane = new JTextPane();
	
	public HelpPanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		_mainPane.setEditable(false);
		
		_mainPane.setContentType("text/html");
		try {
			_mainPane.setText("<html>"
					+ "<tr><th>Support name:</th><td>"+ServerInterface.getInstance().get_stub().getSupportName()+"</td></tr>"
					+ "<tr><th>Email:</th><td>"+ServerInterface.getInstance().get_stub().getSupportEmail()+"</td></tr>"
					+ "<tr><th>Extension:</th><td>"+ServerInterface.getInstance().get_stub().getSupportExtension()+"</td></tr>"
					+ "</html>");
		} catch (IOException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(_mainPane);
	}

}
