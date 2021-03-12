package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class ViewController implements Initializable {
	@FXML
	private TextField txtNum1;
	
	@FXML
	private TextField txtNum2;
	
	@FXML
	private Label labelresult; 
	
	@FXML
	private Button  btSum;
	
	@FXML
	public void onBtSumAction() {
		
		try {
			
			Locale.setDefault(Locale.US);
			double number1 = Double.parseDouble(txtNum1.getText());
			double number2 = Double.parseDouble(txtNum2.getText());
			double sum = number1 + number2;
			labelresult.setText(String.format("%.2f", sum));
			
		}
		catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}

		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Constraints.setTextFieldDouble(txtNum1);
		Constraints.setTextFieldDouble(txtNum2);
		Constraints.setTextFieldMaxLength(txtNum1, 12);
		Constraints.setTextFieldMaxLength(txtNum2, 12);
		
	}
}

