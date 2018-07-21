
package cpx;

public class Cpx {

    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber (4, 3) ;
        ComplexNumber b = new ComplexNumber (3, 5) ;
        
        ComplexNumber c ;
        
        c = a.add(b) ;
        System.out.println("Add = " +c);
        
         c = a.sub(b) ;
        System.out.println("Subtract = " +c);
        
        c = a.multiply(b) ;
        System.out.println("multiply = " +c);
        
        c = a.divide(b) ;
        System.out.println("Division = " +c);
    }
    
}
