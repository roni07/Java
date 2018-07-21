
package examsolve;

public class ExamSolve {

    public static void main(String[] args) {
        Vector3 u = new Vector3(3,5,-2) ;
        Vector3 v = new Vector3(2,1,4) ;
        
        double magnitude = v.Magnitude() ;
        System.out.printf("Magnitude = %.2f\n",magnitude);
        
        int dot = u.dotProduct(v) ;
        System.out.printf("Dot = %s\n",dot);
        
        System.out.println(u);
    }
    
}
