package numberconverter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField inputField;
    @FXML
    private Label outputField;
    long DecimalValue;
    long OctalValue ;
    String HexadecimalValue ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void HandleConvertAction(ActionEvent event) {
//        DecimalToBinary decimalNumber = new DecimalToBinary() ;
//        DecimalValue = Long.parseLong(inputField.getText());
//        outputField.setText(""+decimalNumber.getBinary(DecimalValue));
//        
//        OctalToBinary octalNumber = new OctalToBinary() ;
//        OctalValue = Long.parseLong(inputField.getText()) ;
//        outputField.setText(""+octalNumber.getOctalToBinary(OctalValue)) ;

          HexadecimalToBinary hexNumber = new HexadecimalToBinary() ;
          HexadecimalValue = inputField.getText();
          outputField.setText(""+hexNumber.getHexadecimalToBinary(HexadecimalValue)) ;
    }

    @FXML
    private void handleReset(ActionEvent event) {
        inputField.setText("");
        outputField.setText("");
    }

}
