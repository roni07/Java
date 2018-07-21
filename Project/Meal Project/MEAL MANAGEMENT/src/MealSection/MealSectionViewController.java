package MealSection;

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
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class MealSectionViewController implements Initializable {

    @FXML
    private ComboBox<Members> comboBoxFiled;
    private ObservableList<Members> nameList;

    @FXML
    private ComboBox<Integer> breakFastField;

    @FXML
    private ComboBox<Integer> lunchFiled;

    @FXML
    private ComboBox<Integer> dinnerFiled;
    private ObservableList<Integer> mealCount;

    private final String hostname = "localhost";
    private final String dbname = "meal_management";
    private final String username = "root";
    private final String pass = "";
    private final String ur_l = "jdbc:mysql://" + hostname + "/" + dbname;

    private Connection connection;
    @FXML
    private DatePicker dateField;

    @FXML
    private TableView<Meal> tableView;
    private ObservableList<Meal> tableListFromMeal;

    @FXML
    private TableColumn<Meal, String> nameColumn;
    @FXML
    private TableColumn<Meal, Number> breakfastColumn;
    @FXML
    private TableColumn<Meal, Number> lunchColumn;
    @FXML
    private TableColumn<Meal, Number> dinnerColumn;
    @FXML
    private TableColumn<Meal, Number> totalCoumn;

    @FXML
    private TableColumn<Meal, String> dateColumn;

    @FXML
    private Label brSummeryField;
    @FXML
    private Label lunSummeryField;
    @FXML
    private Label dnnSummeryField;
    @FXML
    private Label totalSummeryField;

    @FXML
    private DatePicker searchDateField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        nameList = FXCollections.observableArrayList();
        comboBoxFiled.setItems(nameList);

        tableListFromMeal = FXCollections.observableArrayList();
        tableView.setItems(tableListFromMeal);

        mealCount = FXCollections.observableArrayList();
        mealCount.add(1);
        mealCount.add(2);
        mealCount.add(3);

        breakFastField.setItems(mealCount);
        lunchFiled.setItems(mealCount);
        dinnerFiled.setItems(mealCount);

        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        breakfastColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getBreakfast()));
        lunchColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getLunch()));
        dinnerColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getDinner()));
        totalCoumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getTotal()));
        dateColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDate()));
        try {
            connection = DriverManager.getConnection(ur_l, username, pass);

            Statement selectNameStatement = connection.createStatement();

            Statement mealSectionStatement = connection.createStatement();
            String selectName = "select * from member_list";

            String mealSection = "select * from meal_section";
            ResultSet Name = selectNameStatement.executeQuery(selectName);

            ResultSet meal = mealSectionStatement.executeQuery(mealSection);
            while (Name.next()) {
                String name = Name.getString("name");
                String phn = Name.getString("phn_num");
                Members m = new Members(name, phn);
                nameList.add(m);
            }

            while (meal.next()) {

                String name = "";
                int br = meal.getInt("breakfast");
                int l = meal.getInt("lunch");
                int d = meal.getInt("dinner");
                int t = meal.getInt("total");
                String date = meal.getString("date");
                String num = meal.getString("phn_num");

                for (int i = 0; i < nameList.size(); i++) {
                    if (nameList.get(i).getPhoneNum().equals(num)) {
                        name = nameList.get(i).getName();
                    }
                }

                Meal m = new Meal(name, br, l, d, t, date);

                tableListFromMeal.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MealSectionViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void insertAction(ActionEvent event) {

        try {
            connection = DriverManager.getConnection(ur_l, username, pass);

            Statement mealInsertStatement = connection.createStatement();

            Members NameList = comboBoxFiled.getSelectionModel().getSelectedItem();

            int breakfast = breakFastField.getSelectionModel().getSelectedItem();
            int lunch = lunchFiled.getSelectionModel().getSelectedItem();
            int dinner = dinnerFiled.getSelectionModel().getSelectedItem();
            String date = dateField.getValue().toString();

            int totalMeal = breakfast + lunch + dinner;

            String mealInsert = "insert into meal_section values(" + breakfast + "," + lunch + ","
                    + " " + dinner + ", " + totalMeal + ", "
                    + "'" + date + "','" + NameList.getPhoneNum() + "', '"+NameList.getName()+"'  )";

            int insert = mealInsertStatement.executeUpdate(mealInsert);

            Meal meal = new Meal(NameList.getName(), breakfast, lunch, dinner, totalMeal, date);

            tableListFromMeal.add(meal);

        } catch (SQLException ex) {
            Logger.getLogger(MealSectionViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchAction(MouseEvent event) {
        int totalMeal = 0;
        int breakFast = 0;
        int lunch = 0;
        int dinner = 0;

        String searchDate = searchDateField.getValue().toString();

        for (int i = 0; i < tableListFromMeal.size(); i++) {
            if (tableListFromMeal.get(i).getDate().equals(searchDate)) {
                totalMeal += tableListFromMeal.get(i).getTotal();
                breakFast += tableListFromMeal.get(i).getBreakfast();
                lunch += tableListFromMeal.get(i).getLunch();
                dinner += tableListFromMeal.get(i).getDinner();
            }
        }

        totalSummeryField.setText("" + totalMeal);
        brSummeryField.setText("" + breakFast);
        lunSummeryField.setText("" + lunch);
        dnnSummeryField.setText("" + dinner);

    }

}
