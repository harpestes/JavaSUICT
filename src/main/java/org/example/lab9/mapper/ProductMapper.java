package org.example.lab9.mapper;

import org.example.lab9.dto.ProductDTO;
import org.example.lab9.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .description(product.getDescription())
                .category(product.getCategory().getName())
                .images(product.getImages())
                .build();
    }
    public static List<ProductDTO> toDTO(List<Product> products) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product product : products) {
            productDTOList.add(toDTO(product));
        }
        return productDTOList;
    }
}
