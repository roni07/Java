package javaapplication6;

public class Balance extends Account {

    private double Balance;

    public Balance(double bal) {
        Balance = bal;
    }

    public void setBalance(double bal) {
        Balance = bal;
    }

    public double getBalance() {
        return Balance;
    }

    @Override
    void withdraw(double amount) {
        if (amount <= Balance) {
            Balance = Balance - amount;
            System.out.println(Balance);

        } else {
            System.out.println("Insufficient Balance");
        }

    }

    @Override
    void Deposit(double amount) {
        Balance = this.Balance + amount;
        System.out.println(Balance);

    }
}
