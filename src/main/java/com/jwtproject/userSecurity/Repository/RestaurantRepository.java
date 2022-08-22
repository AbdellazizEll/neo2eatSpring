package com.jwtproject.userSecurity.Repository;

import com.jwtproject.userSecurity.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin("*")
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findRestaurantById(long id);

    void deleteRestaurantById(Long id);



}
