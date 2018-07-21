package shopmanagement;

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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateAccountController implements Initializable {

    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passField;

    private final String host_name = "localhost";
    private final String db_name = "Shop_Management";
    private final String user_name = "root";
    private final String pass = "";
    private final String ur_l = "jdbc:mysql://" + host_name + "/" + db_name;

    private Connection connection;
    private Statement statement;
    private Button button;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleCreate(ActionEvent event) throws IOException {
        try {
            connection = DriverManager.getConnection(ur_l, user_name, pass);
            statement = connection.createStatement();

            String UserName = userNameField.getText();
            String Pass = passField.getText();
           if (!UserName.equals("") && !Pass.equals("")) {
                String query = "insert into Buyer_Login values ('" + UserName + "', '" + Pass + "')";
                int row = statement.executeUpdate(query);

                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene scene = new Scene(root);
                Stage stage = ShopManagement.getCreateAccount();
                stage.setScene(scene);
                stage.show();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Required Field Can Not Be EMPTY");
                alert.showAndWait();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
