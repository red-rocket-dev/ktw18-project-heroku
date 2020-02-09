package pl.sda.project.service;

import org.springframework.stereotype.Service;
import pl.sda.project.entity.Product;
import pl.sda.project.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(Product prd) {
        productRepository.save(prd);
    }

    public void saveBrandModel(String brand, String model) {
        Product product = new Product();
        product.setName(String.format("%s - %s", brand, model));
        productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No product with id"));
    }
}
