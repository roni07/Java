package polymorphismjavaexam;

public class ComplexNumber extends Number{
    private double real;
    private double img;

    public ComplexNumber(double r, double i) {
        real = r;
        img = i;
    }
    

    public ComplexNumber add(ComplexNumber b){
         ComplexNumber a = this ;
        double r = a.real + b.real ;
        double i = a.img+ b.img ;
        ComplexNumber c = new ComplexNumber (r,i) ;
        return c ;
    }
    
    public ComplexNumber multiply(ComplexNumber b){
        ComplexNumber a = this ;
        double r = a.real * b.real - a.img*b.img;
        double i = a.real*b.img + a.img*b.real;
        ComplexNumber c = new ComplexNumber (r,i) ;
        return c ;
    }
    
    
    @Override
    public Number add(Number b){
        return this.add(b);
    }
    
    @Override
    public Number multiply(Number b){
        return this.multiply(b);
    }

    @Override
    public String toString() {
        return "ComplexNumber{" + "real=" + real + ", img=" + img + '}';
    }
    
    
    
}
