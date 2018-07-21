package studentform;

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

public class FXMLDocumentController implements Initializable {

    @FXML
    private ListView<Student> listViewField;
    private ObservableList<Student> studentList;

    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private ListView<String> listViewDetails;
    private ObservableList<String> listViewItems;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        studentList = FXCollections.observableArrayList();
        listViewItems = FXCollections.observableArrayList();
        listViewField.setItems(studentList);

        try {
            RandomAccessFile input = new RandomAccessFile("studentFile.txt", "r");

            while (true) {
                String id = input.readLine();
                if (id == null || id.trim().equals("")) {
                    break;
                }
                String name = input.readLine();

                LocalDate date = LocalDate.parse(input.readLine());

                Student student = new Student(id, name, date);
                studentList.add(student);
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found");
        } catch (IOException ioe) {
            System.out.println("Exception interruped");
        }

    }

    private void clear() {
        idField.clear();
        datePicker.setValue(null);
        nameField.clear();
    }

    @FXML
    private void handleSave(ActionEvent event) {
        String id = idField.getText();
        String name = nameField.getText();
        String date;
        if(datePicker.getValue() == null)
        {
            date = null;
        }
        else
        {
            date = datePicker.getValue().toString();
        }
        
        if (!id.equals("") && !name.equals("") && date != null) {
            try {
                Student student = new Student(id, name, LocalDate.parse(date));
                studentList.add(student);
                RandomAccessFile output = new RandomAccessFile("studentFile.txt", "rw");
                for (int i = 0; i < studentList.size(); i++) {
                    Student s = studentList.get(i);
                    String format = String.format("%s\r\n%s\r\n%s\r\n", s.getStudentId(), s.getName(), s.getDate());
                    output.writeBytes(format);
                }

            } catch (FileNotFoundException ex) {
                System.out.println("thth");
            } catch (IOException ex) {
                System.out.println("hjgj");
            }
            clear();
        }
    }

    @FXML
    private void selectionAction(MouseEvent event) {
        listViewItems.clear();
        Student details = listViewField.getSelectionModel().getSelectedItem();
        datePicker.setValue(details.getDate());
        idField.setText(details.getStudentId());
        nameField.setText(details.getName());
        
        listViewItems.add(details.getStudentId());
        listViewItems.add(details.getName());
        listViewItems.add(details.getDate().toString());
        listViewDetails.setItems(listViewItems);
    }

}
