package rakib;

import java.util.Scanner;

public class Rakib {

    public static void main(String[] args) {
        String Name;
        String Account_Number;
        double Balance;

        int exit;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter  Account Name: ");
        Name = input.nextLine();
        System.out.println("Enter Account Number: ");
        Account_Number = input.nextLine();
        System.out.println("Enter Balance: ");
        Balance = input.nextDouble();

        Account_Details ad = new Account_Details(Name, Account_Number, Balance);
        ad.Print();

        System.out.println("**OPTIONS**");
        System.out.println("1.Deposit");
        System.out.println("2.Withdraw");
        System.out.println("3.Display Account Information");
        System.out.println("4.Exit");

        System.out.println("Enter An Option: ");
        exit = input.nextInt();

        while (exit != 4) {
            if (exit > 4 || exit < 1) {
                System.out.println("Invalid input!");
                System.out.println("**OPTIONS**");
                System.out.println("1.Deposit");
                System.out.println("2.Withdraw");
                System.out.println("3.Display Account Information");
                System.out.println("4.Exit");
            } else {
                if (exit == 1) {
                    Balance = input.nextDouble();

                    ad.deposit(Balance);
                } else if (exit == 2) {
                    Balance = input.nextDouble();

                    ad.withdraw(Balance);
                } else if (exit == 3) {
                    ad.Print();
                }
            }

            System.out.println("Enter An Option: ");
            exit = input.nextInt();
        }
    }

}
