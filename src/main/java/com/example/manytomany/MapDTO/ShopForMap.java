package com.example.manytomany.MapDTO;

import com.example.manytomany.DBmodels.Shop;
import lombok.Data;

@Data
public class ShopForMap {
    private String address;

    public ShopForMap (Shop shop) {
        this.address = shop.getAddress();
    }
}
