package org.example;

import java.util.ArrayList;

public class ECommerceService {
    private final Cart cart;
    private final Order order;

    public ECommerceService(Cart cart, Order order) {
        this.cart = cart;
        this.order = order;
    }

    public boolean addToCart(Product product) {
        return cart.getProducts().add(product);
    }

    public boolean removeFromCart(String productId) {
        Product productToRemove = null;
        for (Product p: cart.getProducts()) {
            if(p.getId().equals(productId)) {
                productToRemove = p;
                break;
            }
        }
        return cart.getProducts().remove(productToRemove);
    }

    public Order placeOrder() {
        Order order = new Order(cart.getProducts());
        cart.setProducts(new ArrayList<>());
        return order;
    }

    public void cancelOrder() {
        order.setStatus(Order.Status.CANCELED);
    }

    public void completeOrder() {
        order.setStatus(Order.Status.COMPLETED);
    }
}
