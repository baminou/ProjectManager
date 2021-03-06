package view;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import epi.JTextFieldNoSymbolNoNumber;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

/**
 * This class is the required view to create a project on the server
 * @author briceaminou
 *
 */
public class CreateProjectView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 618704149018418490L;
	
	final private JTextField _projectNameTxtField = new JTextFieldNoSymbolNoNumber();			//Text field for the project name
	final private JComboBox<Integer> _versionComboBox = new JComboBox<Integer>();		//Combo box for the project's version
	final private JLabel _projectNameLbl = new JLabel("Title");							//Project's name label
	final private JLabel _versionLbl = new JLabel("Version");							//Project's version label
	private final JLabel _fullNameLbl = new JLabel("Full Name");						//Creator's full name label
	private final JTextField _fullNameTxtField = new JTextField();						//Creator's full name text field
	private final JLabel _emailLbl = new JLabel("Email");								//Creator's email label
	private final JTextField _emailTxtField = new JTextField();							//Creator's email text field
	
	/**
	 * Constructor
	 */
	public CreateProjectView(){
		_emailTxtField.setColumns(10);
		_fullNameTxtField.setColumns(10);
		for(int i=1;i<100;i++) _versionComboBox.addItem(new Integer(i));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 250, 0};
		gridBagLayout.rowHeights = new int[]{32, 34, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		GridBagConstraints gbc__projectNameLbl = new GridBagConstraints();
		gbc__projectNameLbl.anchor = GridBagConstraints.EAST;
		gbc__projectNameLbl.fill = GridBagConstraints.VERTICAL;
		gbc__projectNameLbl.insets = new Insets(0, 0, 5, 5);
		gbc__projectNameLbl.gridx = 0;
		gbc__projectNameLbl.gridy = 0;
		this.add(_projectNameLbl, gbc__projectNameLbl);
		GridBagConstraints gbc__projectNameTxtField = new GridBagConstraints();
		gbc__projectNameTxtField.fill = GridBagConstraints.BOTH;
		gbc__projectNameTxtField.insets = new Insets(0, 0, 5, 0);
		gbc__projectNameTxtField.gridx = 1;
		gbc__projectNameTxtField.gridy = 0;
		_projectNameTxtField.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		this.add(_projectNameTxtField, gbc__projectNameTxtField);
		GridBagConstraints gbc__versionLbl = new GridBagConstraints();
		gbc__versionLbl.anchor = GridBagConstraints.EAST;
		gbc__versionLbl.fill = GridBagConstraints.VERTICAL;
		gbc__versionLbl.insets = new Insets(0, 0, 5, 5);
		gbc__versionLbl.gridx = 0;
		gbc__versionLbl.gridy = 1;
		this.add(_versionLbl, gbc__versionLbl);
		GridBagConstraints gbc__boxComboBox = new GridBagConstraints();
		gbc__boxComboBox.insets = new Insets(0, 0, 5, 0);
		gbc__boxComboBox.fill = GridBagConstraints.BOTH;
		gbc__boxComboBox.gridx = 1;
		gbc__boxComboBox.gridy = 1;
		this.add(_versionComboBox, gbc__boxComboBox);
		
		GridBagConstraints gbc__fullNameLbl = new GridBagConstraints();
		gbc__fullNameLbl.anchor = GridBagConstraints.EAST;
		gbc__fullNameLbl.insets = new Insets(0, 0, 5, 5);
		gbc__fullNameLbl.gridx = 0;
		gbc__fullNameLbl.gridy = 2;
		add(_fullNameLbl, gbc__fullNameLbl);
		
		GridBagConstraints gbc__fullNameTxtField = new GridBagConstraints();
		gbc__fullNameTxtField.insets = new Insets(0, 0, 5, 0);
		gbc__fullNameTxtField.fill = GridBagConstraints.HORIZONTAL;
		gbc__fullNameTxtField.gridx = 1;
		gbc__fullNameTxtField.gridy = 2;
		add(_fullNameTxtField, gbc__fullNameTxtField);
		
		GridBagConstraints gbc__emailLbl = new GridBagConstraints();
		gbc__emailLbl.anchor = GridBagConstraints.EAST;
		gbc__emailLbl.insets = new Insets(0, 0, 0, 5);
		gbc__emailLbl.gridx = 0;
		gbc__emailLbl.gridy = 3;
		add(_emailLbl, gbc__emailLbl);
		
		GridBagConstraints gbc__emailTxtField = new GridBagConstraints();
		gbc__emailTxtField.fill = GridBagConstraints.HORIZONTAL;
		gbc__emailTxtField.gridx = 1;
		gbc__emailTxtField.gridy = 3;
		add(_emailTxtField, gbc__emailTxtField);

	}

	/**
	 * Return the project name's text field
	 * @return	The project name's text field
	 */
	public JTextField get_projectNameTxtField() {
		return _projectNameTxtField;
	}

	/**
	 * Return the project name's version
	 * @return	The project name's version
	 */
	public JComboBox<Integer> get_versionComboBox() {
		return _versionComboBox;
	}

	/**
	 * Return the project name's label
	 * @return	The project name's label
	 */
	public JLabel get_projectNameLbl() {
		return _projectNameLbl;
	}

	/**
	 * Return the project name's version label
	 * @return	The project name's version label
	 */
	public JLabel get_versionLbl() {
		return _versionLbl;
	}

	/**
	 * Return the full name of the creator label
	 * @return	The full name of the creator label
	 */
	public JLabel get_fullNameLbl() {
		return _fullNameLbl;
	}

	/**
	 * Return the full name of the creator text field
	 * @return
	 */
	public JTextField get_fullNameTxtField() {
		return _fullNameTxtField;
	}

	/**
	 * Return the email of the creator's label
	 * @return	The email of the creator's label
	 */
	public JLabel get_emailLbl() {
		return _emailLbl;
	}

	/**
	 * Return the email of the creator's text field
	 * @return	The email of the creator's text field
	 */
	public JTextField get_emailTxtField() {
		return _emailTxtField;
	}
}
