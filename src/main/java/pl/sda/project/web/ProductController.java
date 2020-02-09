package pl.sda.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.project.entity.Product;
import pl.sda.project.repository.ProductRepository;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

/*    @PostMapping
    public String saveProduct(@RequestParam("name") String name) {
        Product prd = new Product();
        prd.setName(name);
        productRepository.save(prd);
        System.out.println("Nowy produkt id: " + prd.getId());
        return "somepage";
    }*/

/*    @GetMapping
    public String getProduct(@RequestParam("id") Long id) {
        productRepository.findById(id)
                .ifPresent(prd -> System.out.println(prd.getName()));
        return "somepage";
    }*/

    @GetMapping("/list")
    public ModelAndView getProducts() {
        Map<String, Object> model = new HashMap<>();
        model.put("products", productRepository.findAll());
        return new ModelAndView("products", model);
    }

    @PostMapping("/save")
    public ModelAndView postSaveProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        Map<String, Object> model = new HashMap<>();
        model.put("created", product);
        return new ModelAndView("productCreated", model);
    }

    @GetMapping("/save")
    public ModelAndView getSaveProduct() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productform");
        modelAndView.getModel().put("product", new Product());

        return modelAndView;
    }
}
