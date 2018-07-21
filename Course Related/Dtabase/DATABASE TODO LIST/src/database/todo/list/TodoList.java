package database.todo.list;

import java.util.ArrayList;

public class TodoList {

    private String date;
    private String Title ;
    private ArrayList<String> todoListDisplay ;
    private ArrayList<String> completedList ;

    public TodoList() {
        todoListDisplay = new ArrayList() ;
        completedList = new ArrayList() ;
    }

    public TodoList(String date, String Title) {
        this();
        this.date = date;
        this.Title = Title;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return Title;
    }

    public ArrayList<String> getTodoListDisplay() {
        return todoListDisplay;
    }

    public ArrayList<String> getCompletedList() {
        return completedList;
    }

    @Override
    public String toString() {
        return "TodoList{" + "date=" + date + ", Title=" + Title + '}';
    }
    
    
}
