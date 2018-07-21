
package updatetest;

public class TstC {
    private int id;
    private String name;

    public TstC(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TstC{" + "id=" + id + ", name=" + name + '}';
    }
 
}
