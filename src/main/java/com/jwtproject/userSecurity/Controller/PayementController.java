package com.jwtproject.userSecurity.Controller;


import com.jwtproject.userSecurity.Entity.Payement;
import com.jwtproject.userSecurity.Response.MessageResponse;
import com.jwtproject.userSecurity.Service.Impl.PayementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@CrossOrigin(origins ="*" , maxAge = 3600)
@RequestMapping("/payement")
public class PayementController {

    @Autowired
    private PayementService payementService;

    @GetMapping
    @ApiOperation(value="Trouver tous les Payements" , notes="find payment ")
    @ApiResponses(value = {
            @ApiResponse(code = 200 , message ="Payement trouvé")
    })
     public List<Payement> findAll(){
         return payementService.findAll();
     }


    @PostMapping()
    @ApiOperation(value="Trouver les payement" , notes="find payement")
    @ApiResponses(value = {
            @ApiResponse(code = 200  , message="Payement enregistré")
    })
     public MessageResponse save(@RequestBody  Payement payement){
         return payementService.save(payement);
     }

    @PutMapping
    @ApiOperation(value="mettre à jour un payement", notes="update payement")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message="payement mis à jour")
    })
     public MessageResponse update(@RequestBody Payement payement)
     {
         return payementService.update(payement);
     }
}
