package service;

import entity.Orders;
import form.ProductForm;
import model.CurrentAccount;
import model.ShoppingCart;
import model.SocialAccount;

import java.util.List;

public interface OrderService {

    void addProductToShoppingCart(ProductForm productForm, ShoppingCart shoppingCart);

    void removeProductFromShoppingCart(ProductForm form, ShoppingCart shoppingCart);

    String serializeShoppingCart(ShoppingCart shoppingCart);

    ShoppingCart deserializeShoppingCart(String string);

    CurrentAccount authentificate(SocialAccount socialAccount);

    long makeOrder (ShoppingCart shoppingCart, CurrentAccount currentAccount);

    Orders findOrderById(long id, CurrentAccount currentAccount);

    List<Orders> listMyOrders(CurrentAccount currentAccount, int page, int limit);

    int countMyOrders(CurrentAccount currentAccount);
}
