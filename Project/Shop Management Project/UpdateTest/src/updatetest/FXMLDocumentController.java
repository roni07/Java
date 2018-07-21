
package updatetest;

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
    private TextField idField;
    @FXML
    private TextField nameField;

    private final String host_name = "localhost";
    private final String db_name = "update_test";
    private final String user_name = "root";
    private final String pass = "";
    private final String ur_l = "jdbc:mysql://" + host_name + "/" + db_name;

    private Connection connection;

    @FXML
    private TableView<TstC> tableView;
    private ObservableList<TstC> view;

    @FXML
    private TableColumn<TstC, Number> idColumn;
    @FXML
    private TableColumn<TstC, String> nameColumn;

    private TstC select;
    private int Index;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        view = FXCollections.observableArrayList();
        tableView.setItems(view);
        idColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()));
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));

        try {

            connection = DriverManager.getConnection(ur_l, user_name, pass);
            String query = "select id, name from Test";

            Statement statement = connection.createStatement();
            ResultSet s = statement.executeQuery(query);
            while (s.next()) {
                int id = s.getInt("id");
                String name = s.getString("name");
                view.add(new TstC(id, name));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void updateAction(ActionEvent event) {
        try {

            String ID = idField.getText();
            String Name = nameField.getText();

            int incr = select.getId();
            incr = incr - 1;
            String query = "update Test set id = '"+ incr +"' where name = '"+ Name +"'";
            PreparedStatement st = connection.prepareStatement(query);
            st.executeUpdate();
            
            TstC t = new TstC(incr, Name);
            view.set(Index, t);
            idField.clear();
            nameField.clear();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickAction(MouseEvent event) {
        select = tableView.getSelectionModel().getSelectedItem();
        Index =  tableView.getSelectionModel().getSelectedIndex();
        idField.setText(select.getId() + "");
        nameField.setText(select.getName());
    }
}
