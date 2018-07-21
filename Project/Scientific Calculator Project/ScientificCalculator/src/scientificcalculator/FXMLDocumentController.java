/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Roni
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField displayField;
    
    private double operand1;
    private double operand2;
    private String opertaor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }


    @FXML
    private void handleTwo(ActionEvent event) {
        String firstText = displayField.getText();
        String newText = firstText + "2";
        System.out.println(newText);
        displayField.setText(newText);
    }

    @FXML
    private void handleThree(ActionEvent event) {
        String firstText = displayField.getText();
        String newText = firstText + "3";
        System.out.println(newText);
        displayField.setText(newText);
    }

  
    @FXML
    private void handleAllClear(ActionEvent event) {
        displayField.clear();
    }

    
    //Subtraction part
    @FXML
    private void handleSubtraction(ActionEvent event) {
        String firstText = displayField.getText();
        String newText = firstText + "-";
        System.out.println(newText);
        operand1 = Double.parseDouble(displayField.getText());
        System.out.println(operand1);
        displayField.setText(newText);
    }

    //end subtraction part
    
    
    //Additional Part
    
    @FXML
    private void handleAddition(ActionEvent event) {
        operand1 = Double.parseDouble(displayField.getText());      

        displayField.setText("+");
    }

                     
                     // EQUAL PART
    
    @FXML
    private void handleEqual(ActionEvent event) {
        
        operand2 = Double.parseDouble(displayField.getText());
        System.out.println(operand2);
        double result = operand1 - operand2;
        System.out.println(result);
        displayField.setText(""+result);
    }
    
       

}
