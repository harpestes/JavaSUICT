package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product implements Comparable<Product>{
    private Integer id;
    private String name;
    private double price;
    private int stock;

    @Override
    public String toString() {
        return "Product: " + id + ", \"" + name + "\"" + ", price " + price + ", stock " + stock + ";  ";
    }

    @Override
    public int compareTo(Product o) {
        return Double.compare(price, o.price);
    }
}
