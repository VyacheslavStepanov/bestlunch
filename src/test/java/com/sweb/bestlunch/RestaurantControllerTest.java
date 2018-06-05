package com.sweb.bestlunch;


import com.sweb.bestlunch.controllers.admin.RestaurantController;
import com.sweb.bestlunch.daos.RestaurantRepository;
import com.sweb.bestlunch.entities.Restaurant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestaurantRepository repository;

    @Test
    public void shouldReturnRestaurantListPage() throws Exception {
        when(repository.findAll()).thenReturn(Collections.singletonList(new Restaurant("Arena","email@test.ru","886643332343")));
        this.mockMvc.perform(get("/restaurants/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Restaurants"))).andExpect(content().string(containsString("Arena")));
    }

    @Test
    public void shouldReturnAddPage() throws Exception {
        this.mockMvc.perform(get("/restaurants/add")).andDo(print()).andExpect(status().isOk())
            .andExpect(content().string(containsString("Create a Restaurant")));
    }

    @Test
    public void shouldReturnEditPage() throws Exception {
        when(repository.findById(1L)).thenReturn(Optional.of(new Restaurant("Arena","sweb@test.ru","960434222222")));
        this.mockMvc.perform(get("/restaurants/1/edit")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Restaurant Edit Form")));
    }

    public void shouldNotReturnEditPage() throws Exception {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        this.mockMvc.perform(get("/restaurants/edit")).andExpect(redirectedUrl("/restaurants/")).andExpect(status().isOk());
    }
    //TODO test post requests

}
