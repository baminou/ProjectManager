package controller;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import javax.swing.JOptionPane;
import epi.ServerInterface;
import epi.ServerViewObserver;
import view.ServerView;

public class ServerController {
	private ServerView _view;
	private ServerInterface _model = ServerInterface.getInstance();
	private Timer timer = new Timer();
	private boolean _connected = false;
	private Vector<ServerViewObserver> _observers = new Vector<ServerViewObserver>();
	
	public ServerController() throws IOException, NotBoundException {
		timer.schedule(new updateServerStatusAction(), 0,1000);
		_view = new ServerView();
		
		_init();
	}
	
	private void _init() throws IOException, NotBoundException{
		_view.get_ipTxtField().setText(_model.get_ip());
		_view.get_portTxtField().setText(String.valueOf(_model.get_port()));
		_view.get_scratchTxtField().setText(_model.get_scratch_directory());
		_view.get_archiveTxtField().setText(_model.get_archive_directory());
	}

	public void show(){
		JOptionPane.showConfirmDialog(null, _view,"Server Connection",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
	}

	public ServerView get_view() {
		return _view;
	}

	public void set_view(ServerView _view) {
		this._view = _view;
	}
	
	class updateServerStatusAction extends TimerTask{
		@Override
		public void run() {
			for(ServerViewObserver observer : _observers){
				observer.changeConnectionStatus();
			}
		}
	}

	public boolean is_connected() {
		return _connected;
	}

	public void set_connected(boolean _connected) {
		this._connected = _connected;
	}

	public Vector<ServerViewObserver> get_observers() {
		return _observers;
	}

	public void set_observers(Vector<ServerViewObserver> _observers) {
		this._observers = _observers;
	}
	
	
}
