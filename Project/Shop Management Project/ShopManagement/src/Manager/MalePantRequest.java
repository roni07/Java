package Manager;

public class MalePantRequest {

    private int id;
    private String brandName;
    private int quantity;

    public MalePantRequest(int id, String brandName, int quantity) {
        this.id = id;
        this.brandName = brandName;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "MalePantRequest{" + "id=" + id + ", brandName=" + brandName + ", quantity=" + quantity + '}';
    }
    
    
}
