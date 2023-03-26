package Service;

import DBmodels.Product;
import DBmodels.Shop;
import Repository.ProductRepository;
import Repository.ShopRepository;
import Requests.ProductAssociateRequest;
import Responses.SimpleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class SomeService {

    private ProductRepository productRepository;
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


}
