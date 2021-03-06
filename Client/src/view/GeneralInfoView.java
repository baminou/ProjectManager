package view;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import epi.JTextFieldNoSymbol;
import epi.JTextFieldNoSymbolNoNumber;

import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GeneralInfoView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5967587752370553172L;
	
	private final JLabel _titleLbl = new JLabel("Title");
	private final JTextFieldNoSymbolNoNumber _titleTxtField = new JTextFieldNoSymbolNoNumber();
	private final JLabel _speciesLbl = new JLabel("Species");
	private final JComboBox<String> _speciesComboBox = new JComboBox<String>();
	private final JLabel _descriptionLbl = new JLabel("Description");
	private final JTextFieldNoSymbolNoNumber _descriptionTxtField = new JTextFieldNoSymbolNoNumber();
	private final JLabel _summaryLbl = new JLabel("Summary");
	private final JTextArea _summaryTextArea = new JTextArea();
	private final JScrollPane _summaryScrollPane = new JScrollPane(_summaryTextArea);
	private final JLabel _overallDesignLbl = new JLabel("Overall Design");
	private final JTextArea _overallDesignTxtArea = new JTextArea();
	private final JScrollPane _overallDesignScrollPane = new JScrollPane(_overallDesignTxtArea);
	private final JLabel _contributorLbl = new JLabel("Contributors");
	private final JTextField _contributorTxtField = new JTextFieldNoSymbol(new Character[]{';'});
	private final JList<String> _experimentList = new JList<String>();
	private final JLabel _experimentLbl = new JLabel("Experiment");
	private final JPanel _creationPanel = new JPanel();
	private final JButton _selectExistingProjectBtn = new JButton("Select Existing Project Folder");
	private final JPanel _subProjectPanel = new JPanel();
	private final JPanel panel = new JPanel();
	private final JLabel _projectTitle = new JLabel("");
	private final JLabel _projectYear = new JLabel("");
	private final JLabel _projectVersion = new JLabel("");
	private final JLabel _projectTitleLbl = new JLabel("Project Title:");
	private final JLabel _projectYearLbl = new JLabel("Year:");
	private final JLabel _projectVersionLbl = new JLabel("Version:");
	private final JButton _resetBtn = new JButton("Reset");
	private final JLabel _msgLabel = new JLabel(" ");
	private final JLabel _experimentNameLbl = new JLabel(" ");

	public GeneralInfoView() {
		setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		setBackground(new Color(169, 169, 169));
		setLayout(new BorderLayout(0, 0));
		
		_titleLbl.setForeground(new Color(255, 0, 0));
		_titleLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		_titleLbl.setLabelFor(_titleTxtField);
		
		_descriptionLbl.setLabelFor(_descriptionTxtField);
		_descriptionTxtField.setFont(new Font("Arial", Font.PLAIN, 12));
		_descriptionTxtField.setColumns(10);
		
		_speciesLbl.setForeground(new Color(255, 0, 0));
		_speciesLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		
		_descriptionLbl.setForeground(new Color(255, 0, 0));
		_descriptionLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		
		_subProjectPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(30dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(28dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		_summaryTextArea.setFont(new Font("Arial", Font.PLAIN, 12));
		_summaryTextArea.setBorder(new EmptyBorder(1, 1, 1, 1));
		_summaryTextArea.setWrapStyleWord(true);
		_summaryTextArea.setLineWrap(true);
		
		_summaryLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		_summaryLbl.setLabelFor(_summaryTextArea);
		_summaryLbl.setForeground(new Color(255,0,0));
		
		_overallDesignTxtArea.setFont(new Font("Arial", Font.PLAIN, 12));
		_overallDesignTxtArea.setBorder(new EmptyBorder(1, 1, 1, 1));
		_overallDesignTxtArea.setWrapStyleWord(true);
		_overallDesignTxtArea.setLineWrap(true);
		_overallDesignLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		
		_contributorTxtField.setFont(new Font("Arial", Font.PLAIN, 12));
		_contributorTxtField.setColumns(10);
		_contributorLbl.setForeground(new Color(255, 0, 0));
		_contributorLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		
		_experimentNameLbl.setBorder(new EmptyBorder(5, 0, 5, 0));
		_experimentNameLbl.setForeground(Color.BLACK);
		_experimentNameLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		_experimentNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		_subProjectPanel.add(_titleLbl, "2, 2, right, default");
		_subProjectPanel.add(_titleTxtField, "4, 2, fill, default");
		_subProjectPanel.add(_speciesLbl, "2, 4, right, default");
		_subProjectPanel.add(_speciesComboBox, "4, 4, center, default");
		_subProjectPanel.add(_descriptionLbl, "2, 6, right, default");
		_subProjectPanel.add(_descriptionTxtField, "4, 6, fill, default");
		_subProjectPanel.add(_summaryLbl, "2, 8, right, default");
		_subProjectPanel.add(_summaryScrollPane, "4, 8, fill, fill");
		_subProjectPanel.add(_overallDesignLbl, "2, 10, right, default");
		_subProjectPanel.add(_overallDesignScrollPane, "4, 10, fill, fill");
		_subProjectPanel.add(_contributorLbl, "2, 12, right, default");
		_subProjectPanel.add(_contributorTxtField, "4, 12, fill, default");
		_subProjectPanel.add(_experimentLbl, "2, 14, right, default");
		_subProjectPanel.add(new JScrollPane(_experimentList), "4, 14");
		_subProjectPanel.setBorder(new TitledBorder(null, "Folder Creation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		panel.add(_projectTitleLbl, "2, 2, right, default");
		panel.add(_projectTitle, "4, 2");
		panel.add(_projectYearLbl, "2, 4, right, default");
		panel.add(_projectYear, "4, 4");
		panel.add(_projectVersionLbl, "2, 6, right, default");
		panel.add(_projectVersion, "4, 6");
		
		_projectTitleLbl.setFont(new Font("Arial", Font.PLAIN, 10));
		_projectTitleLbl.setForeground(new Color(30, 144, 255));
		_projectTitle.setForeground(new Color(100, 149, 237));
		_projectTitle.setFont(new Font("Arial", Font.BOLD, 10));
		
		_projectYearLbl.setFont(new Font("Arial", Font.PLAIN, 10));
		_projectYearLbl.setForeground(new Color(30, 144, 255));
		_projectYear.setForeground(new Color(100, 149, 237));
		_projectYear.setFont(new Font("Arial", Font.BOLD, 10));
		
		_projectVersionLbl.setFont(new Font("Arial", Font.PLAIN, 10));
		_projectVersionLbl.setForeground(new Color(30, 144, 255));
		_projectVersionLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		_projectVersion.setForeground(new Color(100, 149, 237));
		_projectVersion.setFont(new Font("Arial", Font.BOLD, 10));
		
		_experimentList.setFont(new Font("Arial", Font.PLAIN, 12));
		
		_msgLabel.setFont(new Font("Arial", Font.PLAIN, 10));
		_msgLabel.setForeground(new Color(255, 0, 0));
		
		_experimentList.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1386521840249837400L;
			String[] values = new String[] {" ", "Generic Microarray", "Illumina HumanMethylation450 BeadChip (HumanMethylation450_15017482) Platform GPL13534", "Affymetrix GeneChip Human Tiling 2.0R Array Set_Array 1of7 (NCBI Build 36) Platform GPL7222", "Affymetrix GeneChip Human Tiling 2.0R Array Set_Array 2of7 (NCBI Build 36) Platform GPL7223", "Affymetrix GeneChip Human Tiling 2.0R Array Set_Array 3of7 (NCBI Build 36) Platform GPL7224", "Affymetrix GeneChip Human Tiling 2.0R Array Set_Array 4of7 (NCBI Build 36) Platform GPL7225", "Affymetrix GeneChip Human Tiling 2.0R Array Set_Array 5of7 (NCBI Build 36) Platform GPL7226", "Affymetrix GeneChip Human Tiling 2.0R Array Set_Array 6of7 (NCBI Build 36) Platform GPL7227", "Affymetrix GeneChip Human Tiling 2.0R Array Set_Array 7of7 (NCBI Build 36) Platform GPL7228", "[Mm35b_P01R] Affymetrix Mouse Tiling 2.0R Set, Array 1 Platform GPL6444", "[Mm35b_P02R] Affymetrix Mouse Tiling 2.0R Set, Array 2 Platform GPL6445", "[Mm35b_P03R] Affymetrix Mouse Tiling 2.0R Set, Array 3 Platform GPL6446", "[Mm35b_P04R] Affymetrix Mouse Tiling 2.0R Set, Array 4 Platform GPL6447", "[Mm35b_P05R] Affymetrix Mouse Tiling 2.0R Set, Array 5 Platform GPL6448", "[Mm35b_P06R] Affymetrix Mouse Tiling 2.0R Set, Array 6 Platform GPL6449", "[Mm35b_P07R] Affymetrix Mouse Tiling 2.0R Set, Array 7 Platform GPL6450", "Illumina HiSeq 2500 (Mus musculus) Platform GPL17021", "Illumina HiSeq 2500 (Homo sapiens) Platform GPL16791", "RT-PCR"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		_speciesComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Human", "Mouse"}));
		
		_creationPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("226px:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("29px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		_creationPanel.add(_selectExistingProjectBtn, "1, 2, fill, top");
		_creationPanel.add(panel, "1, 4, fill, fill");
		_creationPanel.add(_resetBtn, "1, 6, center, default");
		_creationPanel.add(_msgLabel, "1, 8, center, default");
		
		add(_creationPanel, BorderLayout.NORTH);
		add(_subProjectPanel, BorderLayout.CENTER);
		//add(InfoFields.get_instance().get_experimentNameLbl(), BorderLayout.SOUTH);
	}

	public void reset(){
		this._contributorTxtField.setText(null);
		this._descriptionTxtField.setText(null);
		this._experimentList.setSelectedIndex(0);
		this._overallDesignTxtArea.setText(null);
		this._speciesComboBox.setSelectedIndex(0);
		this._summaryTextArea.setText(null);
		this._titleTxtField.setText(null);
	}

	public JLabel get_titleLbl() {
		return _titleLbl;
	}



	public JPanel get_creationPanel() {
		return _creationPanel;
	}


	public JButton get_selectExistingProjectBtn() {
		return _selectExistingProjectBtn;
	}


	public JPanel get_subProjectPanel() {
		return _subProjectPanel;
	}


	public JPanel getPanel() {
		return panel;
	}


	public JLabel get_projectTitle() {
		return _projectTitle;
	}


	public JLabel get_projectYear() {
		return _projectYear;
	}


	public JLabel get_projectVersion() {
		return _projectVersion;
	}


	public JLabel get_projectTitleLbl() {
		return _projectTitleLbl;
	}


	public JLabel get_projectYearLbl() {
		return _projectYearLbl;
	}


	public JLabel get_projectVersionLbl() {
		return _projectVersionLbl;
	}


	public JButton get_resetBtn() {
		return _resetBtn;
	}


	public JLabel get_msgLabel() {
		return _msgLabel;
	}


	public JTextField get_titleTxtField() {
		return _titleTxtField;
	}



	public JLabel get_speciesLbl() {
		return _speciesLbl;
	}



	public JComboBox<String> get_speciesComboBox() {
		return _speciesComboBox;
	}



	public JLabel get_descriptionLbl() {
		return _descriptionLbl;
	}



	public JTextField get_descriptionTxtField() {
		return _descriptionTxtField;
	}



	public JLabel get_summaryLbl() {
		return _summaryLbl;
	}



	public JTextArea get_summaryTextArea() {
		return _summaryTextArea;
	}



	public JScrollPane get_summaryScrollPane() {
		return _summaryScrollPane;
	}



	public JLabel get_overallDesignLbl() {
		return _overallDesignLbl;
	}



	public JTextArea get_overallDesignTxtArea() {
		return _overallDesignTxtArea;
	}



	public JScrollPane get_overallDesignScrollPane() {
		return _overallDesignScrollPane;
	}



	public JLabel get_contributorLbl() {
		return _contributorLbl;
	}



	public JTextField get_contributorTxtField() {
		return _contributorTxtField;
	}



	public JList<String> get_experimentList() {
		return _experimentList;
	}



	public JLabel get_experimentLbl() {
		return _experimentLbl;
	}
}
