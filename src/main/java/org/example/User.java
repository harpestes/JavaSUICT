package org.example;

import lombok.Data;
import lombok.NonNull;

import javax.management.InstanceAlreadyExistsException;
import java.rmi.NoSuchObjectException;
import java.util.HashMap;
import java.util.Map;

@Data
public class User {
    private Integer id;
    private String username;
    private Map<Product, Integer> cart;
    private Map<Product, Integer> historyOfOrders;

    public User(@NonNull Integer id, @NonNull String username) {
        this.id = id;
        this.username = username;
        cart = new HashMap<>();
        historyOfOrders = new HashMap<>();
    }

    public Integer addToCart(@NonNull Product product, Integer count) throws InstanceAlreadyExistsException {
        if(!cart.containsKey(product) && count > 0) {
            return cart.put(product, count);
        }
        else if(count <= 0) {
            throw new IllegalArgumentException("You entered a wrong value");
        }
        else {
            throw new InstanceAlreadyExistsException("Cart already has this product!");
        }
    }

    public Integer removeFromCart(Product product) throws NoSuchObjectException {
        if(cart.containsKey(product)) {
            return cart.remove(product);
        }
        else {
            throw new NoSuchObjectException("Cart doesn't contain this product");
        }
    }

    public void clearCart() {
        cart = new HashMap<>();
    }

    public boolean changeCountOfProducts(Product product, Integer count) throws NoSuchObjectException {
        if(cart.containsKey(product) && count > 0) {
            return cart.replace(product, cart.get(product), count);
        }
        else if(count <= 0) {
            throw new IllegalArgumentException("You entered a wrong value");
        }
        else {
            throw new NoSuchObjectException("Cart doesn't contain this product");
        }
    }

    public void updateHistory(@NonNull Order order) {
        order.getOrderDetails().forEach(((product, amount) -> historyOfOrders.merge(product, amount, Integer::sum)));
    }
}
