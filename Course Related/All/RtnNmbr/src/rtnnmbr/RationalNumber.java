
package rtnnmbr;


public class RationalNumber {
    private long neumerator ;
    private long denominator ;
    
    public RationalNumber(){
        neumerator = 0 ;
        denominator = 1 ;
    }
    
    public RationalNumber(long n,long d){
        neumerator = n ;
        denominator = d ;
    }
    
    public RationalNumber add(RationalNumber b){
        RationalNumber a = this ;
        RationalNumber c = new RationalNumber() ;
        c.denominator = a.denominator * b.denominator ;
        c.neumerator = a.neumerator * b.denominator + a.denominator * b.neumerator ;
        return c ;   
    }
    
    public RationalNumber subtract(RationalNumber b){
        RationalNumber a = this ;
        RationalNumber c = new RationalNumber() ;
        c.denominator = a.denominator * b.denominator ;
        c.neumerator = a.neumerator * b.denominator - a.denominator * b.neumerator ;
        return c ;   
    }
    
//    public RationalNumber AlterSub(RationalNumber b){
//        RationalNumber a = this ;
//        return add(new RationalNumber(-b.neumerator,b.denominator)) ;
//    }
    
    public RationalNumber multiply(RationalNumber b){
        RationalNumber a = this ;
        RationalNumber c = new RationalNumber() ;
        c.neumerator = a.neumerator * b.neumerator ;
        c.denominator = a.denominator * b.denominator;
        return c ;   
    }
    
    public RationalNumber division(RationalNumber b){
        RationalNumber a = this ;
        RationalNumber c = new RationalNumber() ;
        c.denominator = a.denominator * b.neumerator ;
        c.neumerator = a.neumerator * b.denominator ;
        return c ;   
    }
    
//    public RationalNumber ALterdivide(RationalNumber b){
//        RationalNumber a = this ;
//        return multiply(new RationalNumber(b.denominator,b.neumerator)) ;   
//    }
    
    public String toString(){
        return neumerator+ "/" +denominator ;
    }
}
