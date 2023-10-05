package org.example;

import lombok.Data;
import lombok.NonNull;

import java.util.Random;

@Data
public class Product {
    private String id = idGenerator();
    @NonNull
    private String name;
    @NonNull
    private float price;

    private String idGenerator() {
        return new Random().ints(48, 123)
                .limit(16)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
