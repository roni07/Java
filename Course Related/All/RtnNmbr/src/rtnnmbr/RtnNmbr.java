
package rtnnmbr;

public class RtnNmbr {

    public static void main(String[] args) {
        RationalNumber a = new RationalNumber (2, 3) ;
        RationalNumber b = new RationalNumber (3, 4) ;
        RationalNumber c ;
        
        System.out.println("A : " +a) ;
        System.out.println("B : " +b) ;
        
        c = a.add(b) ;
        
        System.out.println("Add : " +c) ;
        
        c = a.subtract(b) ;
        System.out.println("Subtract : " +c) ;
        
//        c = a.AlterSub(b) ;
//        System.out.println("Subtract : " +c) ;
        
        c = a.multiply(b) ;
        System.out.println("Multiply : " +c) ;
        
         c = a.division(b) ;
        System.out.println("Division : " +c) ;
        
//         c = a.ALterdivide(b) ;
//        System.out.println("Division : " +c) ;
    }
    
}
