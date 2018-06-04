package com.sweb.bestlunch;

import com.sweb.bestlunch.controllers.HomeController;
import com.sweb.bestlunch.controllers.OrderController;
import com.sweb.bestlunch.controllers.ProductCategoryController;
import com.sweb.bestlunch.controllers.ProductController;
import com.sweb.bestlunch.controllers.admin.RestaurantController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
    @Autowired
    private RestaurantController restaurantController;
    @Autowired
    private HomeController homeController;
    @Autowired
    private OrderController orderController;
    @Autowired
    private ProductCategoryController productCategoryController;
    @Autowired
    ProductController productController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(restaurantController).isNotNull();
        assertThat(homeController).isNotNull();
        assertThat(orderController).isNotNull();
        assertThat(productCategoryController).isNotNull();
        assertThat(productController).isNotNull();
    }
}
