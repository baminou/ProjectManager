package view;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class GenericView extends MicroarrayView{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4116965902786493559L;

	public GenericView() {

		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Generic Microarray", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		setLayout(new FormLayout(new ColumnSpec[] {
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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		add(_platformLbl, "2, 2, right, default");
		add(_platformTxtField, "4, 2, fill, default");
		add(_growthProtocolLbl, "2, 4, right, default");
		add(_growthProtocolScrollPane, "4, 4, fill, fill");
		add(_treatmentProtocolLbl, "2, 6, right, default");
		add(_treatmentProtocolScrollPane, "4, 6, fill, fill");
		add(_extractProtocolLbl, "2, 8, right, default");
		add(_extractProtocolScrollPane, "4, 8, fill, fill");
		add(_labelProtocolLbl, "2, 10, right, default");
		add(_labelProtocolScrollPane, "4, 10, fill, fill");
		add(_hybProtocolLbl, "2, 12, right, default");
		add(_hybProtocolScrollPane, "4, 12, fill, fill");
		add(_scanProtocolLbl, "2, 14, right, default");
		add(_scanProtocolScrollPane, "4, 14, fill, fill");
		add(_dataProcessingLbl, "2, 16, right, default");
		add(_dataProcessingScrollPane, "4, 16, fill, fill");
		
		add(_additionalResultsFilesLbl, "2, 18, right, default");
		add(_additionalResultsFilesScrollPane, "4, 18, fill, fill");
		add(_resultsFileDescriptionsLbl, "2, 20, right, default");
		add(_resultsFileDescriptionScrollPane, "4, 20, fill, fill");
		
		
		add(_generateBtn, "4, 22");
	}
}
