package BuyerFemaleView;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FemaleJeansController implements Initializable {

    @FXML
    private TableView<Jeans> pantTableView;
    private ObservableList<Jeans> pantList;

    @FXML
    private TableColumn<Jeans, Number> pantIdColumn;
    @FXML
    private TableColumn<Jeans, String> pantBrandNameColumn;
    @FXML
    private TableColumn<Jeans, Number> pantPriceColumn;
    @FXML
    private TableColumn<Jeans, Number> pantQuantityColumn;

    @FXML
    private TableView<ThreePiece> threePieceTableView;
    private ObservableList<ThreePiece> threepieceList;

    @FXML
    private TableColumn<ThreePiece, Number> threePieceIdColumn;
    @FXML
    private TableColumn<ThreePiece, String> threePieceBrandNameColumn;
    @FXML
    private TableColumn<ThreePiece, Number> threePiecePriceColumn;
    @FXML
    private TableColumn<ThreePiece, Number> threePieceQuantityColumn;

    private final String host_name = "localhost";
    private final String db_name = "shop_management";
    private final String user_name = "root";
    private final String pass = "";
    private final String ur_l = "jdbc:mysql://" + host_name + "/" + db_name;

    private Connection connection;
    @FXML
    private Button Close;
    
    private Jeans jeansSelect;
    private ThreePiece threePieceSelect;
    private int Index;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pantList = FXCollections.observableArrayList();
        threepieceList = FXCollections.observableArrayList();

        pantTableView.setItems(pantList);
        threePieceTableView.setItems(threepieceList);

        pantIdColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()));
        pantBrandNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getBrand_name()));
        pantPriceColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrice()));
        pantQuantityColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getQuantity()));

        threePieceIdColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getQuantity()));
        threePieceBrandNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getBrand_name()));
        threePiecePriceColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrice()));
        threePieceQuantityColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getQuantity()));

        try {
            connection = DriverManager.getConnection(ur_l, user_name, pass);

            String pant = "select * from female_pant";
            String three_piece = "select * from female_threepiece";

            Statement pantStatement = connection.createStatement();
            Statement threePieceStatement = connection.createStatement();

            ResultSet pantResult = pantStatement.executeQuery(pant);

            ResultSet threepieceResult = threePieceStatement.executeQuery(three_piece);

            while (pantResult.next()) {
                int id = pantResult.getInt("id");
                String brand_name = pantResult.getString("brand_name");
                double price = pantResult.getDouble("price");
                int quantity = pantResult.getInt("quantity");
                pantList.add(new Jeans(id, brand_name, price, quantity));
            }

            while (threepieceResult.next()) {
                int id = threepieceResult.getInt("id");
                String brand_name = threepieceResult.getString("brand_name");
                double price = threepieceResult.getDouble("price");
                int quantity = threepieceResult.getInt("quantity");
                threepieceList.add(new ThreePiece(id, brand_name, price, quantity));
            }

        } catch (SQLException ex) {
            Logger.getLogger(FemaleJeansController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleClose(ActionEvent event) {
        Stage staget = (Stage) Close.getScene().getWindow();
        staget.close();
    }

    @FXML
    private void handlePantBuy(ActionEvent event) {
        int id = jeansSelect.getId();
        
        int buy = jeansSelect.getQuantity();
        buy = buy -1;
        
        try {
            connection = DriverManager.getConnection(ur_l,user_name,pass);
            
            String query = "update female_pant set quantity = '"+buy+"' where id = '"+id+"'";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
            
            Jeans js = new Jeans(id,jeansSelect.getBrand_name(),jeansSelect.getPrice(),buy);
            pantList.set(Index, js);
        } catch (SQLException ex) {
            Logger.getLogger(FemaleJeansController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleThreePieceBuy(ActionEvent event) {
        int id = threePieceSelect.getId();
        
        int buy = threePieceSelect.getQuantity();
        buy = buy -1;
        
        try {
            connection = DriverManager.getConnection(ur_l,user_name,pass);
            
            String query = "update female_threepiece set quantity = '"+buy+"' where id = '"+id+"'";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
            
            ThreePiece js = new ThreePiece(id,threePieceSelect.getBrand_name(),threePieceSelect.getPrice(),buy);
            threepieceList.set(Index, js);
        } catch (SQLException ex) {
            Logger.getLogger(FemaleJeansController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleMouseSelectPant(MouseEvent event) {
        jeansSelect = pantTableView.getSelectionModel().getSelectedItem();
        Index = pantTableView.getSelectionModel().getSelectedIndex();
    }

    @FXML
    private void handleMouseSelectThreePiece(MouseEvent event) {
        threePieceSelect = threePieceTableView.getSelectionModel().getSelectedItem();
        Index = threePieceTableView.getSelectionModel().getSelectedIndex();
    }

}
