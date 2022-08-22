package com.jwtproject.userSecurity.Service.Impl;



import com.jwtproject.userSecurity.Entity.Restaurant;
import com.jwtproject.userSecurity.Repository.RestaurantRepository;
import com.jwtproject.userSecurity.Service.RestaurantSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
public class RestaurantService implements RestaurantSer {

    @Autowired
    RestaurantRepository restaurantRepository;


    @Override
    @Transactional
    public Restaurant addRestaurant(Restaurant Restaurant) {
        return restaurantRepository.save(Restaurant);
    }

    @Override
    public List<Restaurant> findAllRestaurants() {
        return null;
    }


    @Override
    @Transactional
    public List<Restaurant> findAllRestaurant() {
        return restaurantRepository.findAll();    }

    @Override
    @Transactional
    public Restaurant updateRestaurant(Restaurant Restaurant) {
        return restaurantRepository.save(Restaurant);
    }

    @Override
    public Restaurant findById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public Restaurant findRestaurantById(Long id) {
        return restaurantRepository.findRestaurantById(id)
                .orElseThrow(() -> new ReservationNotFoundException("Restaurant with id " + id + " was not found"));
    }

    @Override
    @Transactional
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteRestaurantById(id);
    }

}
 class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(String message) {
        super(message);
    }
}