package model;

import java.util.UUID;

public class Order {
    private String id;
    private String items;
    private OrderStatus status;


    public Order(String id, String items, OrderStatus status) {
        this.id = id;
        this.items = items;
        this.status = status;
    }

    public Order() {
        this.id = UUID.randomUUID().toString();
        this.items = "";
        this.status = OrderStatus.CURRENT;
    }

    public void addProductToOrder(Product product) {
        items += product.getCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
