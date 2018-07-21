/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Mehedi
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ListView<Todo> ListTitleView;
    private ObservableList<Todo> ListTitleItemView;

    @FXML
    private ListView<String> ListItemView;
    private ObservableList<String> ListItems;

    @FXML
    private ListView<String> CompletedListView;
    private ObservableList<String> completed;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListTitleItemView = FXCollections.observableArrayList();
        ListItems = FXCollections.observableArrayList();
        completed = FXCollections.observableArrayList();
        CompletedListView.setItems(completed);
        ListTitleView.setItems(ListTitleItemView);
        ListItemView.setItems(ListItems);

        try {
            RandomAccessFile input = new RandomAccessFile("todolist.txt", "r");
            while (true) {
                String date = input.readLine();
                if (date == null) {
                    break;
                }
                String title = input.readLine();
                Todo s = new Todo(LocalDate.parse(date), title);

                String line;
                while ((line = input.readLine()) != null) {
                    if (line.equals("")) {
                        break;
                    }
                    s.getListTitleView().add(line);
                }

                while ((line = input.readLine()) != null) {
                    if (line.equals(" ")) {
                        break;
                    }
                    s.getcompleteditemList().add(line);
                }

                ListTitleItemView.add(s);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found");
        } catch (IOException ioe) {
            System.out.println("OOPS !!");
        }
    }

    @FXML
    private void ListTitleViewAction(MouseEvent event) {
        Todo all = ListTitleView.getSelectionModel().getSelectedItem();
        ListItems.clear();
        ListItems.addAll(all.getListTitleView());
    }

    @FXML
    private void ListItemViewAction(MouseEvent event) {
        String item = ListItemView.getSelectionModel().getSelectedItem();
        completed.add(item);
        CompletedListView.setItems(completed);
        ListItems.remove(item);
    }

    @FXML
    private void back(MouseEvent event) {
        String item = CompletedListView.getSelectionModel().getSelectedItem();
        ListItems.add(item);
        ListItemView.setItems(ListItems);
        completed.remove(item);
    }

}
