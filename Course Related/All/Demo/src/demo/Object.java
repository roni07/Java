package demo;

import java.util.ArrayList;

/**
 *
 * @author Mehedi
 */
public class Object {
    private String title;
    private ArrayList<String> item;

    public Object() {
        item = new ArrayList<>();
    }

    public Object(String title) {
        this();
        this.title = title;
    }

    public ArrayList<String> getItem() {
        return item;
    }

    public void setItem(ArrayList<String> item) {
        this.item = item;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Object{" + "title=" + title + ", item=" + item + '}';
    }
    
    
}
