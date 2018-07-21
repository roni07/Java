package WifiPass;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class PasswordController implements Initializable {

    private final String hostname = "localhost";
    private final String dbname = "StudentInfo";
    private final String username = "root";
    private final String pass = "";
    private final String ur_l = "jdbc:mysql://" + hostname + "/" + dbname;
    
    private Connection connection;
    private Statement statement;    
    
    @FXML
    private TextArea displayField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        try {
            connection = DriverManager.getConnection(ur_l, username, pass);
            statement = connection.createStatement();
            
            String query = "select * from password";
            
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                String pass = rs.getString("pass");
                displayField.setText(pass);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
