
package examsolve;

public class Vector3 {
    private int i ;
    private int j ;
    private int k ;
    
    public Vector3(int i , int j , int k){
        this.i = i ;
        this.j = j ;
        this.k = k ;
    }
    
    public double Magnitude(){
        return Math.sqrt(i*i+j*j+k*k) ;
    }
    
    public int dotProduct(Vector3  u){
        Vector3 v = this ;
        return u.i*v.i + u.j*v.j + u.k * v.k ;
    }
    
    @Override
    public String toString(){
        return (+i+"i " +j+"j " +k+"k") ; 
    }
    
}
