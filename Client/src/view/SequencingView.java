package view;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class SequencingView extends SpecificProjectView {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -414139583263940470L;

	public SequencingView() {
		super();
		setBorder(new TitledBorder(null, "Sequencing", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(new Color(240, 255, 255));

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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		add(_growthProtocolLbl, "2, 2");
		add(_growthProtocolScrollPane, "4, 2, fill, fill");
		add(_treatmentProtocolLbl, "2, 4");
		add(_treatmentProtocolScrollPane, "4, 4, fill, fill");
		add(_extractProtocolLbl, "2, 6");
		add(_extractProtocolScrollPane, "4, 6, fill, fill");
		
		add(_libraryConstructionProtocolLbl, "2, 8");
		add(_libraryConstructionScrollPane, "4, 8, fill, fill");
		
		add(_libraryStrategyLbl, "2, 10");
		add(_libraryStrategyScrollPane, "4, 10, fill, fill");
		add(_dataProcessingLbl, "2, 12");
		add(_dataProcessingScrollPane, "4, 12, fill, fill");
		
		add(_genomeBuildLbl, "2, 14");
		add(_genomeBuildScrollPane, "4, 14, fill, fill");
		
		add(_processedDataLbl, "2, 16");
		add(_processedDataScrollPane, "4, 16, fill, fill");
		
		add(_generateBtn, "4, 18");
	}

}
