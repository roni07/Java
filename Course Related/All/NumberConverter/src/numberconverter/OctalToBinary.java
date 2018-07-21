package numberconverter;

public class OctalToBinary {
private long result ;
private long remainder ;
private long power ;
private long decimalResult ;
private long shift ;

public OctalToBinary(){
      power = 0 ; 
      decimalResult = 0 ;
      shift = 1 ;
      result = 0 ;
}

public long getOctalToBinary(long octal){
    while(octal > 0){
        decimalResult = (long) (decimalResult + (octal % 10) * Math.pow(8 , power) ) ;
        octal = octal / 10 ;
        power++ ;
    }
    while(decimalResult > 0){
        remainder = decimalResult % 2 ;
        result = result + remainder * shift ;
        shift = shift * 10 ;
        decimalResult = decimalResult / 2 ;
    }
    return result ;
}

}
