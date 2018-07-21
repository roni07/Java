
package account.totalAccount;

public class BankAccount {
    private int accountId ;
    private String accountName ;
    private String emailAddress ;
    protected double balance ;
    
    public BankAccount(int accountId , String accountName, String emailAddress , double balance){
       this.accountId = accountId ;
       this.accountName = accountName ;
       this.emailAddress = emailAddress ;
       this.balance = balance ;
    }
    
    public boolean deposit(double ammount){
        if(ammount>=0){
            balance = balance + ammount ;
            return true ;
        }
        else
        {
            return false ;
        }
    }
    
    public boolean withdraw(double ammount){
       if(ammount > 0 && ammount <=balance){
           balance = balance - ammount ;
           return true ;
       }
       else
       {
         return false ;  
       }
    }
    
//    public double getBalance(){
//        return balance ;
//    }
    
    public void displayMessage(){
        System.out.printf("Account Id = %s\n",accountId) ;
        System.out.printf("Account Name = %s\n",accountName) ;
        System.out.printf("Email Address = %s\n",emailAddress) ;
        System.out.printf("Balance = %s\n",balance) ;
    }
    
}
