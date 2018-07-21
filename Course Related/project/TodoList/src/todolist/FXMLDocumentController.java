package todolist;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList ;
import java.util.List;
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
    private TextField titleField;
    @FXML
    private TextField itemField;
    @FXML
    private DatePicker datePicker;
    private List<String> items;
    
    private Todo selectedDateTitle ;
    private String selectedItem ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        titleList = FXCollections.observableArrayList();
        itemList = FXCollections.observableArrayList();
        completedList = FXCollections.observableArrayList();
        completedListDisplay.setItems(completedList);
        itemListDisplay.setItems(itemList);
        titleListDisplay.setItems(titleList);

        try {
            RandomAccessFile input = new RandomAccessFile("todo.txt", "r");
            while (true) {
                String dateString = input.readLine();
                if (dateString == null) {
                    break;
                }
                String titleString = input.readLine();
                Todo list = new Todo(LocalDate.parse(dateString), titleString);

                String line;
                while ((line = input.readLine()) != null) {
                    if (line.equals("#")) {
                        break;
                    }
                    list.getItemListDisplay().add(line);
                }
                while ((line = input.readLine()) != null) {
                    if (line.equals("##")) {
                        break;
                    }
                    list.getCompletedListDisplay().add(line);
                }
                titleList.add(list);
            }
        } catch (FileNotFoundException fnfne) {
            System.out.println("File Not Found!");
        } catch (IOException ioe) {
            System.out.println("IOException Occured");
        }
    }

    @FXML
    private void titleListDisplayAction(MouseEvent event) {
        Todo all = titleListDisplay.getSelectionModel().getSelectedItem();
        String t = itemField.getText();                
        all.getItemListDisplay().add(t);
        System.out.println(all);
        if (all == null) {
            return;
        }
        else{
        itemList.clear();
        itemList.addAll(all.getItemListDisplay());
        }
        selectedDateTitle = all ;
    }

    @FXML
    private void itemListDisplayAction(MouseEvent event) {
        items = new ArrayList<>();
        Todo all = titleListDisplay.getSelectionModel().getSelectedItem();
        String allItem= itemField.getText(); 
        items.add(allItem);
        all.setItemListDisplay(items);
//        all.getItemListDisplay().add(allItem);
        System.out.println(all);
        if (allItem == null) {
            return;
        }
        completedList.add(allItem);
        itemList.remove(allItem);
        titleList.add(all);
        titleListDisplay.setItems(titleList);
        selectedItem = allItem ;
    }

    @FXML
    private void completedListDisplayAction(MouseEvent event) {
        String completeItem = completedListDisplay.getSelectionModel().getSelectedItem();
        if (completeItem == null) {
            return;
        }
        itemList.add(completeItem) ;
        completedList.remove(completeItem) ;
    }

    @FXML
    private void deleteButtonAction(ActionEvent event) {

    }

    @FXML
    private void saveButtonAction(ActionEvent event) {
      //  LocalDate date = datePicker.getValue();
      //  String title = titleField.getText();
        
        try {
            RandomAccessFile output = new RandomAccessFile("todo.txt", "rw");
            // output.setLength(0) ;
//            for(int i = 0 ; i < titleList.size() ; i++){
//                Todo s = titleList.get(i) ;
//                output.writeBytes(s.getDate().toString()+"\n");
//                output.writeBytes(s.getTitle()+"\n");
//                for(int j = 0 ; j < itemList.size() ; j++){
//                    output.writeBytes(s.getItemListDisplay().get(j)+"\n");
//                    output.writeBytes("#\n");
//                    output.writeBytes("##\n") ;
//                }
//                
//            }
            
            for (int i = 0; i < titleList.size(); i++) {
                Todo s = titleList.get(i);
                String format = String.format("%s\r\n%s\r\n", s.getDate(), s.getTitle());
                System.out.println(s.getItemListDisplay().toString());
                output.writeBytes(format);
            }
           for (int i = 0; i < itemList.size(); i++) {
                String item = itemList.get(i);
                output.writeBytes(item + "\r\n");
            }  
            for (int i = 0; i < completedList.size(); i++) {
                String complete = completedList.get(i);
                output.writeBytes( complete + "\r\n");
            }   
              
        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found");
        } catch (IOException ioe) {
            System.out.println("IO Occured");
        }
    }

    @FXML
    private void addNewTitleAction(ActionEvent event) {
        String titlefield = titleField.getText();
        String q;
        if (datePicker.getValue() == null) {
            q = null;
        } else {
            q = datePicker.getValue().toString();
        }
        if (titleField.equals("") || q == null) {
            return ;
        }
        Todo t = new Todo(LocalDate.parse(q), titlefield);
        titleList.add(t);
        titleField.clear();
        datePicker.setValue(null);
}

    @FXML
    private void addNewItemAction(ActionEvent event) { 
        String titlefield = titleField.getText();
        String q;
        if (datePicker.getValue() == null) {
            q = null ;
        }
        else {
            q = datePicker.getValue().toString();
        }
       if (titleField.equals("") || q == null || itemField.equals("")) {
            return;
        }
        Todo t = new Todo(LocalDate.parse(q), titlefield);
        titleList.add(t);
        itemList.add(itemField.getText());
        clearOption();  
    }

    private void clearOption() {
        datePicker.setValue(null) ;
        titleField.clear() ;
        itemField.clear() ;
    }

    @FXML
    private void Add(ActionEvent event) {
        items = new ArrayList<>();
        String date = datePicker.getValue().toString();
       String title = titleField.getText();
        String item = itemField.getText();
        Todo t = new Todo(LocalDate.parse(date), title);
        items.add(item);
        t.setItemListDisplay(items);
        titleList.add(t);
        titleListDisplay.setItems(titleList);
    }
}
