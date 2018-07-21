package todolist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Todo {
    private LocalDate date ;
    private String title ;
    private List<String> itemListDisplay ;
    private List<String> completedListDisplay ;
    
    public Todo(){
        itemListDisplay = new ArrayList<>();
        completedListDisplay = new ArrayList<>();
    }
    
    public Todo(LocalDate date , String title){
        this();
        this.date = date ;
        this.title = title ;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getItemListDisplay() {
        return itemListDisplay;
    }

    public void setItemListDisplay(List<String> itemListDisplay) {
        this.itemListDisplay = itemListDisplay;
    }

    public List<String> getCompletedListDisplay() {
        return completedListDisplay;
    }

    public void setCompletedListDisplay(List<String> completedListDisplay) {
        this.completedListDisplay = completedListDisplay;
    }

    @Override
    public String toString() {
        return "Todo{" + "date=" + date + ", title=" + title + ", itemListDisplay=" + itemListDisplay + ", completedListDisplay=" + completedListDisplay + '}';
    }
    
    
    
    
}