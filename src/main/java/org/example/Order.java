package org.example;

import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
public class Order {
    private final String orderId = idGenerator();
    private final List<Product> products;
    private Status status;

    public Order(List<Product> products) {
        this.products = products;
        status = Status.IN_PROGRESS;
    }

    public enum Status {
        CANCELED,
        COMPLETED,
        IN_PROGRESS
    }

    private String idGenerator() {
        return new Random().ints(48, 123)
                .limit(16)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
