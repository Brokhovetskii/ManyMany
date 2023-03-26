package com.example.manytomany.Controllers;

import com.example.manytomany.Requests.ProductAssociateRequest;
import com.example.manytomany.Requests.ProductCreateRequest;
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
@RequestMapping("/products")
public class ProductController {
    private final SomeService service;

    @PostMapping("/create")
    public IdResponse createProduct(@RequestBody ProductCreateRequest productCreateRequest) {
        return service.createProduct(productCreateRequest);
    }
    @PostMapping("/associate_by")
    public SimpleResponse associateProduct(@RequestBody ProductAssociateRequest productAssociateRequest) {
        return service.associateProductByShop(productAssociateRequest);
    }
}
