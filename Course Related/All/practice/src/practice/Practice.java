
package practice;


public class Practice {

    public static void S_tring(){
        
        String[] item1 = {"Apple","Banana","Orange","Guava","Pineapple","Jackfruit"} ;
        String[] item2 = {", Rice",", Fish",", tea",", water"} ;
        
        int length1 = item1.length ;
        int length2 = item2.length ;
        
        int rand1 = (int) (Math.random() * length1) ;
        int rand2 = (int) (Math.random() * length2) ;
        
        String add = item1[rand1]  + " " + item2[rand2] ; 
        
        System.out.printf("You like to eat " +add) ;
        System.out.printf("\n") ;
       

    }  
    
    
    
    public static void main(String[] args) {
        S_tring() ;
    }
    
}
