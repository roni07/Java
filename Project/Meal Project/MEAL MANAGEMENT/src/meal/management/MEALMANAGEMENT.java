package meal.management;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MEALMANAGEMENT extends Application {
    
    private static Stage signup;
    
    private static Stage mainView;
    
    public static Stage getSignup(){
        return signup;
    }
    
    public static Stage getMainview(){
        return mainView;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        signup = stage;
        mainView = stage;
        
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
