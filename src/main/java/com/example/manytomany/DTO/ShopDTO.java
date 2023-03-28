package com.example.manytomany.DTO;

import com.example.manytomany.DBmodels.Shop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopDTO {
    private Long id;
    private String address;

    public ShopDTO(Shop shop){
        this.id = shop.getId();
        this.address = getAddress();
    }
}
