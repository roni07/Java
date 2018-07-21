package BajarSection;

public class AddBajar {

    private String name;
    private String date;
    private double purchage;

    public AddBajar(String name, String date, double purchage) {
        this.name = name;
        this.date = date;
        this.purchage = purchage;
    }

    public String getDate() {
        return date;
    }

    public double getPurchage() {
        return purchage;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AddBajar{" + "name=" + name + ", date=" + date + ", purchage=" + purchage + '}';
    }

}
