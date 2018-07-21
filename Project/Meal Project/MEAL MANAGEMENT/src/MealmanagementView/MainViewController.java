package MealmanagementView;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainViewController implements Initializable {

    private final String hostname = "localhost";
    private final String dbname = "meal_management";
    private final String username = "root";
    private final String pass = "";
    private final String ur_l = "jdbc:mysql://" + hostname + "/" + dbname;

    private Connection connection;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void handleAddNewMemember(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/MemberList/MemberListView.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleMealSection(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/MealSection/MealSectionView.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleBajarSection(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/BajarSection/BajarSectionView.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handlePaymentSection(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/PaymentSection/PaymentSectionView.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleDetailsViewSection(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/DetailsViewSection/DetailsViewSectionView.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleClosingMonthSection(ActionEvent event) {
        try {
            connection = DriverManager.getConnection(ur_l, username, pass);
            Statement loginStatement = connection.createStatement();
            Statement memberStatement = connection.createStatement();
            Statement bajarStatement = connection.createStatement();
            Statement paymentStatement = connection.createStatement();
            Statement mealStatement = connection.createStatement();

            for (int i = 0; i < 5; i++) {
                loginStatement.executeUpdate("truncate login");
                memberStatement.executeUpdate("truncate member_list");
                bajarStatement.executeUpdate("truncate bajar_list");
                paymentStatement.executeUpdate("truncate payment_list");
                mealStatement.executeUpdate("truncate meal_section");
            }

        } catch (SQLException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
   
        }
    }

}
