package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.NotBoundException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import app.ConventionException;
import view.SpecificProjectView;
import epi.GeneralInfoObserver;

public abstract class SpecificProjectController implements GeneralInfoObserver {
	
	protected SpecificProjectView _view;

	protected void _init(){
		GeneralInfoController.getInstance().get_observers().add(this);
		_view.get_generateBtn().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					send_to_server();
					GeneralInfoController.getInstance().reset();
				} catch (RowsExceededException e1) {
					JOptionPane.showMessageDialog(_view, "An error occurs with the Metadata file.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (WriteException e1) {
					JOptionPane.showMessageDialog(_view, "An error occurs with the Metadata file.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (BiffException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ConventionException e1) {
					JOptionPane.showMessageDialog(_view, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					JOptionPane.showMessageDialog(_view, "Server not reachable at this time.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	public JPanel get_view(){ return _view;}
	public abstract void send_to_server() throws ConventionException, RowsExceededException, WriteException, BiffException, IOException, NotBoundException;
	public void disable(){ _view.disable(); }
	public void enable(){ _view.enable(); }
	public void reset(){
		_view.reset();
	}

}
