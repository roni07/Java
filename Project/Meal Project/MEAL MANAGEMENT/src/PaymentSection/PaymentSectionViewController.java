package PaymentSection;

import MemberList.Members;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class PaymentSectionViewController implements Initializable {

    private final String hostname = "localhost";
    private final String dbname = "meal_management";
    private final String username = "root";
    private final String pass = "";
    private final String ur_l = "jdbc:mysql://" + hostname + "/" + dbname;

    private Connection connection;
    
    
    @FXML
    private ComboBox<Members> nameField;
    private ObservableList<Members> nameList;
    
    @FXML
    private DatePicker dateField;
    @FXML
    private TextField paymentField;
    
    private ObservableList<Payment> paymentList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nameList = FXCollections.observableArrayList();
        nameField.setItems(nameList);
        
        paymentList = FXCollections.observableArrayList();
        
        try {
            connection = DriverManager.getConnection(ur_l, username, pass);
            Statement paymentStatement = connection.createStatement();
            
            String nameQuery = "select * from member_list";
            
            ResultSet nameResult = paymentStatement.executeQuery(nameQuery);
            
            while(nameResult.next()){
                String name = nameResult.getString("name");
                String phn = nameResult.getString("phn_num");
                
                nameList.add(new Members(name, phn));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PaymentSectionViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void insertAction(ActionEvent event) {
        
        try {
            connection = DriverManager.getConnection(ur_l, username, pass);
            Statement paymentStatement = connection.createStatement();
            
            Members name = nameField.getSelectionModel().getSelectedItem();
            double payment = Double.parseDouble(paymentField.getText());
            String date = dateField.getValue().toString();
            
            String paymentQuery = "insert into payment_list values('"+name.getName()+"', "+payment+", '"+date+"', '"+name.getPhoneNum()+"')";
            
            int paymentInsert = paymentStatement.executeUpdate(paymentQuery);
            
            paymentList.add(new Payment(name.getName(), payment, date));
            
        } catch (SQLException ex) {
            Logger.getLogger(PaymentSectionViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
