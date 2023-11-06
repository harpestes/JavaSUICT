package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }
}
