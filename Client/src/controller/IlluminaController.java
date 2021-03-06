package controller;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Calendar;

import app.ConventionException;
import app.Illumina;
import epi.ServerInterface;
import view.IlluminaView;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class IlluminaController extends SpecificProjectController{
	
	public IlluminaController(){
		_view = new IlluminaView();
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
	public void send_to_server() throws ConventionException, RowsExceededException, WriteException, BiffException, IOException, NotBoundException {
		GeneralInfoController info = GeneralInfoController.getInstance();
		Illumina illumina = new Illumina(-1,Calendar.getInstance(),info.get_view().get_titleTxtField().getText(),
				info.get_view().get_speciesComboBox().getSelectedItem().toString(),
				info.get_view().get_descriptionTxtField().getText(),info.get_project(),
				info.get_view().get_summaryTextArea().getText(),info.get_view().get_overallDesignTxtArea().getText(),
				info.get_view().get_contributorTxtField().getText(),info.get_view().get_experimentList().getSelectedValue().toString(),
				_view.get_growthProtocolTxtArea().getText(),_view.get_treatmentProtocolTxtArea().getText(),
				_view.get_extractProtocolTxtArea().getText(),_view.get_dataProcessingTxtArea().getText(),
				_view.get_labelProtocolTxtArea().getText(),_view.get_scanProtocolTxtArea().getText(),
				_view.get_matrixProcessedTxtArea().getText(),_view.get_matrixSignalTxtArea().getText(),
				_view.get_hybProtocolTxtArea().getText());
		ServerInterface.getInstance().get_stub().createIlluminaDirectory(illumina);
	}
	
}
