package com.example.manytomany.DTO;

import com.example.manytomany.DBmodels.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String title;
    private Long price;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.title = product.getName();
        this.price = getPrice();
    }
}
