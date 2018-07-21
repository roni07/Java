package meal.management;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    private final String hostname = "localhost";
    private final String dbname = "meal_management";
    private final String username = "root";
    private final String pass = "";
    private final String ur_l = "jdbc:mysql://" + hostname + "/" + dbname;

    private Connection connection;
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        try {
            connection = DriverManager.getConnection(ur_l, username, pass);
            Statement managerStatement = connection.createStatement();

            String managerLogin = "select * from login";

            ResultSet manager = managerStatement.executeQuery(managerLogin);

            while (manager.next()) {
                String userName = manager.getString("user_name");
                String pass = manager.getString("pass");
                if (userName.equals(userNameField.getText()) && pass.equals(passField.getText())) {
                    Parent root = FXMLLoader.load(getClass().getResource("/MealmanagementView/MainView.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = MEALMANAGEMENT.getMainview();
                    stage.setScene(scene);
                    stage.show();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleSignup(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
        Scene scene = new Scene(root);
        Stage stage = MEALMANAGEMENT.getSignup();
        stage.setScene(scene);
        stage.show();
    }

}
