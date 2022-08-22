package com.jwtproject.userSecurity.Controller;


import com.jwtproject.userSecurity.Entity.Commandes;
import com.jwtproject.userSecurity.Entity.Plat;
import com.jwtproject.userSecurity.Entity.Restaurant;
import com.jwtproject.userSecurity.Response.MessageResponse;
import com.jwtproject.userSecurity.Service.Impl.CommandeService;
import com.jwtproject.userSecurity.Service.Impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("*")
@RequestMapping("/Commande")

@Component
public class CommandeController {
    @Autowired
    private CommandeService commandeService;


    @Autowired
    UserServiceImpl userService;






    @GetMapping
    @ApiOperation(value="Trouver tous les badges", notes="find badges")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message="badges trouvés")
    })

    public Page<Commandes> getAllCommandes (@RequestParam(value = "page", defaultValue = "1") Integer page,
                                            @RequestParam(value ="size", defaultValue = "10")Integer size,
                                            Authentication authentication) {

        PageRequest request = PageRequest.of(page - 1, size);
        Page<Commandes> commandePage;

        if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))){
            commandePage = commandeService.findByCustomerUsername(authentication.getName(),request);
        }else {
            commandePage = commandeService.findAll(request);
        }

        return commandePage;
    }


    @PatchMapping("/cancel/{id}")
    public ResponseEntity<Commandes> cancel(@PathVariable("id") Long orderId, Authentication authentication) {
        Commandes orderMain = commandeService.findOne(orderId);
        if (!authentication.getName().equals(orderMain.getCustomerUsername()) && authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROE_USER"))) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(commandeService.cancel(orderId));
    }

    @PostMapping
    @ApiOperation(value="Enregister une commande", notes="save commande",authorizations = {@Authorization(value="jwtToken") })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message="commande enregistré")
    })
    public MessageResponse save(@RequestBody Commandes commandes) {
        return commandeService.save(commandes);
    }


    @GetMapping("/{id}")
    public ResponseEntity show(@PathVariable("id") Long orderId, Authentication authentication) {
        boolean isCustomer = authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"));
        Commandes commandeMain = commandeService.findOne(orderId);
        if (isCustomer && !authentication.getName().equals(commandeMain.getCustomerEmail())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Collection<Plat> menu = commandeMain.getPlats();
        Restaurant restaurant = commandeMain.getRestaurant();
        return ResponseEntity.ok(commandeMain);
    }

}
