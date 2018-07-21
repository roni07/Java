package demo.login.Front_Page;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void handleOwenerAction(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OwenerLogIn.fxml"));

        Scene scene = new Scene(root);
        Stage stage = DEMOLOGIN.getOwenerLogIn();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleManagerAction(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Manager.fxml"));

        Scene scene = new Scene(root);
        Stage stage = DEMOLOGIN.getManagerLogIn();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleStuffAction(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Stuff.fxml"));

        Scene scene = new Scene(root);
        Stage stage = DEMOLOGIN.getStuffLogIn();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleBuyerAction(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Buyer.fxml"));

        Scene scene = new Scene(root);
        Stage stage = DEMOLOGIN.getBuyerLogIn();
      //  Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

}
