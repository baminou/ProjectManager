package controller;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Calendar;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import epi.ServerInterface;
import app.ConventionException;
import app.Microarray;
import view.MicroarrayView;

public class MicroarrayController extends SpecificProjectController {
	
	public MicroarrayController(){
		super();
		_view = new MicroarrayView();
		_init();
	}

	@Override
	public void experimentListChange(int index, String value) {
		if(index>1) _view.get_platformTxtField().setEnabled(false);
		else _view.get_platformTxtField().setEnabled(true);
	}

	@Override
	public void send_to_server() throws ConventionException, RowsExceededException, WriteException, BiffException, IOException, NotBoundException {
		GeneralInfoController info = GeneralInfoController.getInstance();
		Microarray generic = new Microarray(-1, Calendar.getInstance(),info.get_view().get_titleTxtField().getText(),
				info.get_view().get_speciesComboBox().getSelectedItem().toString(),
				info.get_view().get_descriptionTxtField().getText(),info.get_project(),
				info.get_view().get_summaryTextArea().getText(),info.get_view().get_overallDesignTxtArea().getText(),
				info.get_view().get_contributorTxtField().getText(),info.get_view().get_experimentList().getSelectedValue().toString(),
				_view.get_growthProtocolTxtArea().getText(),_view.get_treatmentProtocolTxtArea().getText(),
				_view.get_extractProtocolTxtArea().getText(),_view.get_dataProcessingTxtArea().getText(),
				_view.get_additionalResultsFilesTxtArea().getText(),
				_view.get_labelProtocolTxtArea().getText(),_view.get_hybProtocolTxtArea().getText(),
				_view.get_resultsFileDescriptionTxtArea().getText(),_view.get_scanProtocolTxtArea().getText());
		ServerInterface.getInstance().get_stub().createMicroarrayDirectory(generic);
	}
	
}
