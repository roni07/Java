package javaapplication6;

public class Account_Details extends Balance {
    Account_Details(double amount) {
        super(amount);
    }

    void print(String n, String ac, double bal){
        System.out.println(n);
        System.out.println(ac);
        System.out.println(bal);
    }
}
