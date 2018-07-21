package javaapplication6;

import java.util.Scanner;

public class JavaApplication6 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String Name = sc.nextLine();
        String Account_no = sc.nextLine();
        double Balance = sc.nextDouble();

        Account accountObject = new Account_Details(Balance);

        System.out.println("***Options***");
        System.out.println("1.Deposit");
        System.out.println("2.Withdraw");
        System.out.println("3.DisplayAccountInformation");

        Account accountClass;
        accountClass = new Balance(Balance);
        while (true) {

            System.out.println("Enter a Option:");
            int option_no = sc.nextInt();

            if (option_no == 1) {

                double amount = sc.nextDouble();

                accountClass.Deposit(amount);
            } else if (option_no == 2) {
                double amount = sc.nextDouble();

                accountClass.withdraw(amount);
            } else if (option_no == 3) {
                Account_Details account_details_object = new Account_Details(Balance);
                account_details_object.print(Name, Account_no, Balance);
            } else {
                break;
            }

        }

    }
}
