package demo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Mehedi
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField title;
    @FXML
    private TextField item;
    @FXML
    private ListView<String> list;
    ObservableList<String> List = FXCollections.observableArrayList();

    @FXML
    private ListView<String> itemList;

    ObservableList<Object> titleList = FXCollections.observableArrayList();

    ObservableList<String> itemlist;
    ArrayList<String> itemsList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void save(ActionEvent event) {
        String name = title.getText();
        String items = item.getText();
        if (items == null) {
            Object o = new Object(name);
            titleList.add(o);
            List.add(name);
            list.setItems(List);
        } else {
            if (titleList.size() > 0) {
                for (int i = 0; i < titleList.size(); i++) {
                    if (titleList.get(i).getTitle().equals(name)) {
                        Object o = titleList.get(i);
                        o.getItem().add(items);
                         System.out.println(o);
                    } else {
                        Object o = new Object(name);
                        o.getItem().add(items);
                        titleList.add(o);
                         System.out.println(o);
                        List.add(name);
                        break;
                    }
                }
            } else {
                Object o = new Object(name);
                o.getItem().add(items);
                titleList.add(o);
                System.out.println(o);
                List.add(name);
            }
            list.setItems(List);
        }
    }

    @FXML
    private void titleListAction(MouseEvent event) {
        itemlist = FXCollections.observableArrayList();
        String title1 = list.getSelectionModel().getSelectedItem();
        title.setText(title1);
        for (int i = 0; i < titleList.size(); i++) {
            if (titleList.get(i).getTitle().equals(title1)) {
                Object o = titleList.get(i);
                itemlist.addAll(o.getItem());
            }
        }
        itemList.setItems(itemlist);
    }

}
