
package javaapplication6;


public abstract class Account {
    private String Name;
    private String Account_no;

    Account(String n,String ac){
        Name = n;
        Account_no = ac;
    }

    public Account() {

    }

    abstract
    void withdraw(double amount);

    abstract
    void Deposit(double amount);
}
