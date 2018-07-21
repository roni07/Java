/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Roni
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField displayField;
    @FXML
    private Label label;

    double operand1;
    double operand2;
    String operator;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    //Button Part
    @FXML
    private void handleZero(ActionEvent event) {
        
        String oldText = displayField.getText();
        String newText = oldText + "0";
        displayField.setText(newText);
       
    }

    @FXML
    private void handelOne(ActionEvent event) {
        String oldText = displayField.getText();
        String newText = oldText + "1";
        displayField.setText(newText);
    }

    @FXML
    private void handleTwo(ActionEvent event) {

        String oldText = displayField.getText();
        String newText = oldText + "2";
        displayField.setText(newText);
    }

    @FXML
    private void handleThree(ActionEvent event) {

        String oldText = displayField.getText();
        String newText = oldText + "3";
        displayField.setText(newText);
    }

    @FXML
    private void handleFoure(ActionEvent event) {

        String oldText = displayField.getText();
        String newText = oldText + "4";
        displayField.setText(newText);
    }

    @FXML
    private void handleFive(ActionEvent event) {

        String oldText = displayField.getText();
        String newText = oldText + "5";
        displayField.setText(newText);
    }

    @FXML
    private void handleSix(ActionEvent event) {

        String oldText = displayField.getText();
        String newText = oldText + "6";
        displayField.setText(newText);
    }

    @FXML
    private void handleSeven(ActionEvent event) {

        String oldText = displayField.getText();
        String newText = oldText + "7";
        displayField.setText(newText);
    }

    @FXML
    private void handleEight(ActionEvent event) {

        String oldText = displayField.getText();
        String newText = oldText + "8";
        displayField.setText(newText);
    }

    @FXML
    private void handleNine(ActionEvent event) {

        String oldText = displayField.getText();
        String newText = oldText + "9";
        displayField.setText(newText);
    }

    @FXML
    private void handleDot(ActionEvent event) {
        String oldText = displayField.getText();

        if (!oldText.contains(".")) {
            String newText = oldText + ".";
            displayField.setText(newText);
        }
    }

                     //Operator Part
    @FXML
    private void handelAdd(ActionEvent event) {
        
       
        operand1 = Double.parseDouble(displayField.getText());
        operator = "ADD";
        displayField.setText("");
       

    }

    @FXML
    private void handelSubtract(ActionEvent event) {

        
        operand1 = Double.parseDouble(displayField.getText());
        operator = "SUBTRACT";
        displayField.setText("");
        
    }

    @FXML
    private void handelMultiplication(ActionEvent event) {
     
        
        operand1 = Double.parseDouble(displayField.getText());
        operator = "MULTIPLICATION";
        displayField.setText("");
    }

    @FXML
    private void handelDivition(ActionEvent event) {
       
        
        operand1 = Double.parseDouble(displayField.getText());
        operator = "DIVITION";
        displayField.setText("");
    }

    @FXML
    private void handleSqr(ActionEvent event) {
        
        operand1 = Double.parseDouble(displayField.getText());
        double result = Math.pow(operand1, 2);
        displayField.setText("" + result);
    }
    
    @FXML
    private void handleSqrtButton(ActionEvent event) {
        
        operand1 = Double.parseDouble(displayField.getText());
        double result = Math.sqrt(operand1);
        displayField.setText("" + result);
    }

    
                            //Answer part

    @FXML
    private void handleAnswer(ActionEvent event) {

        if (operator == null) {
            return;
        }

        operand2 = Double.parseDouble(displayField.getText());
        Double result = 0.0;
        switch (operator) {

            case "ADD":
                result = operand1 + operand2;
                break;

            case "SUBTRACT":
                result = operand1 - operand2;
                break;

            case "MULTIPLICATION":
                result = operand1 * operand2;
                break;

            case "DIVITION":
                result = operand1 / operand2;
                break;
        }
        
        displayField.setText("" + result);

    }

                  //All Clear Part
    
    @FXML
    private void handelAllclear(ActionEvent event) {
        displayField.setText("");
    }

    
                     //Clear Part
    
    @FXML
    private void handleClear(ActionEvent event) {
        String oldText = displayField.getText() ;
        if(oldText.length() > 0){
            String newText = oldText.substring(0,oldText.length()-1) ;
            displayField.setText(newText) ;
        }
    }

}
