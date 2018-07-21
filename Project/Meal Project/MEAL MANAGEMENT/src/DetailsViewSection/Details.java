package DetailsViewSection;

public class Details {

    private String name;
    private int totalMeal;
    private int deposit;
    private double balance;
    private double perMeal; 

    public Details(String name, int totalMeal, int deposit, double balance, double perMeal) {
        this.name = name;
        this.totalMeal = totalMeal;
        this.deposit = deposit;
        this.balance = balance;
        this.perMeal = perMeal;
    }

    

    public String getName() {
        return name;
    }

    public int getTotalMeal() {
        return totalMeal;
    }

    public int getDeposit() {
        return deposit;
    }

    public double getBalance() {
        return balance;
    }

    public double getPerMeal() {
        return perMeal;
    }
    
    

    @Override
    public String toString() {
        return "Details{" + "name=" + name + ", totalMeal=" + totalMeal + ", deposit=" + deposit + ", balance=" + balance + '}';
    }

}
