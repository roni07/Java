
package student;

import java.util.Scanner ;

public class GradeBook {
    private String courseName ;
    
    public GradeBook(){
        
    }
    
    
    public GradeBook(String courseName){
        this.courseName = courseName ;
    }
    
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    
    public String getCourseName(){
        return courseName ;
    }
    
    public void displayMessage(){
        System.out.printf("Welcome to grade book \n%s\n\n",getCourseName());
    }
    
    public void deterMineClassAverage(){
        Scanner inputMarks = new Scanner(System.in) ;
        int Marks ;
        int Total = 0 ;
        double Average ;
        for(int i = 0 ; i < 10 ; i++){
            System.out.printf("Enter Marks : ") ;
            Marks = inputMarks.nextInt() ;
            Total = Total + Marks ;
        }
        System.out.println();
        System.out.printf("Total Marks = %s\n",Total);
        Average = (double)Total/10 ;
        System.out.printf("Average Mark = %.1f\n",Average) ;
    }
    
}
