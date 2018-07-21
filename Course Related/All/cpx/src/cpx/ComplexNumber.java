
package cpx;


public class ComplexNumber {
    private double real ;
    private double imaginary ;
    
    public ComplexNumber(double r, double i){
        real = r ;
        imaginary = i ;
    }
    
    public ComplexNumber(){
        
    }
    
    public ComplexNumber add(ComplexNumber b){
        ComplexNumber a = this ;
        double r = a.real + b.real ;
        double i = a.imaginary + b.imaginary ;
        ComplexNumber c = new ComplexNumber (r,i) ;
        return c ;
    }
    
     public ComplexNumber sub(ComplexNumber b){
        ComplexNumber a = this ;
        double r = a.real - b.real ;
        double i = a.imaginary - b.imaginary ;
        ComplexNumber c = new ComplexNumber (r,i) ;
        return c ;
    }
     
      public ComplexNumber multiply(ComplexNumber b){
        ComplexNumber a = this ;
        double r = a.real * b.real - a.imaginary*b.imaginary;
        double i = a.real*b.imaginary + a.imaginary*b.real;
        ComplexNumber c = new ComplexNumber (r,i) ;
        return c ;
    }
      
       public ComplexNumber divide(ComplexNumber b){
        ComplexNumber a = this ;
        
        double lr = b.real*b.real + b.imaginary*b.imaginary ;
        double r = (a.real*b.real + a.imaginary*b.imaginary) /( lr);
        double i = (a.imaginary*b.real - a.real*b.imaginary) /(lr) ;

        ComplexNumber c = new ComplexNumber (r,i) ;
        return c ;
    }
    
    @Override
    public String toString(){
       if(imaginary < 0)
       {
            return String.format("%.2f %.2fi",real,imaginary);
       }
       else
       {
           return String.format("%.2f + %.2fi",real,imaginary);
       }
    }
}
