package org.example.lab9.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String title;
    private int price;
    private String description;
    private Category category;
    private List<String> images;
}
