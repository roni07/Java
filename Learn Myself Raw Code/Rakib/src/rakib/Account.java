package rakib;

public abstract class Account {

    private String name;
    private String account_no;

    public Account(){
        
    }
    
    public Account(String name, String account_no) {
        this.name = name;
        this.account_no = account_no;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public String getName() {
        return name;
    }

    public String getAccount_No() {
        return account_no;
    }
    


}
