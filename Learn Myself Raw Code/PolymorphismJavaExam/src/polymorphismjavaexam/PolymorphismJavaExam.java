package polymorphismjavaexam;

public class PolymorphismJavaExam {

    public static void main(String[] args) {
        Number n1 = new ComplexNumber(4,5);
        Number n2 = new ComplexNumber(3,7);       
        
        Number c;
//        c = n1.add(n2);
//        System.out.println(c);
        
        c = n1.multiply(n2);
        System.out.println(c);
     }
    
}
