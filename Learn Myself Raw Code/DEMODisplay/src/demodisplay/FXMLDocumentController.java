package demodisplay;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField displayField;
    private double operand1;
    private double operand2;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleFour(ActionEvent event) {
        String newT = displayField.getText();
        String finalT = newT + "4";
        displayField.setText(finalT);
    }

    @FXML
    private void handleFive(ActionEvent event) {
        String newT = displayField.getText();
        String finalT = newT + "5";
        displayField.setText(finalT);
    }

    @FXML
    private void handlePlus(ActionEvent event) {
         operand1 = Double.parseDouble(displayField.getText());
//        System.out.println(operand1);
         displayField.setText(operand1 + "+");
//         displayField.setText("+");
    }

    @FXML
    private void handleEqual(ActionEvent event) {
       
        System.out.println(displayField.getText());
//        operand2 = Double.parseDouble(displayField.getText());
//        System.out.println(operand2);
//        
//        double result  = operand1 + operand2 ;
//        displayField.setText(""+result);
//        System.out.println(result);
    }

    @FXML
    private void handleClear(ActionEvent event) {
        displayField.clear();
    }

}
