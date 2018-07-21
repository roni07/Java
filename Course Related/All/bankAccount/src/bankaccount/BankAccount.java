package bankaccount;

import java.util.Scanner;

public class BankAccount {

    public static void main(String[] args) {
        Login login = new Login();
        Account jhon = new Account("Jhon Doe", "21034");
        CurrentAccount currentBalance = new CurrentAccount(100.00);
        
        System.out.println("Enter your password : ");
        Scanner input = new Scanner(System.in);
        String pass = input.nextLine();
        if (login.checkLogin(pass) > 0) {
            jhon.displayMessage() ;
            currentBalance.DsiplayMessage(); 
        }
        else
        {
            System.out.println("Your password is incorrect!");
        }
    }

}
