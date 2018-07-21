package MemberList;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MemberListViewController implements Initializable {

    private final String hostname = "localhost";
    private final String dbname = "meal_management";
    private final String username = "root";
    private final String pass = "";
    private final String ur_l = "jdbc:mysql://" + hostname + "/" + dbname;

    private Connection connection;

    @FXML
    private TextField nameField;
    @FXML
    private TextField contactField;

    @FXML
    private TableColumn<Members, String> nameColumn;
    @FXML
    private TableColumn<Members, String> contactColumn;

    @FXML
    private TableView<Members> memberTableView;

    private ObservableList<Members> memberList;

    private Members updateSelection;

    private int Index;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        memberList = FXCollections.observableArrayList();
        memberTableView.setItems(memberList);

        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        contactColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPhoneNum()));

        try {
            connection = DriverManager.getConnection(ur_l, username, pass);
            Statement memberStatement = connection.createStatement();

            String memberInsert = "select * from member_list";

            ResultSet member = memberStatement.executeQuery(memberInsert);

            while (member.next()) {
                String name = member.getString("name");
                String phn = member.getString("phn_num");

                memberList.add(new Members(name, phn));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberListViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void handleAdd(ActionEvent event) {

        String name = nameField.getText();
        String phn = contactField.getText();

        try {
            connection = DriverManager.getConnection(ur_l, username, pass);
            Statement memberStatement = connection.createStatement();

            if (!name.equals("") && !phn.equals("")) {
                String query = "insert into member_list values('" + name + "','" + phn + "')";
                int member = memberStatement.executeUpdate(query);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Required Field Can Not Be EMPTY");
                alert.showAndWait();
            }

            memberList.add(new Members(name, phn));

            nameField.clear();
            contactField.clear();

        } catch (SQLException ex) {
            Logger.getLogger(MemberListViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleUpdate(ActionEvent event) {

        try {

            String name = nameField.getText();
            String phn = contactField.getText();

            String update = "Update member_list set name = '" + name + "', phn_num = '" + phn + "' where phn_num = '"+updateSelection.getPhoneNum()+"'";

            PreparedStatement st = connection.prepareStatement(update);
            st.executeUpdate();

            Members m = new Members(name, phn);
            memberList.set(Index, m);

        } catch (SQLException ex) {
            Logger.getLogger(MemberListViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void handleDelete(ActionEvent event) {
        try {
            connection = DriverManager.getConnection(ur_l, username, pass);
            if (updateSelection != null) {
                String delete = "DELETE FROM member_list WHERE phn_num = " + updateSelection.getPhoneNum();
                PreparedStatement st = connection.prepareStatement(delete);
                st.executeUpdate();
                memberList.remove(updateSelection);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberListViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

        nameField.clear();
        contactField.clear();
    }

    @FXML
    private void selectedMember(MouseEvent event) {
        updateSelection = memberTableView.getSelectionModel().getSelectedItem();
        Index = memberTableView.getSelectionModel().getSelectedIndex();
        nameField.setText(updateSelection.getName());
        contactField.setText(updateSelection.getPhoneNum());
    }

}
