package com.sweb.bestlunch;

import com.sweb.bestlunch.controllers.ProductCategoryController;
import com.sweb.bestlunch.daos.ProductCategoryRepository;
import com.sweb.bestlunch.entities.product.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductCategoryController.class)
public class ProductCategoryControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductCategoryRepository repository;

    @Test
    public void shouldReturnProductCategoryList() throws Exception {
        when(repository.findAll()).thenReturn(Collections.singletonList(new ProductCategory("Drinks")));
        this.mockMvc.perform(get("/productCategories/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Product categories"))).andExpect(content().string(containsString("Drinks")));
    }

    @Test
    public void shouldReturnAddForm() throws Exception {
       this.mockMvc.perform(get("/productCategories/add")).andDo(print()).andExpect(status().isOk())
               .andExpect(content().string(containsString("Product Category Form")));
    }
    //TODO test post requests
}
