
package account;


public class CurrentAccount extends BankAccount{
     public CurrentAccount(int accountNumber , String accountName , double balance){
         super(accountNumber , accountName , balance) ;
     }
      
    public boolean depsoit(double ammount){
        return super.deposit(ammount) ;
    } 
     
     @Override
     public boolean withdraw(double ammount){
       return super.withdraw(ammount + 20) ;
     }  
}
