
package hello.world;

import java.util.Scanner ;

public class HelloWorld {

   public static void add(){
       int x;
       int y;
       
       System.out.printf("Enter Two number") ;
       
       Scanner scan = new Scanner(System.in) ;
       
       x = scan.nextInt() ;
       y = scan.nextInt() ;
       
       int sum = x + y ;
       
       System.out.printf("Addition = %d\n",sum) ;
       
   }
    public static void main(String[] args) {
     add();
    }
    
}
