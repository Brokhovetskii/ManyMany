package com.example.manytomany.Controllers;

import com.example.manytomany.Requests.ShopAssociateRequest;
import com.example.manytomany.Requests.ShopCreateRequest;
import com.example.manytomany.Responses.GetShopResponse;
import com.example.manytomany.Responses.IdResponse;
import com.example.manytomany.Responses.SimpleResponse;
import com.example.manytomany.Service.SomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/get/{id}")
    public GetShopResponse getShopById(@PathVariable(name = "id") Long id) {
        return service.getShopById(id);
    }
    @GetMapping("/search")
    public List<GetShopResponse> getShopsByAddress(@RequestParam("address") String address) {
        return service.getShopsByAddress(address);
    }
}
