package Student;

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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class StudentInformationController implements Initializable {
    
    private final String hostname = "localhost";
    private final String dbname = "StudentInfo";
    private final String username = "root";
    private final String pass = "";
    private final String ur_l = "jdbc:mysql://" + hostname + "/" + dbname;
    
    private Connection connection;
    private Statement statement;

    @FXML
    private ListView<CurrentSemester> currentCourseDisplay;
    private ObservableList<CurrentSemester> courseList;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        courseList = FXCollections.observableArrayList();
        currentCourseDisplay.setItems(courseList);
        
        try {
            connection = DriverManager.getConnection(ur_l, username, pass);
            statement = connection.createStatement();
            
            String query = "select * from current_courses";
            
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                String course_code = rs.getString("course_code");
                String course_title = rs.getString("course_title");
                String section = rs.getString("section");
                courseList.add(new CurrentSemester(course_code, course_title, section));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentInformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void wifiPassWordAction(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/WifiPass/Password.fxml"));

            Scene scene = new Scene(root);

            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();
    }
    
}
