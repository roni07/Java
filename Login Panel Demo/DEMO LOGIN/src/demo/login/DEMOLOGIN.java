package demo.login.Front_Page;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DEMOLOGIN extends Application {

    private static Stage owenerLogIn;
    private static Stage managerLogIn;
    private static Stage stuffLogIn;
    private static Stage buyerLogIn;

    private static Stage owenerView;
    private static Stage managerView;
    private static Stage stuffView;
    private static Stage buyerView;

    public static Stage getOwenerLogIn() {
        return owenerLogIn;
    }

    public static Stage getManagerLogIn() {
        return managerLogIn;
    }

    public static Stage getStuffLogIn() {
        return stuffLogIn;
    }

    public static Stage getBuyerLogIn() {
        return buyerLogIn;
    }

    /* All Users Front View  Part*/
    public static Stage getOwenerView() {
        return owenerView;
    }

    public static Stage getManagerView() {
        return managerView;
    }

    public static Stage getStuffView() {
        return stuffView;
    }

    public static Stage getBuyerView() {
        return buyerView;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);
        owenerLogIn = stage;
        managerLogIn = stage;
        stuffLogIn = stage;
        buyerLogIn = stage;

        owenerView = stage;
        managerView = stage;
        stuffView = stage;
        buyerView = stage;

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
