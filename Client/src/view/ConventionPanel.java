package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.IOException;
import java.rmi.NotBoundException;
import javax.swing.border.EmptyBorder;
import epi.ServerInterface;

public class ConventionPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4476858191266427846L;
	
	private final JPanel _topPanel = new JPanel();
	private final JTextField _projectConvention = new JTextField();
	private final JLabel _lblProject = new JLabel("Project:");
	private final JPanel _bottomPanel = new JPanel();
	private final JLabel _lblSubproject = new JLabel("Sub-Project:");
	private final JTextField _subProjectConvention = new JTextField();
	private final JTextField _projectPatternlbl = new JTextField();
	private final JTextField _subProjectPatternLbl = new JTextField();
	
	public ConventionPanel() {
		setLayout(new BorderLayout(0, 0));
		
		
		_topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(_topPanel, BorderLayout.NORTH);
		_topPanel.setLayout(new BorderLayout(0, 0));
		
		
		try {
			_projectConvention.setText(ServerInterface.getInstance().get_stub().getProjectConvention());
			_projectConvention.setFont(new Font("Arial", Font.BOLD, 12));
			_projectConvention.setHorizontalAlignment(SwingConstants.CENTER);
			_projectConvention.setEditable(false);
			_topPanel.add(_projectConvention);
		} catch (IOException | NotBoundException e) {
			_projectConvention.setText("Error: Undefined project convention. Server unreachable.");
		}
		
		try {
			_projectPatternlbl.setText(ServerInterface.getInstance().get_stub().getProjectPattern());
			_projectPatternlbl.setHorizontalAlignment(SwingConstants.CENTER);
			_projectPatternlbl.setEditable(false);
			_projectPatternlbl.setFont(new Font("Arial", Font.PLAIN, 10));
		} catch (IOException | NotBoundException e1) {
			_projectPatternlbl.setText("Error: Undefined project pattern. Server unreachable.");
		}
		
		try {
			_subProjectPatternLbl.setText(ServerInterface.getInstance().get_stub().getSubProjectPattern());
			_subProjectPatternLbl.setFont(new Font("Arial", Font.PLAIN, 10));
			_subProjectPatternLbl.setHorizontalAlignment(SwingConstants.CENTER);
			_subProjectPatternLbl.setEditable(false);
		} catch (IOException | NotBoundException e1) {
			_projectPatternlbl.setText("Error: Undefined sub-project pattern. Server unreachable.");
		}
		
		_lblProject.setFont(new Font("Arial", Font.PLAIN, 13));
		_lblProject.setHorizontalAlignment(SwingConstants.CENTER);
		_topPanel.add(_lblProject, BorderLayout.NORTH);
		
		_topPanel.add(_projectPatternlbl, BorderLayout.SOUTH);
		
		
		_bottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(_bottomPanel, BorderLayout.SOUTH);
		_bottomPanel.setLayout(new BorderLayout(0, 0));
		
		
		_lblSubproject.setFont(new Font("Arial", Font.PLAIN, 12));
		_lblSubproject.setHorizontalAlignment(SwingConstants.CENTER);
		_bottomPanel.add(_lblSubproject, BorderLayout.NORTH);
		
		try {
			_subProjectConvention.setText(ServerInterface.getInstance().get_stub().getSubProjectConvention());
			_subProjectConvention.setFont(new Font("Arial", Font.BOLD, 12));
			_subProjectConvention.setHorizontalAlignment(SwingConstants.CENTER);
			_subProjectConvention.setEditable(false);
			_bottomPanel.add(_subProjectConvention);
			
		} catch (IOException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_bottomPanel.add(_subProjectPatternLbl, BorderLayout.SOUTH);
		
	}

	public JPanel get_topPanel() {
		return _topPanel;
	}

	public JLabel get_lblProject() {
		return _lblProject;
	}

	public JPanel get_bottomPanel() {
		return _bottomPanel;
	}

	public JLabel get_lblSubproject() {
		return _lblSubproject;
	}
}
