package org.example;


import lombok.Data;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Map;

@Data
public class Order {
    @NonNull
    private Integer id;
    @NonNull
    private Integer userId;
    @NonNull
    private Map<Product, Integer> orderDetails;
    private double totalPrice = 0;

    private void calculateTotalPrice() {
        HashSet<Product> products = (HashSet<Product>) orderDetails.keySet();
        for (Product product: products) {
            totalPrice += product.getPrice() * orderDetails.get(product);
        }
    }
}
