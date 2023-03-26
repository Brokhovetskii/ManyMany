package Controllers;

import Requests.ProductAssociateRequest;
import Responses.SimpleResponse;
import Service.SomeService;
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
    @PostMapping("/associate_by")
    public SimpleResponse associateProduct(@RequestBody ProductAssociateRequest productAssociateRequest) {
        return service.associateProductByShop(productAssociateRequest);
    }
}
