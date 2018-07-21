package db.gui.demo;

public class todoList {

    private int id;
    private String taskName;
    private int todoId;

    public todoList() {
    }

    public todoList(int id, String taskName, int todoId) {
        this.id = id;
        this.taskName = taskName;
        this.todoId = todoId;
    }

    public int getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getTodoId() {
        return todoId;
    }

    @Override
    public String toString() {
        return taskName ;
    }
}
