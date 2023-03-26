package com.example.manytomany.Service;

import com.example.manytomany.DBmodels.Product;
import com.example.manytomany.DBmodels.Shop;
import com.example.manytomany.Repository.ProductRepository;
import com.example.manytomany.Repository.ShopRepository;
import com.example.manytomany.Requests.ProductAssociateRequest;
import com.example.manytomany.Requests.ProductCreateRequest;
import com.example.manytomany.Requests.ShopAssociateRequest;
import com.example.manytomany.Requests.ShopCreateRequest;
import com.example.manytomany.Responses.IdResponse;
import com.example.manytomany.Responses.SimpleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
@RequiredArgsConstructor
public class SomeService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ShopRepository shopRepository;

    public SimpleResponse associateProductByShop(ProductAssociateRequest request) {
        Product product = productRepository.findById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "продукт не найден"));
        Shop shop = shopRepository.findById(request.getShopId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "магазин не найден"));
        product.getShops().add(shop);
        productRepository.save(product);
        return new SimpleResponse(true);
    }

    public SimpleResponse associateShopByProduct(ShopAssociateRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "продукт не найден"));
        Shop shop = shopRepository.findById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "магазин не найден"));
        shop.getProductses().add(product);
        shopRepository.save(shop);
        return new SimpleResponse(true);
    }

    public IdResponse createProduct(ProductCreateRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .build();
        Product savedProduct = productRepository.save(product);
        return new IdResponse(savedProduct.getId());
    }

    public IdResponse createShop(ShopCreateRequest request) {
        Shop shop = Shop.builder()
                .address(request.getAddress())
                .build();
        Shop savedShop = shopRepository.save(shop);
        return new IdResponse(savedShop.getId());
    }
}
