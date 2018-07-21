
package account;


public class BankAccount {
    private int accountNumber ;
    private String accountName ;
    protected double balance ;
    
    public BankAccount(int accountNumber , String accountName , double balance){
        this.accountNumber = accountNumber ;
        this.accountName = accountName ;
        this.balance = balance ;
    }
    
    public boolean deposit(double ammount){
        if(ammount > 0){
            balance = balance + ammount ;
            return true ;
    } 
        else {
            return false ;
        }
    }
    
    public boolean withdraw(double ammount){
        if(ammount > 0 && ammount <= balance){
            balance = balance - ammount ;
            return true ;
        }
        else{
            return false ;
        }
    }
    
    public double getBalance(){
        return balance ;
    }
    
    @Override
    public String toString(){
        return "Account Number = "+accountNumber+"\nAccount Name = "+accountName+"\nCuurent Balance = "+balance ;
    }
}
