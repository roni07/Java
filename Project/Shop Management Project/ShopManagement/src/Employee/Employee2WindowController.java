package Employee;

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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import shopmanagement.ShopManagement;

/**
 * FXML Controller class
 *
 * @author Roni
 */
public class Employee2WindowController implements Initializable {

    @FXML
    private Label employee2Name;
    @FXML
    private Label employee2Age;
    @FXML
    private Label employee2Sex;
    @FXML
    private Label employee2Address;
    @FXML
    private Label employee2Post;
    @FXML
    private Label employee2Email;

    private final String host_name = "localhost";
    private final String db_name = "shop_management";
    private final String user_name = "root";
    private final String pass = "";
    private final String ur_l = "jdbc:mysql://" + host_name + "/" + db_name;

    private Connection connection;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            connection = DriverManager.getConnection(ur_l, user_name, pass);

            String employee1ProfileQuery = "select name, age, sex, address, post, email from employee2_profile";

            Statement employee2ProfileStatement = connection.createStatement();

            ResultSet employee2Profile = employee2ProfileStatement.executeQuery(employee1ProfileQuery);

            while (employee2Profile.next()) {
                String name = employee2Profile.getString("name");
                int age = employee2Profile.getInt("age");
                String sex = employee2Profile.getString("sex");
                String address = employee2Profile.getString("address");
                String post = employee2Profile.getString("post");
                String email = employee2Profile.getString("email");
                employee2Name.setText(name);
                employee2Age.setText("" + age);
                employee2Sex.setText(sex);
                employee2Address.setText(address);
                employee2Post.setText(post);
                employee2Email.setText(email);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Employee1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleLogout(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/shopmanagement/FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        Stage stage = ShopManagement.getBuyerWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handelPant(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ProductAvailabilityView/Availability.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleShirt(ActionEvent event) {
        
    }

}
