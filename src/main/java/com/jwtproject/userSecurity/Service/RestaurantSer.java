package com.jwtproject.userSecurity.Service;
import com.jwtproject.userSecurity.Entity.Restaurant;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RestaurantSer {

    public Restaurant addRestaurant(Restaurant restau);
    public List<Restaurant> findAllRestaurants();


    @Transactional
    List<Restaurant> findAllRestaurant();

    public Restaurant updateRestaurant(Restaurant restau);
    public Restaurant findById(Long id);

    @Transactional
    Restaurant findRestaurantById(Long id);

    public void deleteRestaurant(Long id);
}
