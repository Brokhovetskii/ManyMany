package com.example.manytomany.Controllers;

import com.example.manytomany.Requests.ShopAssociateRequest;
import com.example.manytomany.Requests.ShopCreateRequest;
import com.example.manytomany.Responses.IdResponse;
import com.example.manytomany.Responses.SimpleResponse;
import com.example.manytomany.Service.SomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shops")
public class ShopsController {
    private final SomeService service;
    @PostMapping("/create")
    public IdResponse createShop(@RequestBody ShopCreateRequest shopCreateRequest) {
        return service.createShop(shopCreateRequest);
    }
    @PostMapping("/associate")
    public SimpleResponse associateShop(@RequestBody ShopAssociateRequest shopAssociateRequest) {
        return service.associateShopByProduct(shopAssociateRequest);
    }
}
