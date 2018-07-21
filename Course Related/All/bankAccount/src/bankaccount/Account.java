
package bankaccount;

public class Account {

    private String accountName ;
    private String accountNumber ;
    
    public Account(){
        
    }
    
    public Account(String accountName, String  accountNumber){
 
        this.accountName = accountName ;
        this.accountNumber = accountNumber ;    
       
    }
    
      
    public void displayMessage(){
               
        System.out.printf("Account Name = %s\n",accountName) ;
        System.out.printf("Account Number = %s\n",accountNumber) ;
    }
    
}
