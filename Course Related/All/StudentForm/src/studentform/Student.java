
package studentform;

import java.time.LocalDate;

public class Student {
    private String id ;
    private String name ;
    private LocalDate date ;
    
    public Student(){
 
    }
    
    public Student(String id , String name , LocalDate date){
        this() ;
        this.id = id ;
        this.date = date ;
        this.name = name ;
    }
    
    public String getStudentId(){
        return id ;
    }
    
    public String getName(){
        return name ;
    }
    
    public LocalDate getDate(){
        return date ;
    }
    

    @Override
    public String toString() {
        return id ;
    }
    
}
