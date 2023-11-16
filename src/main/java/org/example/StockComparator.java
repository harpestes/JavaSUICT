package org.example;

import java.util.Comparator;

public class StockComparator implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return Integer.compare(product2.getStock(), product1.getStock());
    }
}
