package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import java.awt.BorderLayout;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.ScrollPaneConstants;

public class SyncView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2492232852980490989L;
	
	private final JTree _scratchTree = new JTree();
	private final JPanel _leftPanel = new JPanel();
	private final JScrollPane _scratchTreeScrollPane = new JScrollPane(_scratchTree);
	
	public SyncView() {
		setLayout(new BorderLayout(0, 0));
		_scratchTree.setRootVisible(false);
		_scratchTree.setShowsRootHandles(true);
		
		_scratchTree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("JTree") {
				/**
				 * 
				 */
				private static final long serialVersionUID = -3748435308955547538L;

				{
				}
			}
		));
		
		
		add(_leftPanel);
		_leftPanel.setLayout(new BorderLayout(0, 0));
		_scratchTreeScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		_scratchTreeScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		_leftPanel.add(_scratchTreeScrollPane);
	}

	public JTree get_scratchTree() {
		return _scratchTree;
	}

	public JPanel get_leftPanel() {
		return _leftPanel;
	}

	public JScrollPane get_scratchTreeScrollPane() {
		return _scratchTreeScrollPane;
	}

}
