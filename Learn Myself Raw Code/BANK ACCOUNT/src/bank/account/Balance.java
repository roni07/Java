package bank.account;

public class Balance extends Account {

    private double balance;

    public Balance() {

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

        balance = balance + amount;

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
