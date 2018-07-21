package update.a.table;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FXMLDocumentController implements Initializable {
    @FXML
    private TableView<Sport> TableView;
    private ObservableList<Sport> tableList;
    
    @FXML
    private TableColumn<Sport, String> toolColumn;
    @FXML
    private TableColumn<Sport, Number> quantityColumn;
    
    private final String host_name = "localhost" ;
    private final String dbname = "update_test";
    private final String username = "root";
    private final String pass = "";
    private final String ur_l = "jdbc:mysql://" + host_name + "/" + dbname;
    
    private Connection connection;
    
    private Sport select;
    private int Index;
    @FXML
    private TextField toolsField;
    @FXML
    private TextField quantityField;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableList = FXCollections.observableArrayList();
        TableView.setItems(tableList);
        
        toolColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSport()));
        quantityColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getQuantity()));
        
        try {
            connection = DriverManager.getConnection(ur_l, username, pass);
            
            String query = "select sport,quantity from updateT";
            
            Statement statement = connection.createStatement();
            
            ResultSet s =  statement.executeQuery(query);
            
            while(s.next()){
                String Sport_Tool = s.getString("sport");
                int Quantity = s.getInt("quantity");
                
                tableList.add(new Sport(Sport_Tool,Quantity));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handleUpdate(ActionEvent event) {
        try {
            String sport_tools = toolsField.getText();
            
            int decr = select.getQuantity();
            decr = decr -1 ;
            String query = "update updateT set quantity = '"+decr+"' where sport = '"+sport_tools+"' " ;
            PreparedStatement st = connection.prepareStatement(query);
            st.executeUpdate();
            
            Sport sp = new Sport(sport_tools, decr);
            tableList.set(Index, sp);
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void selectAction(MouseEvent event) {
        select = TableView.getSelectionModel().getSelectedItem();
        Index = TableView.getSelectionModel().getSelectedIndex();
        toolsField.setText(select.getSport());
        quantityField.setText(select.getQuantity()+"");
    }
    
}
