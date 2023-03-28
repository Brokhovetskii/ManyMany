package com.example.manytomany.Controllers;

import com.example.manytomany.DTO.ProductDTO;
import com.example.manytomany.MapDTO.ProductMap;
import com.example.manytomany.Requests.ProductAssociateRequest;
import com.example.manytomany.Requests.ProductCreateRequest;
import com.example.manytomany.Responses.GetProductResponse;
import com.example.manytomany.Responses.IdResponse;
import com.example.manytomany.Responses.SimpleResponse;
import com.example.manytomany.Service.SomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/get_product/{id}")
    public GetProductResponse getProductById(@PathVariable(name = "id") Long id) {
        return service.getProductById(id);
    }
    @GetMapping("/search")
    public List<GetProductResponse> getProductsByTitle(@RequestParam("title") String title) {
        return service.getProductsByTitle(title);
    }
    @GetMapping("/search_map")
    public List<ProductMap> getMappedShops (@RequestParam("title") String title) {
        return service.getMappedShops(title);
    }
}
