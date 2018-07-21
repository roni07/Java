package studentdetails;

import java.util.Scanner;

public class Information {
    public  void studentInformarion(){
       Scanner input = new Scanner(System.in);
        System.out.println("Enter Your Student ID");
        String Result = input.nextLine();
        String year = Result.substring(0, 4);
        System.out.println("Student Year : " + year);
        String semester = Result.substring(4, 6);
        if (semester.contains("00")) {
            System.out.println("Semester : Spring");
        } else if (semester.contains("11")) {
            System.out.println("Semester : Summer");
        } else if (semester.contains("22")) {
            System.out.println("Semester : Fall");
        }
        else
        {
            System.out.println("Semester : Invalid");
        }
        String id = Result.substring(6, Result.length());
        System.out.println("Student ID : " + id);
    } 
    
}
