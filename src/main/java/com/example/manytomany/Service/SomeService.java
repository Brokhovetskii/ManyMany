package com.example.manytomany.Service;

import com.example.manytomany.DBmodels.Product;
import com.example.manytomany.DBmodels.Shop;
import com.example.manytomany.DTO.ShopDTO;
import com.example.manytomany.MapDTO.ProductMap;
import com.example.manytomany.MapDTO.ShopMap;
import com.example.manytomany.Repository.ProductRepository;
import com.example.manytomany.Repository.ShopRepository;
import com.example.manytomany.Requests.*;
import com.example.manytomany.Responses.GetProductResponse;
import com.example.manytomany.Responses.GetShopResponse;
import com.example.manytomany.Responses.IdResponse;
import com.example.manytomany.Responses.SimpleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
    public GetProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "продукт не найден"));
        return new GetProductResponse(product);
    }
    public List<GetProductResponse> getProductsByTitle(String title) {
        return productRepository.findByNameContainsIgnoreCase(title)
                 .stream()
                 .map(GetProductResponse::new)
                 .collect(Collectors.toList());
    }
    public GetShopResponse getShopById(Long id){
        Shop shop = shopRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "магазин не найден"));
        return new GetShopResponse(shop);
    }
    public List<GetShopResponse> getShopsByAddress(String address) {
        return shopRepository.findByAddressContainsIgnoreCase(address)
                .stream()
                .map(GetShopResponse::new)
                .collect(Collectors.toList());
    }
    public List<ShopMap> getMappedProducts(String address) {
       return shopRepository.findByAddressContainsIgnoreCase(address)
               .stream()
               .map(ShopMap::new)
               .collect(Collectors.toList());
    }
    public List<ProductMap> getMappedShops(String title) {
        return productRepository.findByNameContainsIgnoreCase(title)
                .stream()
                .map(ProductMap::new)
                .collect(Collectors.toList());
    }
}
