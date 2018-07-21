package shopmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ShopManagement extends Application {
    
    private static Stage createAccount;
    private static Stage buyerWindow;
    private static Stage owenerWindow;
    
    private static Stage employee1Window;
    private static Stage employee2Window;
    
    private static Stage managerWindow;
    
    private static Stage buyerMale;
    
    
    public static Stage getCreateAccount(){
        return createAccount;
    }
    
    public static Stage getBuyerWindow(){
       return buyerWindow;
    }

    public static Stage getOwenerWindow() {
        return owenerWindow;
    }

    /* Start Employee Panel */
    
    public static Stage getEmployee1Window() {
        return employee1Window;
    }

    public static Stage getEmployee2Window() {
        return employee2Window;
    }

    /*End Employee Panel*/
    
    
    public static Stage getManagerWindow() {
        return managerWindow;
    }

    public static Stage getBuyerMale() {
        return buyerMale;
    }
    
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        createAccount = stage;
        buyerWindow = stage;
        owenerWindow = stage;
        
        employee1Window = stage;
        employee2Window = stage;
        
        managerWindow = stage;
        
        buyerMale = stage;
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
