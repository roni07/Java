package DetailsViewSection;

import MealSection.Meal;
import MemberList.Members;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DetailsViewSectionViewController implements Initializable {

    @FXML
    private Label currentMealRateField;
    @FXML
    private Label totalDepositeField;
    @FXML
    private Label totalCostField;
    @FXML
    private Label totalMealField;
    @FXML
    private TableView<Details> tableView;
    private ObservableList<Details> tablesList;

    @FXML
    private TableColumn<Details, String> nameColumn;
    private ObservableList<Meal> name_meal_List;

    @FXML
    private TableColumn<Details, Number> TotalMeal;
    @FXML
    private TableColumn<Details, Number> depositeColumn;
    @FXML
    private TableColumn<Details, Number> balanceColumn;
    @FXML
    private TableColumn<Details, Number> mealPerRate;

    private final String hostname = "localhost";
    private final String dbname = "meal_management";
    private final String username = "root";
    private final String pass = "";
    private final String ur_l = "jdbc:mysql://" + hostname + "/" + dbname;

    private Connection connection;

    private ObservableList<Members> nameList;
    private ObservableList<Deposit> deposits;
    
    private double currentMeal;
    private DecimalFormat d = new DecimalFormat("#0.00");
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tablesList = FXCollections.observableArrayList();
        tableView.setItems(tablesList);

        name_meal_List = FXCollections.observableArrayList();
        nameList = FXCollections.observableArrayList();
        deposits = FXCollections.observableArrayList();

        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        TotalMeal.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getTotalMeal()));
        depositeColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getDeposit()));
        balanceColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getBalance()));
        mealPerRate.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPerMeal()));

        try {
            connection = DriverManager.getConnection(ur_l, username, pass);

            Statement totalCostStatement = connection.createStatement();
            Statement totalMealStatement = connection.createStatement();
            Statement depositStatement = connection.createStatement();

            Statement detailsFromMelaSectionStatement = connection.createStatement();
            Statement detailsFromPaymentListStatement = connection.createStatement();
            Statement detailsFromPaymentListStatement1 = connection.createStatement();
            Statement memberS = connection.createStatement();

            String totalCostQuery = "select sum(purchage) 'purchage' from bajar_list";
            String totalMealQuery = "select sum(total) 'total' from meal_section";
            String depositQuery = "select sum(payment) 'payment' from payment_list";

            String detailsFromMealSectionQuery = "select * from meal_section";
            String detailsFromPaymentListQuery = "select * from payment_list";
            String memberQ = "select * from member_list";

            ResultSet totalCostResult = totalCostStatement.executeQuery(totalCostQuery);
            ResultSet totalMealResult = totalMealStatement.executeQuery(totalMealQuery);
            ResultSet depositResult = depositStatement.executeQuery(depositQuery);

            ResultSet detailsFromMealSectionResult = detailsFromMelaSectionStatement.executeQuery(detailsFromMealSectionQuery);
            ResultSet detailsFromPaymentListResult = detailsFromPaymentListStatement.executeQuery(detailsFromPaymentListQuery);
            ResultSet detailsFromPaymentListResult1 = detailsFromPaymentListStatement1.executeQuery(detailsFromPaymentListQuery);
            ResultSet member = memberS.executeQuery(memberQ);

            while (totalCostResult.next() && totalMealResult.next() && depositResult.next() && detailsFromPaymentListResult.next()) {
                double currentMealRate = totalCostResult.getDouble("purchage");
                int totalMeal = totalMealResult.getInt("total");
                int deposit = depositResult.getInt("payment");
                currentMeal = currentMealRate / totalMeal;

                currentMealRateField.setText(d.format(currentMeal));
                totalDepositeField.setText("" + deposit);
                totalCostField.setText(d.format(currentMealRate));

                totalMealField.setText("" + totalMeal);

            }
            while (detailsFromMealSectionResult.next()) {

                String name = detailsFromMealSectionResult.getString("name");
                int br = detailsFromMealSectionResult.getInt("breakfast");
                int l = detailsFromMealSectionResult.getInt("lunch");
                int d = detailsFromMealSectionResult.getInt("dinner");
                int t = detailsFromMealSectionResult.getInt("total");
                String date = detailsFromMealSectionResult.getString("date");
                String num = detailsFromMealSectionResult.getString("phn_num");

                Meal m = new Meal(name, br, l, d, t, date, num);
                name_meal_List.add(m);
            }
            while (member.next()) {
                String name = member.getString("name");
                String phn = member.getString("phn_num");

                nameList.add(new Members(name, phn));
            }
            
            while (detailsFromPaymentListResult1.next()) {
                int payment = detailsFromPaymentListResult1.getInt("payment");
                String phn = detailsFromPaymentListResult1.getString("phn_num");

                deposits.add(new Deposit(payment, phn));
            }
            
            int t = 0;
            int p = 0;

            for (Members memb : nameList) {
                for (Meal m : name_meal_List) {
                    if(memb.getPhoneNum().equals(m.getNum()))
                    {
                        t += m.getTotal();
                    }
                }
                for (Deposit d : deposits) {
                    
                    if(memb.getPhoneNum().equals(d.getNum()))
                    {
                        p += d.getPayment();
                    }
                }
                
                
                double b =  p - (t * currentMeal);
                
                tablesList.add(new Details(memb.getName(),t , p, Double.parseDouble(d.format(b)), Double.parseDouble(d.format(currentMeal))));
                t = 0;
                p = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DetailsViewSectionViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
