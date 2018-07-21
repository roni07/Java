package ProductAvailabilityView;

import BuyerMaleView.MalePant;

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AvailabilityController implements Initializable {

    @FXML
    private TableView<MalePant> tableView;
    private ObservableList<MalePant> tableList;

    @FXML
    private TableColumn<MalePant, Number> idColumn;
    @FXML
    private TableColumn<MalePant, String> brandNameColumn;
    @FXML
    private TableColumn<MalePant, Number> quantityColumn;

    private final String hostname = "localhost";
    private final String dbname = "Shop_Management";
    private final String username = "root";
    private final String pass = "";
    private final String ur_l = "jdbc:mysql://" + hostname + "/" + dbname;

    private Connection connection;
    @FXML
    private TextField idNumberField;
    @FXML
    private TextField brandNameField;
    @FXML
    private TextField availableQuantityField;
    @FXML
    private Label notification;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableList = FXCollections.observableArrayList();
        tableView.setItems(tableList);

        idColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()));
        brandNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getBrandName()));
        quantityColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getQuantity()));

        try {
            connection = DriverManager.getConnection(ur_l, username, pass);

            Statement statement = connection.createStatement();

            String query = "select * from Male_Pant";

            ResultSet pant = statement.executeQuery(query);

            while (pant.next()) {
                int id = pant.getInt("id");
                String brandname = pant.getString("brand_name");
                double price = pant.getDouble("price");
                int quantity = pant.getInt("quantity");
                tableList.add(new MalePant(id, brandname, price, quantity));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvailabilityController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleSubmit(ActionEvent event) {

        try {
            connection = DriverManager.getConnection(ur_l, username, pass);

            Statement statement = connection.createStatement();

            int id = Integer.parseInt(idNumberField.getText());
            String brandname = brandNameField.getText();
            int quantity = Integer.parseInt(availableQuantityField.getText());

            if (!brandname.equals("")) {

                String query = "insert into request_manager values('" + id + "', '" + brandname + "', '" + quantity + "')";

                int row = statement.executeUpdate(query);
                notification.setText("Submitted By Id = " + id + " Name = " + brandname + " Quantity = " + quantity);
                idNumberField.clear();
                brandNameField.clear();
                availableQuantityField.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Required Field Can Not Be Empty");
                alert.showAndWait();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvailabilityController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException nfe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Required Field Can Not Be Empty");
            alert.showAndWait();
        }

    }

}
