package pl.sda.project.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.sda.project.entity.ProductEntity;
import pl.sda.project.repository.ProductRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ProductEntityControllerTest {
    public static final String EXAMPLE_PRODUCT_NAME = "Suszarka";
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void givenDataIsPresentWhenListIsRequestedThenPageContainsPrdName() throws Exception {
        //given
        ProductEntity testPrd = new ProductEntity();
        testPrd.setName(EXAMPLE_PRODUCT_NAME);
        productRepository.save(testPrd);
        //when
        MvcResult mvcResult = this.mockMvc.perform(get("/product/list"))
                .andDo(print())
                .andReturn();

//then
        String content = mvcResult.getResponse().getContentAsString();

        assertThat(content).contains(EXAMPLE_PRODUCT_NAME);


               /*
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(EXAMPLE_PRODUCT_NAME)));*/
    }

}