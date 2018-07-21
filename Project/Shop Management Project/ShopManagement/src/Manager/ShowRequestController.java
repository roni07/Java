package Manager;

import BuyerMaleView.MalePant;

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
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ShowRequestController implements Initializable {

    @FXML
    private TableView<MalePantRequest> tableView;
    private ObservableList<MalePantRequest> tableList;

    @FXML
    private TableColumn<MalePantRequest, Number> idColumn;
    @FXML
    private TableColumn<MalePantRequest, String> brandnameColumn;
    @FXML
    private TableColumn<MalePantRequest, Number> quantityColumn;

    private final String hostname = "localhost";
    private final String dbname = "Shop_Management";
    private final String username = "root";
    private final String pass = "";
    private final String ur_l = "jdbc:mysql://" + hostname + "/" + dbname;

    private Connection connection;

    private MalePantRequest select;

    @FXML
    private TableView<MalePant> availablePantTableView;
    private ObservableList<MalePant> availablePantList;

    @FXML
    private TableColumn<MalePant, Number> availablePantId;
    @FXML
    private TableColumn<MalePant, String> availablePantBrand;
    @FXML
    private TableColumn<MalePant, Number> availablePantPrice;
    @FXML
    private TableColumn<MalePant, Number> availablePantQuantity;

    @FXML
    private TextField updateRequestQuantity;

    private MalePant updateSelection;
    private int Index;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableList = FXCollections.observableArrayList();
        tableView.setItems(tableList);

        availablePantList = FXCollections.observableArrayList();
        availablePantTableView.setItems(availablePantList);

        idColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()));
        brandnameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getBrandName()));
        quantityColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getQuantity()));

        availablePantId.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()));
        availablePantBrand.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getBrandName()));
        availablePantPrice.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrice()));
        availablePantQuantity.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getQuantity()));

        try {
            connection = DriverManager.getConnection(ur_l, username, pass);

            Statement malePantStatement = connection.createStatement();

            Statement availableView = connection.createStatement();

            String malePant = "select * from request_manager";

            String availableProduct = "select * from male_pant";

            ResultSet male = malePantStatement.executeQuery(malePant);

            ResultSet available = availableView.executeQuery(availableProduct);

            while (male.next()) {
                int id = male.getInt("id");
                String brandname = male.getString("brand_name");
                int quantity = male.getInt("quantity");
                tableList.add(new MalePantRequest(id, brandname, quantity));
            }

            while (available.next()) {
                int id = available.getInt("id");
                String brandname = available.getString("brand_name");
                double price = available.getDouble("price");
                int quantity = available.getInt("quantity");
                availablePantList.add(new MalePant(id, brandname, price, quantity));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowRequestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleDelete(ActionEvent event) {

        try {
            connection = DriverManager.getConnection(ur_l, username, pass);

            if (select != null) {
                String query = "DELETE FROM request_manager WHERE id = " + select.getId();
                PreparedStatement st = connection.prepareStatement(query);
                st.executeUpdate();
                tableList.remove(select);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("oop's table is empty");
                alert.showAndWait();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowRequestController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void selectAction(MouseEvent event) {
        select = tableView.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void handleRequestUpdate(ActionEvent event) {
        try {

            int id = updateSelection.getId();
            int update = Integer.parseInt(updateRequestQuantity.getText());

            String query = "update male_pant set quantity = '" + update + "' where id = '" + id + "'";
            PreparedStatement st = connection.prepareStatement(query);
            st.executeUpdate();
            MalePant mp = new MalePant(updateSelection.getId(), updateSelection.getBrandName(), updateSelection.getPrice(), update);
            availablePantList.set(Index, mp);
        } catch (SQLException ex) {
            Logger.getLogger(ShowRequestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException npe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText(null);
            alert.setContentText("Required Field Can Not Be Empty");
            alert.showAndWait();
        }
    }

    @FXML
    private void updateRequestSelection(MouseEvent event) {
        updateSelection = availablePantTableView.getSelectionModel().getSelectedItem();
        Index = availablePantTableView.getSelectionModel().getSelectedIndex();
        updateRequestQuantity.setText(updateSelection.getQuantity() + "");
    }

}
