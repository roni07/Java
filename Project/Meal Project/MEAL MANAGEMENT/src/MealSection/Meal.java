package MealSection;


public class Meal {
    private String name;
    private int breakfast;
    private int lunch;
    private int dinner;
    private int total;
    private String date;
    private String num;

    public Meal() {
    }

    public Meal(String name, int breakfast, int lunch, int dinner, int total, String date) {
        this.name = name;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.total = total;
        this.date = date;
    }

    public Meal(String name, int breakfast, int lunch, int dinner, int total, String date, String num) {
        this.name = name;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.total = total;
        this.date = date;
        this.num = num;
    }

    
   
    

    public String getDate() {
        return date;
    }

    public int getBreakfast() {
        return breakfast;
    }

    public int getLunch() {
        return lunch;
    }

    public int getDinner() {
        return dinner;
    }
    
    public int getTotal() {
        return total;
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }
    

    @Override
    public String toString() {
        return "Meal{" + "name=" + name + ", breakfast=" + breakfast + ", lunch=" + lunch + ", dinner=" + dinner + ", total=" + total + ", date=" + date + ", num=" + num + '}';
    }
    

    

    
    
    
    
}
