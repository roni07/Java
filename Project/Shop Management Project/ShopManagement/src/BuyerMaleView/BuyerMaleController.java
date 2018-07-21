package BuyerMaleView;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BuyerMaleController implements Initializable {

    @FXML
    private TableView<MalePant> pantTableView;
    private ObservableList<MalePant> pantList;

    @FXML
    private TableColumn<MalePant, Number> pantIdColumn;
    @FXML
    private TableColumn<MalePant, String> pantBrandNameColumn;
    @FXML
    private TableColumn<MalePant, Number> pantPriceColumn;
    @FXML
    private TableColumn<MalePant, Number> pantQuantityColumn;

    @FXML
    private TableView<MaleShirt> shirtTableView;
    private ObservableList<MaleShirt> shirtList;

    @FXML
    private TableColumn<MaleShirt, Number> shirtIdColumn;
    @FXML
    private TableColumn<MaleShirt, String> shirtBrandNameColumn;
    @FXML
    private TableColumn<MaleShirt, Number> shirtPriceColumn;
    @FXML
    private TableColumn<MaleShirt, Number> shirtQuantityColumn;

    private MalePant selectedPant;
    private MaleShirt selectedShirt;

    private final String host_name = "localhost";
    private final String db_name = "Shop_Management";
    private final String user_name = "root";
    private final String pass = "";
    private final String ur_l = "jdbc:mysql://" + host_name + "/" + db_name;

    private Connection connection;
    private Statement statement;

    @FXML
    private Button Close;

    private TextField shirtIdField;
    private TextField shirtPriceField;
    private TextField shirtBrandField;

    private MalePant PantSelect;
    private MaleShirt ShirtSelect;

    private int Index;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        pantList = FXCollections.observableArrayList();
        shirtList = FXCollections.observableArrayList();

        pantTableView.setItems(pantList);

        shirtTableView.setItems(shirtList);

        pantIdColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()));
        pantBrandNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getBrandName()));
        pantPriceColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrice()));
        pantQuantityColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getQuantity()));

        shirtIdColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()));
        shirtBrandNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getBrandName()));
        shirtPriceColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrice()));
        shirtQuantityColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getQuantity()));

        try {
            connection = DriverManager.getConnection(ur_l, user_name, pass);
            Statement pantStatement = connection.createStatement();
            Statement shirtStatement = connection.createStatement();

            String pantQuery = "select * from Male_Pant";
            String shirtQuery = "select * from Male_Shirt";

            ResultSet pant = pantStatement.executeQuery(pantQuery);
            ResultSet shirt = shirtStatement.executeQuery(shirtQuery);

            while (pant.next()) {
                int id = pant.getInt("id");
                String brand_name = pant.getString("brand_name");
                double price = pant.getDouble("price");
                int quantity = pant.getInt("quantity");
                pantList.add(new MalePant(id, brand_name, price, quantity));
            }

            while (shirt.next()) {
                int id = shirt.getInt("id");
                String brand_name = shirt.getString("brand_name");
                double price = shirt.getDouble("price");
                int quantity = shirt.getInt("quantity");
                shirtList.add(new MaleShirt(id, brand_name, price, quantity));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BuyerMaleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlePantBuyAction(ActionEvent event) {
        try {

            int id = PantSelect.getId();

            int buy = PantSelect.getQuantity();
            buy = buy - 1;

            String query = "update male_pant set quantity = '" + buy + "' where id = '" + id + "'";

            PreparedStatement sp = connection.prepareStatement(query);
            sp.executeUpdate();

            MalePant mp = new MalePant(id, PantSelect.getBrandName(), PantSelect.getPrice(), buy);
            pantList.set(Index, mp);

        } catch (SQLException ex) {
            Logger.getLogger(BuyerMaleController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void handleShirtBuyAction(ActionEvent event) {
        try {

            int id = ShirtSelect.getId();
            
            int buy = ShirtSelect.getQuantity();
            buy = buy - 1;

            String query = "update male_shirt set quantity = '" + buy + "' where id = '" + id + "'";

            PreparedStatement sp = connection.prepareStatement(query);
            sp.executeUpdate();

            MaleShirt ms = new MaleShirt(id, ShirtSelect.getBrandName(), ShirtSelect.getPrice(), buy);
            shirtList.set(Index, ms);

        } catch (SQLException ex) {
            Logger.getLogger(BuyerMaleController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void handleClose(ActionEvent event) {
        Stage staget = (Stage) Close.getScene().getWindow();
        staget.close();
    }

    @FXML
    private void selectPantTable(MouseEvent event) {
        PantSelect = pantTableView.getSelectionModel().getSelectedItem();
        Index = pantTableView.getSelectionModel().getSelectedIndex();
    }

    @FXML
    private void selectShirtTable(MouseEvent event) {
        ShirtSelect = shirtTableView.getSelectionModel().getSelectedItem();
        Index = shirtTableView.getSelectionModel().getSelectedIndex();
    }

}
