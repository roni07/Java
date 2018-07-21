package BuyerMaleView;

public class MaleShirt {

    private final int id;
    private final String brandName;
    private final double price;
    private final int quantity;

    public MaleShirt(int id, String brandName, double price, int quantity) {
        this.id = id;
        this.brandName = brandName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "MalePant{" + "id=" + id + ", brandName=" + brandName + ", price=" + price + ", quantity=" + quantity + '}';
    }
}
