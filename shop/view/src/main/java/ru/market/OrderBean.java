package ru.market;


import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ru.market.domain.Order;
import ru.market.domain.Product;
import ru.market.ejb.OrdersManagerBean;
import ru.market.ejb.ProductManagerBean;


import java.io.Serializable;
import java.util.Collections;
import java.util.List;


@Named
@SessionScoped
public class OrderBean implements Serializable {

    private Order order;
    private String name;
    private int price;
    private int quantity;

    @EJB
    OrdersManagerBean ordersManagerBean;

    @EJB
    ProductManagerBean productManagerBean;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void createOrder () {
        if (order==null) {
            order=ordersManagerBean.createOrder();
        }
    }

    public void createProduct () {
            productManagerBean.createProduct(name,price,quantity);
    }

    public List<Product> getProduct () {
        return productManagerBean.getAllProduct();
    }

    public void addProductInOrder (Product product) {
        if (order==null) {
            return;
        }
        ordersManagerBean.addInOrder(product.getProductId(),order.getOrderId(),quantity);
    }
    public List<Product> getProductsInOrder () {

        if(order==null) {
            return  Collections.emptyList();
        }

        return ordersManagerBean.getProductInOrder(order.getOrderId());

    }
}
