/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField userFiled;
    @FXML
    private TextField passField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        if ("roni".equals(userFiled.getText()) && "123".equals(passField.getText())) {
            Parent root = FXMLLoader.load(getClass().getResource("Next.fxml"));

            Scene scene = new Scene(root);
            Stage stage = Test.getDemoStage();
            stage.setScene(scene);
            stage.show();
        }
    }

}
