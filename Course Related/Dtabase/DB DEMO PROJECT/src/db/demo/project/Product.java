/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.demo.project;

/**
 *
 * @author Mehedi
 */
public class Product {
    private int productID ;
    private String productName ;
    private double unitPrice ;
    private String unitType ;
    
    public Product(){
        
    }
    
    public Product(int productID , String productName , double unitPrice, String unitType){
        this.productID = productID ;
        this.productName = productName ;
        this.unitPrice = unitPrice ;
        this.unitType = unitType ;
    }
    
    public String getProductName(){
        return productName ;
    }
    
    public double getUnitPrice(){
        return unitPrice ;
    }

    public int getProductID() {
        return productID;
    }

    public String getUnitType() {
        return unitType;
    }
    
    

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", unitPrice=" + unitPrice + '}';
    }
    
}
