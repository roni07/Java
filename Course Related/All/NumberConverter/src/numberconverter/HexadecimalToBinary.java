package numberconverter;

public class HexadecimalToBinary {
    private int value ; 
    private long result ;
    private int power ;
    private long decimalResult ;
    private long remainder ;
    private int shift ;
    
    
    public HexadecimalToBinary(){
        value = 0 ;
        result = 0 ;
        power = 0 ;
        decimalResult = 0 ;
        shift = 1 ;
    }
    
    public long getHexadecimalToBinary(String hexa){
        for (int i = hexa.length()-1 ; i >= 0 ; i++){
            if(hexa.charAt(i) == 'A'){
                value = 10 ;
            }
            else if(hexa.charAt(i) == 'B'){
                value = 11 ;
            }
            else if(hexa.charAt(i) == 'B'){
                value = 11 ;
            }
            else if(hexa.charAt(i) == 'C'){
                value = 13 ;
            }
            else if(hexa.charAt(i) == 'E'){
                value = 14 ;
            }
            else if(hexa.charAt(i) == 'F'){
                value = 15 ;
            }
            else{
                String convertString = hexa.charAt(i) + "" ;
                value = Integer.parseInt(convertString) ;            
            }
            decimalResult = (long)(decimalResult + value * Math.pow(16 , power)) ;
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
