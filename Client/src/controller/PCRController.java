package controller;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Calendar;

import javax.swing.JPanel;

import app.ConventionException;
import app.PCR;
import view.PCRView;
import epi.ServerInterface;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class PCRController extends SpecificProjectController {
	
	public PCRController(){
		super();
		_view = new PCRView();
		_init();
		//InfoFields.get_instance().get_generateBtn().addActionListener(new GenerateActionListener());
	}

	public void set_view(PCRView _view) {
		this._view = _view;
	}

	@Override
	public void experimentListChange(int index, String value) {
	}

	@Override
	public JPanel get_view() {
		return _view;
	}

	@Override
	public void enable() {

	}

	@Override
	public void disable() {

	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void send_to_server() throws ConventionException, RowsExceededException, WriteException, BiffException, IOException, NotBoundException {
		GeneralInfoController info = GeneralInfoController.getInstance();
		PCR pcr = new PCR(-1,Calendar.getInstance(),info.get_view().get_titleTxtField().getText(),
				info.get_view().get_speciesComboBox().getSelectedItem().toString(),
				info.get_view().get_descriptionTxtField().getText(),info.get_project(),info.get_view().get_summaryTextArea().getText(),
				info.get_view().get_overallDesignTxtArea().getText(),info.get_view().get_contributorTxtField().getText(),
				info.get_view().get_experimentList().getSelectedValue().toString(),
				_view.get_growthProtocolTxtArea().getText(),_view.get_treatmentProtocolTxtArea().getText(),
				_view.get_extractProtocolTxtArea().getText(),_view.get_dataProcessingTxtArea().getText(),
				_view.get_labelProtocolTxtArea().getText(),_view.get_valueDefinitionTxtArea().getText());
		ServerInterface.getInstance().get_stub().createPCRDirectory(pcr);
	}
}
