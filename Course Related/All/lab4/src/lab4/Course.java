
package lab4;

public class Course {
    private String courseCode ;
    private String courseTitle ;
    private double credits ;
    
        
    public Course(){
          
        }
    
    public Course(String courseCode, String courseTitle, double credits){
        this.courseCode = courseCode ;
        this.courseTitle =courseTitle ;
        this.credits = credits ;
    }
    
    public String getCourseCode(){
        return courseCode ;
    }
    
    public String getCourseTitle(){
        return courseTitle ;
    }
    
    public double getCredits(){
        return credits ;
    }
    
    public String toString(){
        return  "Course Code = " + courseCode + " ; Course Title = " + courseTitle + " ; Credits = " + credits ;
    }
}
