package com.jwtproject.userSecurity.Controller;

import com.jwtproject.userSecurity.Entity.Restaurant;

import com.jwtproject.userSecurity.Service.Impl.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
public class RestaurantContorller {
    @Autowired
    RestaurantService service;

    public RestaurantContorller(RestaurantService service) {
        this.service = service;
    }
    @GetMapping("/Restaurant/all")
    public List<Restaurant> getAllRestaurant () {
        List<Restaurant> restaurants = service.findAllRestaurant();
        return restaurants;
    }

    @GetMapping("/Restaurant/find/{id}")
    public Restaurant getRestaurantById (@PathVariable("id") Long id) {
        Restaurant Restaurant = service.findRestaurantById(id);
        return Restaurant;
    }

    @PostMapping("/Restaurant/add")
    public Restaurant addRestaurant(@RequestBody Restaurant Restaurant) {
        return service.addRestaurant(Restaurant);

    }

    @PutMapping("/Restaurant/update")
    public Restaurant updateRestaurant(@RequestBody Restaurant Restaurant) {
        return service.updateRestaurant(Restaurant);

    }

    @DeleteMapping("/Restaurant/delete/{id}")
    public void deleteRestaurant(@PathVariable("id") Long id) {
        service.deleteRestaurant(id);
    }
}
