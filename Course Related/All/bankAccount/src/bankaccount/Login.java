package bankaccount;

public class Login {
    
    int x = 0;
    
    public int checkLogin(String pass){
        if(pass.equals("123"))
        {
            x++;
        }
        return x;
    }
    
}
