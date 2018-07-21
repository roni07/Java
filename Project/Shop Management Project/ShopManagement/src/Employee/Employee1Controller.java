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

public class Employee1Controller implements Initializable {

    @FXML
    private Label employee1Name;
    @FXML
    private Label employee1Age;
    @FXML
    private Label employee1Post;
    @FXML
    private Label employee1Email;
    @FXML
    private Label employee1Address;
    @FXML
    private Label employee1Sex;
    

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

            String employee1ProfileQuery = "select * from employee1_profile";

            Statement employee1ProfileStatement = connection.createStatement();

            ResultSet employee1Profile = employee1ProfileStatement.executeQuery(employee1ProfileQuery);

            while (employee1Profile.next()) {
                String name = employee1Profile.getString("name");
                int age = employee1Profile.getInt("age");
                String sex = employee1Profile.getString("sex");
                String address = employee1Profile.getString("address");
                String post = employee1Profile.getString("post");
                String email = employee1Profile.getString("email");
                employee1Name.setText(name);
                employee1Age.setText("" + age);
                employee1Sex.setText(sex);
                employee1Address.setText(address);
                employee1Post.setText(post);
                employee1Email.setText(email);
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
    private void emailMouseClickAction(MouseEvent event) {
    }

    @FXML
    private void addressMouseClickAction(MouseEvent event) {
    }

    @FXML
    private void handlePant(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ProductAvailabilityView/Availability.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

}
