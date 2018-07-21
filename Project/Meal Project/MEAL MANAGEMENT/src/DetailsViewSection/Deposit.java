package DetailsViewSection;

public class Deposit {

    private int payment;
    private String num;

    public Deposit(int payment, String num) {
        this.payment = payment;
        this.num = num;
    }

    public int getPayment() {
        return payment;
    }

    public String getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Deposit{" + "payment=" + payment + ", num=" + num + '}';
    }

}
