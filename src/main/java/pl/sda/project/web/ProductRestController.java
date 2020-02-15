package pl.sda.project.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.project.entity.Product;
import pl.sda.project.service.ProductService;

@RestController
public class ProductRestController {
    final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/rest/product")
    public ResponseEntity<Void> postForm(Product product) {
        productService.save(product);
        return ResponseEntity.ok().build();
    }
}
