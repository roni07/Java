package todolist1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Mehedi
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ListView<Todo> titleListDisplay;
    private ObservableList<Todo> titleList;

    @FXML
    private ListView<String> itemListDisplay;
    private ObservableList<String> itemList;

    @FXML
    private ListView<String> completedListDisplay;
    private ObservableList<String> completedList;

    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField titleField;
    @FXML
    private TextField itemField;
    
    private  Todo all;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        titleList = FXCollections.observableArrayList();
        itemList = FXCollections.observableArrayList();
        completedList = FXCollections.observableArrayList();
        titleListDisplay.setItems(titleList);
        itemListDisplay.setItems(itemList);
        completedListDisplay.setItems(completedList);
        try {
            RandomAccessFile input = new RandomAccessFile("t.txt", "r");
            while (true) {

                String date = input.readLine();
                if (date == null) {
                    break;
                }
                String title = input.readLine();

                Todo LisT = new Todo(LocalDate.parse(date), title);
                String line;
                while ((line = input.readLine()) != null) {
                    if (line.equals("#")) {
                        break;
                    }
                    LisT.getItemListDisplay().add(line);
                }
                while ((line = input.readLine()) != null) {
                    if (line.equals("##")) {
                        break;
                    }
                    LisT.getCompletedListDisplay().add(line);

                }
                titleList.add(LisT);

            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found");
        } catch (IOException ioe) {
            System.out.println("IOException Occured");
        }
    }

    @FXML
    private void itemFiledAction(ActionEvent event) {
        String date;
        if (datePicker.getValue() == null) {
            date = null;
        } else {
            date = datePicker.getValue().toString();
        }
        String title = titleField.getText();
        String item = itemField.getText();

        if (titleField == null || date == null || itemField == null) {
            return;
        }
        Todo dateTitle = new Todo(LocalDate.parse(date), title);
        dateTitle.getItemListDisplay().add(item);
        titleList.add(dateTitle);
        itemList.add(item);
        clearField();
    }

    @FXML
    private void titleFieldAction(ActionEvent event) {
        String date;
        if (datePicker.getValue() == null) {
            date = null;
        } else {
            date = datePicker.getValue().toString();
        }
        String title = titleField.getText();
        if (titleField == null || date == null) {
            return;
        }
        Todo dateTitle = new Todo(LocalDate.parse(date), title);
        titleList.add(dateTitle);
        datePicker.setValue(null);
        titleField.clear();
    }

    @FXML
    private void tittleListDisplayAction(MouseEvent event) {
        all = titleListDisplay.getSelectionModel().getSelectedItem();
        if (all != null) {
            itemList.clear();
            itemList.addAll(all.getItemListDisplay());
        }
    }

    @FXML
    private void itemListDisplayAction(MouseEvent event) {
        String item = itemListDisplay.getSelectionModel().getSelectedItem();
        if (item == null) {
            return;
        }
        completedList.add(item) ;
        itemList.remove(item) ;
    }

    @FXML
    private void completedListDisplayAction(MouseEvent event) {
        String completedItem = completedListDisplay.getSelectionModel().getSelectedItem();
        if (completedItem == null) {
            return;
        }
        itemList.add(completedItem);
        completedList.remove(completedItem);
    }

    private void clearField() {
        datePicker.setValue(null);
        titleField.clear();
        itemField.clear();
    }

    @FXML
    private void saveAction(ActionEvent event) {

        try {
            RandomAccessFile output = new RandomAccessFile("t.txt", "rw");
              for (int i = 0; i < titleList.size(); i++) {
                Todo s = titleList.get(i);
                String Format = String.format("%s\r\n%s\r\n", s.getDate(), s.getTitle());
                output.writeBytes(Format);
                for (int j = 0; j < s.getItemListDisplay().size(); j++) {
                    
                    String Format2 = String.format("%s\r\n#\r\n##\r\n", s.getItemListDisplay().get(j));
                    output.writeBytes(Format2); 
                    for (int k = 0; k < s.getCompletedListDisplay().size(); k++) {
                        String Format3 = String.format("#"+"%s\n\r",s.getCompletedListDisplay().get(k)+"\r\n##");
                      
                        output.writeBytes(Format3); 
                          System.out.println(Format3);
                    }
                }

            }  
        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found");
        } catch (IOException ioe) {
            System.out.println("IOException Occured");
        }

    }

    @FXML
    private void deleteAction(ActionEvent event) {
        titleList.remove(all);
        itemList.clear();
    }
}
