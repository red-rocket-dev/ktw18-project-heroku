package pl.sda.project.service;

import org.springframework.stereotype.Service;
import pl.sda.project.entity.ProductEntity;
import pl.sda.project.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(ProductEntity prd) {
        productRepository.save(prd);
    }

    public void saveBrandModel(String brand, String model) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(String.format("%s - %s", brand, model));
        productRepository.save(productEntity);
    }

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    public ProductEntity findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No product with id"));
    }
}
