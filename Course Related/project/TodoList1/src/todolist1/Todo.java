package todolist1;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Mehedi
 */
public class Todo {

    private LocalDate date;
    private String title;
    private ArrayList<String> itemListDisplay;
    private ArrayList<String> completedListDisplay;

    public Todo() {
        itemListDisplay = new ArrayList();
        completedListDisplay = new ArrayList();
    }

    public Todo(LocalDate date, String title) {
        this();
        this.date = date;
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getItemListDisplay() {
        return itemListDisplay;
    }

    public ArrayList<String> getCompletedListDisplay() {
        return completedListDisplay;
    }

    public void setItemListDisplay(ArrayList<String> itemListDisplay) {
        this.itemListDisplay = itemListDisplay;
    }

    public void setCompletedListDisplay(ArrayList<String> completedListDisplay) {
        this.completedListDisplay = completedListDisplay;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return  title ;
    }

}
