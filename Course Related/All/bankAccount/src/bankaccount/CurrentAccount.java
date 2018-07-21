
package bankaccount;

import java.util.Scanner ;

public class CurrentAccount {
    private double balance ;
    
    
    public CurrentAccount(){
        
    }
    
    public CurrentAccount(double balance){
        if(balance>0.0)
        {
            this.balance = balance ;
        }
    }
    
    public void DsiplayMessage(){     
        
        System.out.printf("Current Balance = $%.2f\n",balance) ;
        Scanner inputDeposit = new Scanner(System.in) ;
        System.out.println("PLease Enter How Much Money Do you want to deposit");
        double deposit ;
        deposit = inputDeposit.nextDouble() ;
        System.out.printf("You want to deposit $%.2f\n",deposit) ;
        balance += deposit;
        System.out.printf("Your new balance is $%.2f\n",balance) ;

    }
    
}
