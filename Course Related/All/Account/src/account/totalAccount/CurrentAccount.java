
package account.totalAccount;

public class CurrentAccount extends BankAccount{
    public CurrentAccount(int accountId,String accountName,String emailAddress,double balance){
        super(accountId,accountName,emailAddress,balance) ;
    }
    
    @Override
    public boolean withdraw(double ammount){
        
        return super.withdraw(ammount + 20 ) ;
        /*if(ammount > 0 && ammount + 20 <= balance){
            balance = balance - ammount - 20 ;
        return true ;
        }
        else {
            return false ;
        }*/ 
    
    }
}
