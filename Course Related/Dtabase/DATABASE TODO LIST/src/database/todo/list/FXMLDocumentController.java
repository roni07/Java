package database.todo.list;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {

    @FXML
    private ListView<TodoList> TitleListDisplay;
    private ObservableList<TodoList> titleList;

    @FXML
    private ListView<TodoList> TodoListDisplay;
    private ObservableList<TodoList> todoList;

    @FXML
    private ListView<TodoList> CompletedListDisplay;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField titleField;
    @FXML
    private TextField itemFiled;

    private final String HOSTNAME = "localhost";
    private final String DBNAME = "new_TodoList";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;

    private Connection connection;
    private Statement statement;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        titleList = FXCollections.observableArrayList() ;
        TitleListDisplay.setItems(titleList);
        
        try {
            connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            System.out.println("okay");
            statement = connection.createStatement();
            String query = "select Date, title from TitleList";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String date = resultSet.getString("Date");
                String title = resultSet.getString("title");
                
                titleList.add(new TodoList(date, title)) ;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleAdd(ActionEvent event) {
        try {
            connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            System.out.println("okay");
            
            String date = datePicker.getValue().toString();
            String title = titleField.getText();
            
            statement = connection.createStatement();
            String query = "insert into TitleList values('" + date + "','" + title + "');";
            int row = statement.executeUpdate(query);
            titleList.add(new TodoList(date, title));
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleSave(ActionEvent event) {
    }

    @FXML
    private void handleDelete(ActionEvent event) {
    }

}
