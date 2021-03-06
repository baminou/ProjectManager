package epi;

import app.View;

public class SpecificProjectSwitcher implements GeneralInfoObserver {
	
	private View _view;

	public SpecificProjectSwitcher(View _view) {
		super();
		this._view = _view;
	}

	public View get_view() {
		return _view;
	}

	public void set_view(View _view) {
		this._view = _view;
	}

	@Override
	public void experimentListChange(int index, String value) {
		if(index==0){
			_view.go_to_img_panel.run();
			return;
		}
		if(index==1){
			_view.go_to_affy_action.run();
			return;
		}
		if(index==2){
			_view.go_to_illumina_action.run();
			return;
		}
		if(index<17){
			_view.go_to_microarray_action.run();
			return;
		}
		if(index>=17 && index<19){
			_view.go_to_seq_action.run();
			return;
		}
		if(index==19){
			_view.go_to_pcr_action.run();
			return;
		}
	}

	@Override
	public void reset() {
		_view.go_to_img_panel.run();
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enable() {
		// TODO Auto-generated method stub
		
	}


}
