
package mod;


public class Conversion {
    private long number ;
    private int shift ;
    private long remainder ;
    private long result ;
    
    public Conversion(){
        shift = 1 ;
        result = 0 ;
    }
    
    public Conversion(long number){
        this.number = number ;
    }
    
    public Conversion decimalToBinary(Conversion binary){
        System.out.println(binary.number%2);
        while(binary.number > 0){
            remainder = binary.number%2 ;
            result = result + remainder*shift ;
            binary.number = binary.number/2 ;
            shift = shift * 10 ;
        }
        Conversion firesult = new Conversion(result) ;
        return firesult;
        
    }

    @Override
    public String toString() {
        return "Decimal Number = " + number ;
    }
    
    
}
