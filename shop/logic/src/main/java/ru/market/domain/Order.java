package ru.market.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "zakaz")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

    @OneToMany (mappedBy = "order")
    private List<ProductInOrder> productInOrders;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public List<ProductInOrder> getProductInOrders() {
        return productInOrders;
    }

    public void setProductInOrders(List<ProductInOrder> productInOrders) {
        this.productInOrders = productInOrders;
    }
}
