package pl.sda.project.service;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.project.entity.Product;
import pl.sda.project.repository.ProductRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceTest {
    public static final String MY_PRODUCT_NAME = "my product";
    public static final String BRAND = "Dell";
    public static final String MODEL = "XPS";
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @After
    public void after() {
        productRepository.deleteAll();
    }

    @Test
    public void givenProductInDbThenProductCanBeRetrived() {
        //given
        Product product = new Product();
        product.setName(MY_PRODUCT_NAME);
        productRepository.save(product);
        //when
        List<Product> products = productService.findAll();
        //then
        assertThat(products).hasSize(1);
        assertThat(products.get(0).getName()).isEqualTo(MY_PRODUCT_NAME);

    }

    @Test
    public void whenSaveBrandModelThenProductIsSaved() {
        //when
        productService.saveBrandModel(BRAND, MODEL);
        //then
        List<Product> products = productRepository.findAll();

        assertThat(products).hasSize(1);
        assertThat(products.get(0).getName()).isEqualTo(BRAND + " - " + MODEL);
    }
}