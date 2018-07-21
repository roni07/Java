/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentformdemo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Mehedi
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ListView<Student> ListIdView;
    private ObservableList<Student> IDdetails ;
    
    
    @FXML
    private ListView<String> colaborateStudentId;
    private ObservableList<String> colaborate ;
    
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private DatePicker datePicker;
    private Student selected ;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IDdetails = FXCollections.observableArrayList() ;
        colaborate = FXCollections.observableArrayList() ;
        colaborateStudentId.setItems(colaborate) ;
        ListIdView.setItems(IDdetails) ;
        
        try{
            RandomAccessFile input = new RandomAccessFile("studentlist.txt","r") ;
            while(true){
            String id = input.readLine() ;
            if(id == null){
                break ;
            }
            String name = input.readLine() ;
            String date = input.readLine() ;
            Student details = new Student(id,name,LocalDate.parse(date) ) ;
            
            IDdetails.add(details) ;
            }
        }
        catch(FileNotFoundException fnfe){
            System.out.println("File not found !!");
        }
        catch(IOException ioe){
            System.out.println("Exception");
        }
        
    }    

    @FXML
    private void ListIdSelection(MouseEvent event) {
        colaborate.clear() ;
        Student allDetails = ListIdView.getSelectionModel().getSelectedItem() ;
        idField.setText(allDetails.getId()) ;
        nameField.setText(allDetails.getName()) ;
        datePicker.setValue(allDetails.getDate()) ; 
        
        colaborate.add(allDetails.getId()) ;
        colaborate.add(allDetails.getName()) ;
        colaborate.add(allDetails.getDate().toString()) ;
        
        colaborateStudentId.setItems(colaborate);
        
    }

    @FXML
    private void newButton(ActionEvent event) {
        clearForm() ;
    }

    @FXML
    private void resetButton(ActionEvent event) {
        clearForm() ;
        colaborate.clear() ;
    }

    @FXML
    private void saveButton(ActionEvent event) {
        String date ;
        String id = idField.getText() ;
        String name = nameField.getText() ;
        if(datePicker.getValue()==null){
            date = null ;
        }
        else
        {
            date = datePicker.getValue().toString() ;
        }
        if(selected!=null){
            selected.setId(id);
            selected.setName(name);
            selected.setDate(LocalDate.parse(date));
        }
       if(!id.equals("") && !name.equals("")&&date!=null){
        try{
            Student student = new Student(id,name,LocalDate.parse(date)) ;
            IDdetails.add(student) ;
            RandomAccessFile output = new RandomAccessFile("studentlist.txt","rw") ;
            for(int i = 0 ; i < IDdetails.size() ; i++){
                Student s = IDdetails.get(i) ;
                String format = String.format("%s\r\n%s\r\n%s\r\n",s.getId(),s.getName(),s.getDate()) ;
                output.writeBytes(format);
            }
        }
       
        catch(FileNotFoundException fnfe){
            System.out.println("File Not found");
        }
        catch(IOException ioe){
            System.out.println("oops");
        }
        clearForm() ;
       }
        
        
    }
    
    private void clearForm(){
        idField.clear() ;
        nameField.clear();
        datePicker.setValue(null) ;
    }
    
}
