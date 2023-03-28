package com.example.manytomany.Responses;

import com.example.manytomany.DBmodels.Shop;
import com.example.manytomany.DTO.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetShopResponse {
    private Long id;
    private String address;
    private List<ProductDTO> products;

    public GetShopResponse (Shop shop){
        this.id = shop.getId();
        this.address = shop.getAddress();
        this.products = shop.getProductses().stream().map(ProductDTO::new).collect(Collectors.toList());
    }
}
