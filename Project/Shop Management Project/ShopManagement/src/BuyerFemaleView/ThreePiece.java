package BuyerFemaleView;

public class ThreePiece {

    private final int id;
    private final String brand_name;
    private final double price;
    private final int quantity;

    public ThreePiece(int id, String brand_name, double price, int quantity) {
        this.id = id;
        this.brand_name = brand_name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ThreePiece{" + "id=" + id + ", brand_name=" + brand_name + ", price=" + price + ", quantity=" + quantity + '}';
    }

}
