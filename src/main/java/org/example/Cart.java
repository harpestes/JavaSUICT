package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Cart {
    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public boolean addToCart(Product product) {
        return products.add(product);
    }

    public boolean removeFromCart(String productId) {
        Product productToRemove = null;
        for (Product p: products) {
            if(p.getId().equals(productId)) {
                productToRemove = p;
                break;
            }
        }
        return products.remove(productToRemove);
    }

    public Order placeOrder() {
        Order order = new Order(products);
        products = new ArrayList<>();
        return order;
    }
}
