package com.example.manytomany.MapDTO;

import com.example.manytomany.DBmodels.Product;
import com.example.manytomany.DBmodels.Shop;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ShopMap {
    private final String address;
    private final Map<Long, ProductForMap> products = new HashMap<>();

    public ShopMap(Shop shop) {
        this.address = shop.getAddress();
        shop.getProductses()
                .forEach(product -> this.products.put(product.getId(), new ProductForMap(product)));
    }
}
