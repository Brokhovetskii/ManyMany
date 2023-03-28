package com.example.manytomany.MapDTO;

import com.example.manytomany.DBmodels.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductMap {
    private String title;
    Map<Long, ShopForMap> shops = new HashMap<>();

    public ProductMap (Product product) {
        this.title = product.getName();
        product.getShops().forEach(shop -> this.shops.put(shop.getId(), new ShopForMap(shop)));
    }
}
