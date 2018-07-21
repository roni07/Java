
package crbaca;

import account.BankAccount;
import account.CurrentAccount;


public class Crbaca {

    public static void main(String[] args) {
        BankAccount b = new BankAccount(15432,"Roni",1000) ;
        b.deposit(100) ;
        b.withdraw(200) ;
        //b.balance = 100 ;
        b.getBalance();
        System.out.println(b);
        
        CurrentAccount c = new CurrentAccount(15433,"Jhon",5000) ;
        c.deposit(2000) ;
        c.withdraw(1000) ;
        c.getBalance() ;
        System.out.println(c);
    }
    
}
