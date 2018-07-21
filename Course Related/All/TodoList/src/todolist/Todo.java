
package todolist;

import java.time.LocalDate;
import java.util.ArrayList;

public class Todo {
    private LocalDate date ;
    private String Title ;
    private ArrayList<String> ListTitleView ;
    private ArrayList<String> CompletedItemList ;
    
    public Todo(){
        ListTitleView = new ArrayList<>() ;
        CompletedItemList = new ArrayList<>() ;
    }

    public Todo(LocalDate date, String Title) {
        this() ;
        this.date = date;
        this.Title = Title;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTitle() {
        return Title;
    }

    public ArrayList<String> getListTitleView() {
        return ListTitleView;
    }
    
    
    public ArrayList<String> getcompleteditemList() {
        return CompletedItemList;
    }

    @Override
    public String toString() {
        return Title ;
    }

  
    
    
    
    
}

