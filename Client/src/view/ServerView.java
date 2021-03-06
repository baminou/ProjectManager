package view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class ServerView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3267132168342982499L;
	
	final private JTextField _ipTxtField = new JTextField();
	final private JLabel _ipLbl = new JLabel("IP:");
	final private JLabel _scratchLbl = new JLabel("Scratch:");
	final private JLabel _archiveLbl = new JLabel("Archive:");
	final private JTextField _archiveTxtField = new JTextField();
	final private JTextField _scratchTxtField = new JTextField();
	final private JLabel _portLbl = new JLabel("Port:");
	final private JTextField _portTxtField = new JTextField();
	
	public ServerView() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		_ipLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		
		add(_ipLbl, "2, 2, right, default");
		_ipTxtField.setFont(new Font("Arial", Font.PLAIN, 12));
		_ipTxtField.setEditable(false);
		add(_ipTxtField, "4, 2, left, default");
		
		_portLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		add(_portLbl, "2, 4, right, default");
		
		_portTxtField.setEditable(false);
		_portTxtField.setFont(new Font("Arial", Font.PLAIN, 12));
		add(_portTxtField, "4, 4, left, default");

		_scratchLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		add(_scratchLbl, "2, 6, right, default");
		
		_scratchTxtField.setEditable(false);
		_scratchTxtField.setFont(new Font("Arial", Font.PLAIN, 12));
		add(_scratchTxtField, "4, 6, left, default");
		

		_archiveLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		add(_archiveLbl, "2, 8, right, default");
		
		_archiveTxtField.setEditable(false);
		_archiveTxtField.setFont(new Font("Arial", Font.PLAIN, 12));
		add(_archiveTxtField, "4, 8, left, default");

	}

	public JLabel get_scratchLbl() {
		return _scratchLbl;
	}


	public JTextField get_portTxtField() {
		return _portTxtField;
	}

	public JLabel get_archiveLbl() {
		return _archiveLbl;
	}


	public JLabel get_portLbl() {
		return _portLbl;
	}


	public JLabel get_ipLbl() {
		return _ipLbl;
	}

	public JTextField get_ipTxtField() {
		return _ipTxtField;
	}

	public JTextField get_archiveTxtField() {
		return _archiveTxtField;
	}

	public JTextField get_scratchTxtField() {
		return _scratchTxtField;
	}

}
