package ploymorphism;

public abstract class Product extends Object {
    protected String productName;
    
    public Product(){
        productName = "Product";
    }
    
    public abstract int getId();
    public abstract String getBrand();
    public abstract double getPrice();
    public abstract int getQuantity();
    
    @Override
    public String toString(){
        return productName + ",id = "+ getId() + ", Brand = " + getBrand() + 
                ", Price = " + getPrice() + ", Quantity = " + getQuantity() ;
    }
}
