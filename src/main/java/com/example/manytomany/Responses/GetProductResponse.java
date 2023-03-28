package com.example.manytomany.Responses;

import com.example.manytomany.DBmodels.Product;
import com.example.manytomany.DTO.ShopDTO;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class GetProductResponse {
    private Long id;
    private String title;
    private Long price;
    private List<ShopDTO> shops;

    public GetProductResponse(Product product){
        this.id = product.getId();
        this.title = product.getName();
        this.price = product.getPrice();
        this.shops = product.getShops().stream().map(ShopDTO::new).collect(Collectors.toList());
    }
}
