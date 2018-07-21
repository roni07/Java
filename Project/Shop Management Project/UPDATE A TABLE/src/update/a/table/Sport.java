package update.a.table;

public class Sport {
    
    private String sport;
    private int quantity;

    public Sport(String sport, int quantity) {
        this.sport = sport;
        this.quantity = quantity;
    }

  
   
   public String getSport(){
       return sport;
   }
   
   public int getQuantity(){
       return quantity;
   }

    @Override
    public String toString() {
        return "Sport{" + "sport=" + sport + ", quantity=" + quantity + '}';
    }

   
}
