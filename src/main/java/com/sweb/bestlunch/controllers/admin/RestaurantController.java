package com.sweb.bestlunch.controllers.admin;

import com.sweb.bestlunch.daos.RestaurantRepository;
import com.sweb.bestlunch.entities.Restaurant;
import com.sweb.bestlunch.services.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
    private static List<Restaurant> restaurants = new ArrayList<>();

    private String errorMessage = "Заполните все поля";
    private IRestaurantService service;
    private RestaurantRepository repository;

    @Autowired
    public RestaurantController(IRestaurantService restaurantService, RestaurantRepository repository){
        restaurants =  repository.findAll();
    }

    @GetMapping("/")
    public ModelAndView getRestaurants(){
        Map<String,List<Restaurant>> model = new HashMap<>();
        model.put("restaurants", restaurants);
        return new ModelAndView("restaurants",model);
    }

    @GetMapping("/add")
    public String showAddRestaurantPage(Model model){
        Restaurant restaurant = new Restaurant();
        model.addAttribute("restaurants",restaurant);
        return "restaurantForm";
    }

    @PostMapping("/")
    public String saveOrUpdateRestaurant(Model model, //
        @ModelAttribute("restaurant") Restaurant restaurant){
        Long id = restaurant.getId();
        String name = restaurant.getName();
        String email = restaurant.getEmail();
        String phoneNumber = restaurant.getPhoneNumber();

        if (name != null && name.length()>0
                && email != null && email.length()>0
                && phoneNumber != null && phoneNumber.length()>0) {
            repository.save(restaurant);
        }
        model.addAttribute("errorMessage",errorMessage);
        return "restaurantForm";
    }

    @GetMapping("/{id}/update")
    public String showUpdateUserForm(@PathVariable("id") Long id, Model model){
        Optional<Restaurant> restaurantOptional = repository.findById(id);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            model.addAttribute("restaurant",restaurant);
            return "restaurantForm";
        }
        return "error";
    }
}
