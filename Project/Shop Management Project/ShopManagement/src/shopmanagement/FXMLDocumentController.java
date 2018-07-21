package shopmanagement;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleLoginAction(ActionEvent event) throws IOException, SQLException {
        try {
            connection = DriverManager.getConnection(ur_l, user_name, pass);
            Statement buyerStatement = connection.createStatement();
            Statement owenerStatement = connection.createStatement();
            
            Statement employee1Statement = connection.createStatement();
            Statement employee2Statement = connection.createStatement();
            
            Statement managerStatement = connection.createStatement();

            String buyerLoginQuery = "select User_Name, Pass from Buyer_Login";
            String owenerLoginQuery = "select User_Name, Pass from Owener_Login";
            
            String employee1LoginQuery = "select User_Name, Pass from employee1_login";
            String employee2LoginQuery = "select User_Name, Pass from employee2_login";
            
            String managerLoginQuery = "select User_Name, Pass from Manager_Login";

            ResultSet buyer = buyerStatement.executeQuery(buyerLoginQuery);
            ResultSet owener = owenerStatement.executeQuery(owenerLoginQuery);
            
            ResultSet employee1 = employee1Statement.executeQuery(employee1LoginQuery);
            ResultSet employee2 = employee2Statement.executeQuery(employee2LoginQuery);
            
            ResultSet manager = managerStatement.executeQuery(managerLoginQuery);

            while (buyer.next()) {
                String UserName = buyer.getString("User_Name");
                String Pass = buyer.getString("Pass");
                if (UserName.equals(userNameField.getText()) && Pass.equals(passField.getText())) {
                    Parent root = FXMLLoader.load(getClass().getResource("/Buyer/BuyerWindow.fxml"));

                    Scene scene = new Scene(root);

                    Stage stage = ShopManagement.getBuyerWindow();
                    stage.setScene(scene);
                    stage.show();
                }
            }

            while (owener.next()) {
                String UserName = owener.getString("User_Name");
                String Pass = owener.getString("Pass");
                if (UserName.equals(userNameField.getText()) && Pass.equals(passField.getText())) {
                    Parent root = FXMLLoader.load(getClass().getResource("/Owener/OwenerWindow.fxml"));

                    Scene scene = new Scene(root);

                    Stage stage = ShopManagement.getOwenerWindow();
                    stage.setScene(scene);
                    stage.show();
                }
            }

            while (employee1.next()) {
                String UserName = employee1.getString("User_Name");
                String Pass = employee1.getString("Pass");
                if (UserName.equals(userNameField.getText()) && Pass.equals(passField.getText())) {
                    Parent root = FXMLLoader.load(getClass().getResource("/Employee/Employee1Window.fxml"));

                    Scene scene = new Scene(root);

                    Stage stage = ShopManagement.getEmployee1Window();
                    stage.setScene(scene);
                    stage.show();
                }
            }

            while(employee2.next()){
                String UserName = employee2.getString("User_Name");
                String Pass = employee2.getString("Pass");
                if(UserName.equals(userNameField.getText()) && Pass.equals(passField.getText())){
                    Parent root = FXMLLoader.load(getClass().getResource("/Employee/Employee2Window.fxml"));

                    Scene scene = new Scene(root);

                    Stage stage = ShopManagement.getEmployee2Window();
                    stage.setScene(scene);
                    stage.show();
                }
            }
            
            while (manager.next()) {
                String UserName = manager.getString("User_Name");
                String Pass = manager.getString("Pass");
                if (UserName.equals(userNameField.getText()) && Pass.equals(passField.getText())) {
                    Parent root = FXMLLoader.load(getClass().getResource("/Manager/ManagerWindow.fxml"));

                    Scene scene = new Scene(root);

                    Stage stage = ShopManagement.getManagerWindow();
                    stage.setScene(scene);
                    stage.show();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleCreateAccount(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));

        Scene scene = new Scene(root);

        Stage stage = ShopManagement.getCreateAccount();
        stage.setScene(scene);
        stage.show();
    }
}
