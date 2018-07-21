package db.gui.demo;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField taskIdField;
    @FXML
    private TextField taskNameField;
    @FXML
    private TextField todoIdField;
    @FXML
    private Label StatusLabel;

    @FXML
    private ListView<todoList> listview;
    private ObservableList<todoList> list;

    @FXML
    private TableView<todoList> TodoTaskTableView;
    @FXML
    private TableColumn<todoList, Number> TaskIdTable;
    @FXML
    private TableColumn<todoList, String> TaskNameTable;
    @FXML
    private TableColumn<todoList, Number> TodoIdTable;

    private final String HOSTNAME = "localhost";
    private final String DBNAME = "todolist";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list = FXCollections.observableArrayList();
        listview.setItems(list);
        TodoTaskTableView.setItems(list) ;
        
        TaskIdTable.setCellValueFactory(data-> new SimpleIntegerProperty(data.getValue().getId()));
        TaskNameTable.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getTaskName()));
        TodoIdTable.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getTodoId()));
        
        try {
            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            StatusLabel.setText("Connection OKAY");

            Statement statement = connection.createStatement();
            String query = "select id, task, todoId from todotask";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String task = resultSet.getString("task");
                int todoId = resultSet.getInt("todoId");
                /*todoList t = new todoList(id, task, todoId);
                list.add(t);  */
                
                list.add(new todoList(id, task, todoId)) ;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addTaskAction(ActionEvent event) {
        try {
            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            StatusLabel.setText("Connection OKAY");

            int idName = Integer.parseInt(taskIdField.getText());
            String taskName = taskNameField.getText();
            int todoID = Integer.parseInt(todoIdField.getText());

            Statement statement = connection.createStatement();
            String query = "insert into todotask values(" + idName + ",'" + taskName + "'," + todoID + ");";
            int row = statement.executeUpdate(query);
            StatusLabel.setText("Inserted task with ID " + idName);
            list.add(new todoList(idName, taskName, todoID)) ;
            clearForm();

        } catch (SQLException ex) {
            Alert alert = new Alert(AlertType.ERROR, "Something went wrong");
            alert.show();
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException nfe) {
            Alert alert = new Alert(AlertType.ERROR, "Something went wrong");
            alert.show();
        }
    }

    private void clearForm() {
        taskIdField.clear();
        taskNameField.clear();
        todoIdField.clear();
    }
}
