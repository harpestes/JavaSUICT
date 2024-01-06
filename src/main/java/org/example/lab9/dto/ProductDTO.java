package org.example.lab9.dto;

import lombok.Builder;

import java.util.List;


@Builder
public class ProductDTO {
    private int id;
    private String title;
    private int price;
    private String description;
    private String category;
    private List<String> images;
}
