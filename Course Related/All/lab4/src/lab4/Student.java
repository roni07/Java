
package lab4;

import java.util.Arrays;

public class Student {
    private int studentId ;
    private String studentName ;
    private Course[] courses;
    private int courseCount ;
    
    public Student(){
        courses = new Course[5] ;
    }
    
    
    public Student(int studentId, String studentName){
        this() ;     //courses = new Courses[5] ;
        this.studentId = studentId ;
        this.studentName = studentName ;
    }
    
    
    public int getStudentId(){
        return studentId ;
    }
    
    public String getStudentName(){
        return studentName ; 
    }

    @Override
    public String toString() {
        return "Student ID = " + studentId + " \nStudent Name = " + studentName + "\nCourses=" + Arrays.toString(courses) + "\nTotal Course = " + courseCount ;
    }


    
    public void addCourse(Course course){
        courses[courseCount] = course ;
        courseCount ++ ;               
    }
    
    public double getTotalCredit(){
        double sum = 0.0 ;
        for(int i =0 ; i < courseCount ; i++){
        sum = sum + courses[i].getCredits() ;
        }
        return sum ;
    }
    
}
    
