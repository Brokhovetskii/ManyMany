package com.example.manytomany.MapDTO;

import com.example.manytomany.DBmodels.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductForMap {
    private String title;
    private Long price;

    public ProductForMap(Product product) {
        this.title = product.getName();
        this.price = product.getPrice();
    }
}
