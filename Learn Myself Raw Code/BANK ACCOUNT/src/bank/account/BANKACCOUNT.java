package bank.account;

import java.util.Scanner;

public class BANKACCOUNT {

    public static void main(String[] args) {

        String name;
        String account_No;
        double balance;

        int optOut;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter  Account Name: ");
        name = input.nextLine();
        System.out.println("Enter Account Number: ");
        account_No = input.nextLine();
        System.out.println("Enter Balance: ");
        balance = input.nextDouble();

        Account_Details account_details = new Account_Details(name, account_No, balance);
        account_details.Print();

        System.out.println("**OPTIONS**");
        System.out.println("1.Deposit");
        System.out.println("2.Withdraw");
        System.out.println("3.Display Account Information");
        System.out.println("4.Exit");

        System.out.println("Enter An Option: ");
        optOut = input.nextInt();

        while (optOut != 4) {
            if (optOut > 4 || optOut < 1) {
                System.out.println("Invalid input!");
                System.out.println("**OPTIONS**");
                System.out.println("1.Deposit");
                System.out.println("2.Withdraw");
                System.out.println("3.Display Account Information");
                System.out.println("4.Exit");
            } else {
                if (optOut == 1) {
                    balance = input.nextDouble();

                    account_details.deposit(balance);
                } else if (optOut == 2) {
                    balance = input.nextDouble();

                    account_details.withdraw(balance);
                } else if (optOut == 3) {
                    account_details.Print();
                }
            }

            System.out.println("Enter An Option: ");
            optOut = input.nextInt();
        }
    }
}
