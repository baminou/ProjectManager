package view;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class PCRView extends SpecificProjectView  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5529854595610215911L;

	public PCRView() {
		super();
		setBorder(new TitledBorder(null, "PCR", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(new Color(240, 255, 240));
		
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		//add(_platformLbl, "2, 2, right, default");
		//add(_platformTxtField, "4, 2, fill, default");
		add(_growthProtocolLbl, "2, 2");
		add(_growthProtocolScrollPane, "4, 2, fill, fill");
		add(_treatmentProtocolLbl, "2, 4");
		add(_treatmentProtocolScrollPane, "4, 4, fill, fill");
		add(_extractProtocolLbl, "2, 6");
		add(_extractProtocolScrollPane, "4, 6, fill, fill");
		add(_labelProtocolLbl, "2, 8");
		add(_labelProtocolScrollPane, "4, 8, fill, fill");
		add(_dataProcessingLbl, "2, 10");
		add(_dataProcessingScrollPane, "4, 10, fill, fill");
		add(_valueDefinitionLbl, "2, 12");
		add(_valueDefinitionScrollPane, "4, 12, fill, fill");
		add(_generateBtn, "4, 14");
	}
}
