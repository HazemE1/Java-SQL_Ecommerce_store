package model;

public class Discount {
    private int discountCode;
    private double discountPercentage;
    private String discountReason;


    public Discount(int discountCode, double discountPercentage, String discountReason) {
        this.discountCode = discountCode;
        this.discountPercentage = discountPercentage;
        this.discountReason = discountReason;
    }

    public int getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(int discountCode) {
        this.discountCode = discountCode;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getDiscountReason() {
        return discountReason;
    }

    public void setDiscountReason(String discountReason) {
        this.discountReason = discountReason;
    }

}
