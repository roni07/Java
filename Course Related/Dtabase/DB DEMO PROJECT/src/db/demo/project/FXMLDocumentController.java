package db.demo.project;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField productIdField;
    @FXML
    private TextField productNameField;
    @FXML
    private TextField unitPriceField;
    @FXML
    private ComboBox<UnitType> comboBoxUnit;
    @FXML
    private TableView<Product> tableView;
    private ObservableList<Product> tableViewList;

    @FXML
    private TableColumn<Product, Number> productIdTableColomun;
    @FXML
    private TableColumn<Product, String> productNameTableColomun;

    private Connection connection;
    private Statement statement;
    private Product selectedProduct;

    private final String HOSTNAME = "localhost";
    private final String DBNAME = "products";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private final String URL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        comboBoxUnit.setItems(FXCollections.observableArrayList(UnitType.values()));
        tableViewList = FXCollections.observableArrayList();
        tableView.setItems(tableViewList);

        productIdTableColomun.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getProductID()));
        productNameTableColomun.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getProductName()));

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.err.println("Connection OKAY");
            statement = connection.createStatement();

            String query = "select productID, productName, unitPrice, unitType from productdetails ";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int ProductId = resultSet.getInt("productID");
                String ProductName = resultSet.getString("productName");
                double UnitPrice = resultSet.getDouble("unitPrice");
                String unit = resultSet.getString("unitType");
                Product p = new Product(ProductId, ProductName, UnitPrice, unit);
                tableViewList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleAddProduct(ActionEvent event) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection okay");

            int id = Integer.parseInt(productIdField.getText());
            String productName = productNameField.getText();
            double unitPrice = Double.parseDouble(unitPriceField.getText());
            UnitType unit = comboBoxUnit.getValue();
            statement = connection.createStatement();
            String query = "insert into productdetails values(" + "" + id + "," + "'" + productName + "'," + "" + unitPrice + "," + "'" + unit + "');";
            int row = statement.executeUpdate(query);
            tableViewList.add(new Product(id, productName, unitPrice, unit.toString()));

        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickAct(MouseEvent event) {
        selectedProduct = tableView.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void handleUpdateProduct(ActionEvent event) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM productdetails WHERE productID = " + selectedProduct.getProductID());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(NullPointerException npe){
            
        }
        tableViewList.remove(selectedProduct);
    }

}
