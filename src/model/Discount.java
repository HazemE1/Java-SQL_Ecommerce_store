package model;

import controller.Controller;
import controller.DBController;

import java.util.HashSet;
import java.util.Set;

public class Discount {
    private String discountCode;
    private int discountPercentage;
    private String discountReason;
    private Set<Product> discountedItems;

    public Discount(String discountCode, int discountPercentage, String discountReason) {
        this.discountCode = discountCode;
        this.discountPercentage = discountPercentage;
        this.discountReason = discountReason;
        discountedItems = new HashSet<>();
    }

    public Discount(String discountCode, int discountPercentage, String discountReason, String items) {
        this.discountCode = discountCode;
        this.discountPercentage = discountPercentage;
        this.discountReason = discountReason;
        discountedItems = deCodeProducts(items);
    }


    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getDiscountReason() {
        return discountReason;
    }

    public void setDiscountReason(String discountReason) {
        this.discountReason = discountReason;
    }

    public Set<Product> getDiscountedItems() {
        return discountedItems;
    }

    public void setDiscountedItems(Set<Product> discountedItems) {
        this.discountedItems = discountedItems;
    }

    private String codeProducts() {
        if (getDiscountedItems().isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        for (Product discountedItem : discountedItems) {
            if (discountedItem == null)
                continue;
            sb.append(discountedItem.getProductID()).append(":");
        }
        return sb.substring(0, sb.length() - 1);
    }

    private Set<Product> deCodeProducts(String coded) {
        if (coded == null || coded.isEmpty())
            return new HashSet<>();
        Set<Product> val = new HashSet<>();
        if (!coded.contains(":")) {
            val.add(Controller.getInstance().getProduct(coded));
            return val;
        }
        for (String s : coded.split(":")) {
            Product p = Controller.getInstance().getProduct(s);
            if (p == null)
                continue;
            val.add(p);
        }
        return val;
    }

    public void deleteFromDatabase() {
        DBController.getInstance().executeQuery(String.format("DELETE FROM discount WHERE code='%s'", discountCode));
    }

    public void saveToDatabase() {
        DBController.getInstance().executeQuery(String.format("INSERT INTO discount values ('%s', '%s','%s', '%s')", discountCode, discountPercentage, discountReason, codeProducts()));
    }

    public void applyDiscount() {
        double percentage = 1 - (discountPercentage / 100.0);
        for (Product discountedItem : discountedItems) {
            if (discountedItem == null)
                continue;
            discountedItem.setDiscount(percentage);
        }
        Controller.getInstance().updateProductList();
    }

    @Override
    public String toString() {
        return String.format("%s | %s", getDiscountReason(), getDiscountPercentage()) + "%";
    }

    public void addDiscount(Product product) {
        discountedItems.add(product);
        DBController.getInstance().logDiscount(product, this);
        applyDiscount();
        deleteFromDatabase();
        saveToDatabase();
    }


}
