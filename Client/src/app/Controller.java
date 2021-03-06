package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.rmi.NotBoundException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

import view.ConventionPanel;
import view.HelpPanel;
import controller.GeneralInfoController;
import epi.SpecificProjectSwitcher;

public class Controller {
	
	private View _view;
	private Model _model;
	private InactivityListener _inactivityListener;
	private SpecificProjectSwitcher _panelSwitcher;
	
	public Controller(Model model, View view){
		_model = model;
		_view = view;
		_panelSwitcher = new SpecificProjectSwitcher(_view);
		GeneralInfoController.getInstance().get_observers().add(_panelSwitcher);
		
		_initInactivity();
		
		_view.get_exitMenuBtn().addActionListener(new CloseListener());
		_view.get_createProjectBtn().addActionListener(new CreateProjectBtnActionListener());
		_view.get_helpMenuBtn().addActionListener(new helpBtnActionListener());
		_view.get_conventionMenuItem().addActionListener(new ConventionBtnActionListener());
		_view.get_serverLbl().addMouseListener(new ServerLblMouseListener());
		_view.get_archiveMenuItem().addActionListener(new ArchiveFolderActionListener());
	}
	
	private void _initInactivity(){
		Action reset = new AbstractAction(){
			/**
			 * 
			 */
			private static final long serialVersionUID = -6136477095214667710L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		};
		_inactivityListener = new InactivityListener(_view, reset, 5);
		_inactivityListener.start();
	}
	
	public class ArchiveFolderActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				_model.sync_files();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public class ServerLblMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			try {
				_model.edit_server_status();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				JOptionPane.showConfirmDialog(_view,"The server cannot be reached.","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	
	public class helpBtnActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showConfirmDialog(_view, new HelpPanel(),"Help",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public class ConventionBtnActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showConfirmDialog(_view,new ConventionPanel(),"Convention",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public class CloseListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	public class CreateProjectBtnActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			_model.create_new_project();
		}
	}

}
