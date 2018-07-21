package bank.account;

public class Account_Details extends Balance {
        public Account_Details() {
    }
    

    public Account_Details(String name, String account_no, double balance) {
        super(name, account_no, balance);
    }


    public void Print() {
        System.out.println("Name: " + getName() + "\nAccount Number: " + getAccount_No() + "\nCurrent Balance: " + getBalance());

    }

}
