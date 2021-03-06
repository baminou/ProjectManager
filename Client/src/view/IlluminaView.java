package view;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class IlluminaView extends SpecificProjectView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -98965544342572689L;

	public IlluminaView() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "450K Array", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBackground(new Color(255, 239, 213));

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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		
		
		add(_growthProtocolLbl, "2, 2, right, default");
		add(_growthProtocolScrollPane, "4, 2, fill, fill");
		add(_treatmentProtocolLbl, "2, 4");
		add(_treatmentProtocolScrollPane, "4, 4, fill, fill");
		add(_extractProtocolLbl, "2, 6");
		add(_extractProtocolScrollPane, "4, 6, fill, fill");
		add(_labelProtocolLbl, "2, 8");
		add(_labelProtocolScrollPane, "4, 8, fill, fill");
		add(_hybProtocolLbl, "2, 10");
		add(_hybProtocolScrollPane, "4, 10, fill, fill");
		add(_scanProtocolLbl, "2, 12");
		add(_scanProtocolScrollPane, "4, 12, fill, fill");
		add(_dataProcessingLbl, "2, 14");
		add(_dataProcessingScrollPane, "4, 14, fill, fill");
		add(_matrixProcessedLbl, "2, 16");
		add(_matrixProcessedScrollPane, "4, 16, fill, fill");
		add(_matrixSignalLbl, "2, 18");
		add(_matrixSignalScrollPane, "4, 18, fill, fill");
		
		add(_generateBtn, "4, 20");
	}

}
