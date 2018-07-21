package meal.management;

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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignupController implements Initializable {

    private final String hostname = "localhost";
    private final String dbname = "meal_management";
    private final String username = "root";
    private final String pass = "";
    private final String ur_l = "jdbc:mysql://" + hostname + "/" + dbname;

    private Connection connection;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void handleCreate(ActionEvent event) throws IOException {

        try {
            connection = DriverManager.getConnection(ur_l, username, pass);
            Statement createStatement = connection.createStatement();

            String userName = usernameField.getText();
            String pass = passField.getText();
            if (!userName.equals("") && !pass.equals("")) {
                String query = "insert into login values('" + userName + "', '" + pass + "' )";
                int login = createStatement.executeUpdate(query);

                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene scene = new Scene(root);
                Stage stage = MEALMANAGEMENT.getSignup();
                stage.setScene(scene);
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Required Field Can Not Be EMPTY");
                alert.showAndWait();
            }

        } catch (SQLException ex) {
            Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
