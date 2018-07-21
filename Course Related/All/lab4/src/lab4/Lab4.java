
package lab4;

public class Lab4 {

    public static void main(String[] args) {
     Student s = new Student(12,"Roni") ;
     Course c1 = new Course("CSE1011","c",3) ;
     Course c2 = new Course("CSE2021","c lab",1) ;
     Course c3 = new Course("MATH1025","GEO",3) ;
     
     s.addCourse(c1) ;
     s.addCourse(c2) ;
     s.addCourse(c3) ;
     
     System.out.println(s);
     System.out.println("Total Credits : " +s.getTotalCredit());
    }
    
}
