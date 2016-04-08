package app;

import aurelienribon.slidinglayout.SLAnimator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class ThePanel extends JPanel {
	/**
	 * 
	 */
	protected static final long serialVersionUID = 888288238466316537L;
	protected static final Color FG_COLOR = new Color(0xFFFFFF);
	protected static final Color BG_COLOR = new Color(0x3B5998);

	protected final JLabel label = new JLabel();
	protected Runnable action;
	protected int borderThickness = 2;
	
	public ThePanel(){
		
	}

	public ThePanel(String name, JPanel panel) {
		setBackground(BG_COLOR);
		setLayout(new BorderLayout());

		label.setForeground(FG_COLOR);
		label.setFont(new Font("Sans", Font.BOLD, 90));
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText(name);


		add(panel, BorderLayout.CENTER);
	}

	public void setAction(Runnable action) {this.action = action;}

	// -------------------------------------------------------------------------
	// Tween Accessor
	// -------------------------------------------------------------------------

	public static class Accessor extends SLAnimator.ComponentAccessor {
		public static final int BORDER_THICKNESS = 100;

		@Override
		public int getValues(Component target, int tweenType, float[] returnValues) {
			ThePanel tp = (ThePanel) target;

			int ret = super.getValues(target, tweenType, returnValues);
			if (ret >= 0) return ret;

			switch (tweenType) {
				case BORDER_THICKNESS: returnValues[0] = tp.borderThickness; return 1;
				default: return -1;
			}
		}
	}
}
