

import demo.login.Front_Page.DEMOLOGIN;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BuyerController implements Initializable {

    @FXML
    private TextField passwordField;
    @FXML
    private TextField userNameField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void backAction(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);
        Stage stage = DEMOLOGIN.getBuyerLogIn();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void loginAction(MouseEvent event) throws IOException {

        if ("Rakib".equals(userNameField.getText()) && "rakib.".equals(passwordField.getText())) {
            Parent root = FXMLLoader.load(getClass().getResource("buyerView.fxml"));

            Scene scene = new Scene(root);

            Stage stage = DEMOLOGIN.getBuyerView();
            stage.setScene(scene);
            stage.show();
        }

    }

}
