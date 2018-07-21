package BajarSection;

import MemberList.Members;

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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BajarSectionViewController implements Initializable {

    private final String hostname = "localhost";
    private final String dbname = "meal_management";
    private final String username = "root";
    private final String pass = "";
    private final String ur_l = "jdbc:mysql://" + hostname + "/" + dbname;

    private Connection connection;

    @FXML
    private DatePicker dateField;

    @FXML
    private ComboBox<Members> nameField;
    private ObservableList<Members> nameList;

    @FXML
    private TextField purchageAmountField;

    private ObservableList<AddBajar> addBajarList;

    @FXML
    private Label todaysMealField;
    @FXML
    private Label todaysMealRate;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        nameList = FXCollections.observableArrayList();
        nameField.setItems(nameList);

        addBajarList = FXCollections.observableArrayList();

        try {
            connection = DriverManager.getConnection(ur_l, username, pass);
            Statement nameStatement = connection.createStatement();

            String nameQuery = "select * from member_list";

            ResultSet nameResult = nameStatement.executeQuery(nameQuery);

            while (nameResult.next()) {
                String name = nameResult.getString("name");
                String phn = nameResult.getString("phn_num");
                nameList.add(new Members(name, phn));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BajarSectionViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleInsert(ActionEvent event) {

        try {
            connection = DriverManager.getConnection(ur_l, username, pass);
            Statement bajarInsertStatement = connection.createStatement();

            Members name = nameField.getSelectionModel().getSelectedItem();
            String date = dateField.getValue().toString();
            double purchage = Double.parseDouble(purchageAmountField.getText());

            String addBajarQuery = "insert into bajar_list values('" + date + "', '" + name.getName() + "', " + purchage + ")";

            int insertBajar = bajarInsertStatement.executeUpdate(addBajarQuery);

            addBajarList.add(new AddBajar(name.getName(), date, purchage));

        } catch (SQLException ex) {
            Logger.getLogger(BajarSectionViewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException npe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Required Field Can Not Be EMPTY");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleSearchAction(MouseEvent event) {

        String date = dateField.getValue().toString();

        try {

            connection = DriverManager.getConnection(ur_l, username, pass);
            Statement mealRateStatement = connection.createStatement();
            Statement totalMealStatement = connection.createStatement();

            String mealRateQuery = "select sum(purchage) 'purchage' from bajar_list where date = '" + date + "'";

            String totalMealQuery = "select sum(total) 'total' from meal_section where date = '" + date + "'";

            ResultSet totalMealResult = totalMealStatement.executeQuery(totalMealQuery);

            ResultSet mealRateResult = mealRateStatement.executeQuery(mealRateQuery);

            while (totalMealResult.next() && mealRateResult.next()) {
                double mealRate = mealRateResult.getDouble("purchage");
                int totalMeal = totalMealResult.getInt("total");

                double mealRateR = mealRate / totalMeal;
                todaysMealField.setText("" + totalMeal);
                todaysMealRate.setText("" + mealRateR);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BajarSectionViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
