package PaymentSection;

public class Payment {

    private String name;
    private double payment;
    private String date;

    public Payment(String name, double payment, String date) {
        this.name = name;
        this.payment = payment;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public double getPayment() {
        return payment;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Payment{" + "name=" + name + ", payment=" + payment + ", date=" + date + '}';
    }
    
    
}
