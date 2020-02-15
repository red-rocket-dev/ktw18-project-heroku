package pl.sda.project.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.project.entity.ProductEntity;
import pl.sda.project.service.ProductService;

@RestController
public class ProductRestController {
    final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/rest/product")
    public ResponseEntity<Void> postForm(ProductEntity productEntity) {
        productService.save(productEntity);
        return ResponseEntity.ok().build();
    }
}
