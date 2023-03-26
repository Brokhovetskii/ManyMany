package Controllers;

import Requests.ShopAssociateRequest;
import Responses.SimpleResponse;
import Service.SomeService;
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
    @PostMapping("/associate")
    public SimpleResponse associateShop(@RequestBody ShopAssociateRequest shopAssociateRequest) {
        return service.associateShopByProduct(shopAssociateRequest);
    }
}
