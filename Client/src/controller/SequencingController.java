package controller;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;

import epi.ServerInterface;
import app.ConventionException;
import app.Sequencing;
import view.SequencingView;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class SequencingController extends SpecificProjectController{
	
	public SequencingController(){
		_view = new SequencingView();
		_init();
	}

	@Override
	public void experimentListChange(int index, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
	}

	@Override
	public void enable() {
	}

	@Override
	public void disable() {
	}

	@Override
	public void send_to_server() throws ConventionException, RowsExceededException, RemoteException, BiffException, WriteException, IOException, NotBoundException {
		GeneralInfoController info = GeneralInfoController.getInstance();
		Sequencing sequencing = new Sequencing(-1,Calendar.getInstance(),info.get_view().get_titleTxtField().getText(),
				info.get_view().get_speciesComboBox().getSelectedItem().toString(),info.get_view().get_descriptionTxtField().getText(),
				info.get_project(),info.get_view().get_summaryTextArea().getText(),info.get_view().get_overallDesignTxtArea().getText(),
				info.get_view().get_contributorTxtField().getText(),info.get_view().get_experimentList().getSelectedValue().toString(),
				_view.get_growthProtocolTxtArea().getText(),_view.get_treatmentProtocolTxtArea().getText(),
				_view.get_extractProtocolTxtArea().getText(),_view.get_dataProcessingTxtArea().getText(),
				_view.get_libraryConstructionTxtArea().getText(),_view.get_genomeBuildTxtArea().getText(),
				_view.get_processedDataTxtArea().getText(),_view.get_libraryStrategyTxtArea().getText());
		ServerInterface.getInstance().get_stub().createSequencingDirectory(sequencing);
	}
	
	
}
