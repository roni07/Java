package ploymorphism;

public class Shoe extends Product {
    private int id;
    private String brand;
    private double price;
    private int quantity;

    public Shoe(int id, String brand, double price, int quantity) {
        productName = "Shoe";
        this.id = id;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
    }
    
    
    @Override
    public int getId(){
        return id;
    }
     
    @Override
    public String getBrand(){
        return brand;
    }
    
    @Override
    public double getPrice(){
        return price;
    }
    
    @Override
    public int getQuantity(){
        return quantity;
    }
       
}
