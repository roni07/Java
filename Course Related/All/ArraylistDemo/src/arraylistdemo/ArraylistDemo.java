
package arraylistdemo;

import java.util.ArrayList;


public class ArraylistDemo {

    public double average(ArrayList<Integer>integerlist){
        double sum = 0 ;
        for(int i = 0 ; i < integerlist.size() ; i++){
            sum = sum + integerlist.get(i) ;
        }
        double avg = sum/integerlist.size() ;
        return avg ;
    }
    
    public ArraylistDemo(){
        ArrayList<String> stringlist = new ArrayList<>() ;
        stringlist.add("Apple");
       stringlist.add("Banana");
        stringlist.add("125.01");
        stringlist.add("Cranberry");
        stringlist.add("33");
        stringlist.add("33a55");
        System.out.println(stringlist);
        //System.out.println(reverseList(stringlist));
        //System.out.println("# of integers: " + countIntegers(stringlist));
        ArrayList<Integer> inlist = new ArrayList<>() ;
        inlist.add(12) ;
        inlist.add(10) ;
        inlist.add(18) ;
        inlist.add(13) ;
        System.out.println("Average " + average(inlist));
    }
    
    public static void main(String[] args) {
        new ArraylistDemo() ;
    }
    
}
