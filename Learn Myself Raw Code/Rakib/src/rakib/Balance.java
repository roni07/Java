package rakib;

public class Balance extends Account {

    private double balance;

    public Balance(){
        
    }
    
    public Balance(String name, String account_no, double balance) {
        super(name, account_no);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;

        } else {
            System.out.println("Invalid Amount");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
        } else {
            System.out.println("Isufficient Balance");
        }
    }
    

}
