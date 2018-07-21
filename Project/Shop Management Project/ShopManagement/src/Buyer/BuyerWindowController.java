/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buyer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import shopmanagement.ShopManagement;

public class BuyerWindowController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleMale(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/BuyerMaleView/BuyerMale.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleFemale(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/BuyerFemaleView/FemaleJeans.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleMaleKids(ActionEvent event) {
    }

    @FXML
    private void handleFemaleKids(ActionEvent event) {
    }

    @FXML
    private void handleLogout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/shopmanagement/FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        Stage stage = ShopManagement.getBuyerWindow();
        stage.setScene(scene);
        stage.show();
    }

}
