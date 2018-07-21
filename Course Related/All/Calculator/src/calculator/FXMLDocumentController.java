/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

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
    private Label label;
    @FXML
    private TextField displayField;
    
    
    double operand1 ;
    double operand2 ;
    String operator ; 
    boolean hasMultipleComputation ;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

              //Digits Part
    
   
    
    public String removeLeadingZeroes(String oldText) {
        if(oldText.startsWith ("0") && !oldText.startsWith("0.")){
           int count = 0 ;
           for(int i = 0 ; i<oldText.length() ; i++){
               if(oldText.charAt(i) == '0'){
                   count++ ;
               } else{
                   break ;
               }
           }
           oldText = oldText.substring(count) ;
        }
        return oldText ;
    }
    
        @FXML
    private void handleZeroAction(ActionEvent event) {
       String oldText = displayField.getText() ; 
       oldText = removeLeadingZeroes(oldText) ;
       String newText = oldText + "0" ;
       displayField.setText(newText);
    }
    
    @FXML
    private void handleOneAction(ActionEvent event) {
       String oldText = displayField.getText() ; 
       String newText = oldText +"1" ;
       displayField.setText(newText);
    }
    
    @FXML
    private void handleTwoAction(ActionEvent event) {
       String oldText = displayField.getText() ; 
       String newText = oldText +"2" ;
       displayField.setText(newText);
    }
    
    @FXML
    private void handleThreeAction(ActionEvent event) {
       String oldText = displayField.getText() ; 
       String newText = oldText +"3" ;
       displayField.setText(newText);
    }
    
    @FXML
    private void handleFourAction(ActionEvent event) {
       String oldText = displayField.getText() ; 
       String newText = oldText +"4" ;
       displayField.setText(newText);
    }
    
    @FXML
    private void handleFiveAction(ActionEvent event) {
       String oldText = displayField.getText() ; 
       String newText = oldText +"5" ;
       displayField.setText(newText);
    }

    @FXML
    private void handleSixAction(ActionEvent event) {
       String oldText = displayField.getText() ; 
       String newText = oldText +"6" ;
       displayField.setText(newText);
    }

    @FXML
    private void handleSevenAction(ActionEvent event) {
       String oldText = displayField.getText() ; 
       String newText = oldText +"7" ;
       displayField.setText(newText);
    }
    
    
    @FXML
    private void handleEightAction(ActionEvent event) {
       String oldText = displayField.getText() ; 
       String newText = oldText +"8" ;
       displayField.setText(newText);
    }

    
    @FXML
    private void handleNineAction(ActionEvent event) {
       String oldText = displayField.getText() ; 
       String newText = oldText +"9" ;
       displayField.setText(newText);
    }
    
        @FXML
    private void handleDotAction(ActionEvent event) {
       String oldText = displayField.getText() ;
       if(!oldText.contains(".")){
       String newText = oldText +"." ;
       displayField.setText(newText);
       }
    }

                // operator part
    
        
    @FXML
    private void handleAdditionAction(ActionEvent event) {
        
        if(!hasMultipleComputation){
        operand1 = Double.parseDouble(displayField.getText() ) ;
        operator = "add" ;
        displayField.setText("") ;
        hasMultipleComputation = true ;
        }
        else{
                    double result ;
        operand2 = Double.parseDouble(displayField.getText() ) ;
        switch(operator){
            case "add" :
                result = operand1 + operand2 ;
                displayField.setText("" + result) ;
                break ;
                
            case "subtract" :
                result = operand1 - operand2 ;
                displayField.setText("" + result) ;
                break ;
                
            case "multiplication" :
                result = operand1 * operand2 ;
                displayField.setText("" + result) ;
                break ;
                
            case "divition" :
                result = operand1 / operand2 ;
                displayField.setText("" + result) ;
                break ;
            default :
                break ;
        }
         hasMultipleComputation = false ;
        }
    }
    
    
    @FXML
    private void handleSubtractAction(ActionEvent event) {
        
        if(!hasMultipleComputation){
        operand1 = Double.parseDouble(displayField.getText() ) ;
        operator = "subtract" ;
        displayField.setText("") ;
        hasMultipleComputation = true ;
        }
        else{
        double result ;
        operand2 = Double.parseDouble(displayField.getText() ) ;
        switch(operator){
            case "add" :
                result = operand1 + operand2 ;
                displayField.setText("" + result) ;
                break ;
                
            case "subtract" :
                result = operand1 - operand2 ;
                displayField.setText("" + result) ;
                break ;
                
            case "multiplication" :
                result = operand1 * operand2 ;
                displayField.setText("" + result) ;
                break ;
                
            case "divition" :
                result = operand1 / operand2 ;
                displayField.setText("" + result) ;
                break ;
            default :
                break ; 
        }
        hasMultipleComputation = false ;
        }
    }

    @FXML
    private void handleMultiplicationAction(ActionEvent event) {
       
        if(!hasMultipleComputation){
        operand1 = Double.parseDouble(displayField.getText() ) ;
        operator = "multiplication" ;
        displayField.setText("") ;
        hasMultipleComputation = true ;
        }
        
        else{
        double result  ;
        operand2 = Double.parseDouble(displayField.getText() ) ;
        switch(operator){
            case "add" :
                result = operand1 + operand2 ;
                displayField.setText("" + result) ;
                break ;
                
            case "subtract" :
                result = operand1 - operand2 ;
                displayField.setText("" + result) ;
                break ;
                
            case "multiplication" :
                result = operand1 * operand2 ;
                displayField.setText("" + result) ;
                break ;
                
            case "divition" :
                result = operand1 / operand2 ;
                displayField.setText("" + result) ;
                break ;
            default :
                break ; 
        }
        hasMultipleComputation = false ;
        }
    }

    @FXML
    private void handleDivitionAction(ActionEvent event) {
        if(!hasMultipleComputation){
        operand1 = Double.parseDouble(displayField.getText() ) ;
        operator = "divition" ;
        displayField.setText("") ;
        hasMultipleComputation = true ;
        }
        
        else{
        double result ;
        operand2 = Double.parseDouble(displayField.getText() ) ;
        switch(operator){
            case "add" :
                result = operand1 + operand2 ;
                displayField.setText("" + result) ;
                break ;
                
            case "subtract" :
                result = operand1 - operand2 ;
                displayField.setText("" + result) ;
                break ;
                
            case "multiplication" :
                result = operand1 * operand2 ;
                displayField.setText("" + result) ;
                break ;
                
            case "divition" :
                result = operand1 / operand2 ;
                displayField.setText("" + result) ;
                break ;
            default :
                break ; 
        }
        hasMultipleComputation = false ;
        }
    }

        @FXML
    private void handleSquareAction(ActionEvent event) {
        operand1 = Double.parseDouble(displayField.getText() ) ;
        double result = Math.pow(operand1, 2) ;
        displayField.setText("" + result) ;
    }

    @FXML
    private void handleSquareRootAction(ActionEvent event) {
        operand1 = Double.parseDouble(displayField.getText() ) ;
        double result = Math.sqrt(operand1) ;
        displayField.setText("" + result) ;
    }
    
                           // All clear
    
    @FXML
    private void handleAllClearAction(ActionEvent event) {
        
        displayField.setText("");
    }

                           // Clear part
    
    @FXML
    private void handleClearAction(ActionEvent event) {
        String oldText = displayField.getText() ;
        if(oldText.length() > 0){
            String newText = oldText.substring(0,oldText.length()-1) ;
            displayField.setText(newText) ;
        }
    }

                              // Answer part
     
    @FXML
    private void handleEqualAction(ActionEvent event) {
        if(operator == null){
            return ;
        }
        double result = 0.0 ;
        operand2 = Double.parseDouble(displayField.getText() ) ;
        switch(operator){
            case "add" :
                result = operand1 + operand2 ;
                break ;
                
            case "subtract" :
                result = operand1 - operand2 ;
                break ;
                
            case "multiplication" :
                result = operand1 * operand2 ;
                break ;
                
            case "divition" :
                result = operand1 / operand2 ;
                break ;
        }
        displayField.setText("" + result) ;
    }


    
}
