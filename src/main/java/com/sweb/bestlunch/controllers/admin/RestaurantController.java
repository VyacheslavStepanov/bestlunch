package com.sweb.bestlunch.controllers.admin;

import com.sweb.bestlunch.daos.RestaurantRepository;
import com.sweb.bestlunch.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
    private String errorMessage = "Заполните все поля";
    private RestaurantRepository repository;

    @Autowired
    public RestaurantController(RestaurantRepository repository){
        this.repository = repository;
    }

    @GetMapping(value={"","/"})
    public ModelAndView getRestaurants(){
        List<Restaurant> restaurants = repository.findAll();
        Map<String,List<Restaurant>> model = new HashMap<>();
        model.put("restaurants", restaurants);
        return new ModelAndView("restaurants",model);
    }

    @GetMapping("/add")
    public String showAddRestaurantForm(Model model){
        Restaurant restaurant = new Restaurant();
        model.addAttribute("restaurant",restaurant);
        return "restaurantAddForm";
    }

    @PostMapping("/")
    public String addOrUpdateRestaurant(Model model, //
        @ModelAttribute("restaurant") Restaurant restaurant){
        Long id = restaurant.getId();
        String name = restaurant.getName();
        String email = restaurant.getEmail();
        String phoneNumber = restaurant.getPhoneNumber();

        if (name != null && name.length()>0
                && email != null && email.length()>0
                && phoneNumber != null && phoneNumber.length()>0) {
            try {
                repository.save(restaurant);
            } catch (Exception e){
                //TODO implement exception processing
            }
        } else {
            String errorMessage = "Fill all fields";
            model.addAttribute("errorMessage",errorMessage);
            return "restaurantAddForm";
        }
        return "redirect:/restaurants/";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateUserForm(@PathVariable("id") Long id, Model model){
        Optional<Restaurant> restaurantOptional = repository.findById(id);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            model.addAttribute("restaurant",restaurant);
            return "restaurantEditForm";
        } else {
            //TODO show popup
            errorMessage = String.format("Restaurant with id %s not found", id);
            return "redirect:/restaurants/";
        }
    }

    @GetMapping("/{id}/delete")
    public String deleteRestaurant(@PathVariable("id") Long id){
        Optional<Restaurant> restaurantOptional = repository.findById(id);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            repository.delete(restaurant);
        }
        return "redirect:/restaurants/";
    }
}
