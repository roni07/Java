package studentinfo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
    private TextField studentIDField;
    @FXML
    private PasswordField passwordField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void loginAction(MouseEvent event) throws IOException {

        if (studentIDField.getText().equals("229") && passwordField.getText().equals("229")) {

            Parent root = FXMLLoader.load(getClass().getResource("/Student/StudentInformation.fxml"));

            Scene scene = new Scene(root);

            Stage stage = StudentInfo.getStudent();

            stage.setScene(scene);
            stage.show();
        }
    }

}
