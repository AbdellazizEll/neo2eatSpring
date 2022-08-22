package com.jwtproject.userSecurity.Controller;


import com.jwtproject.userSecurity.Entity.Plat;
import com.jwtproject.userSecurity.Service.Impl.CategoryService;
import com.jwtproject.userSecurity.Service.Impl.PlatService;
import com.jwtproject.userSecurity.enums.PlatStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/plat")
public class PlatController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    PlatService platService;

    /**
     * Show All Categories
     */

    @GetMapping("")
    public Page<Plat> findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "size", defaultValue = "3") Integer size) {
        PageRequest request = PageRequest.of(page - 1, size);
        return platService.findAll(request);
    }

    @GetMapping("/{platId}")
    public Plat showOne(@PathVariable("platId") Long platId) {

        Plat platInfo = platService.findOne(platId);

//        // Plat is not available
        if (platInfo.getPlatStatus().equals(PlatStatusEnum.DOWN.getCode())) {
           platInfo = null;
      }

        return platInfo;
    }

    @PostMapping("/seller/new")
    public ResponseEntity create(@Valid @RequestBody Plat platInfo,
                                 BindingResult bindingResult) {
        Plat platIdExists = platService.findOne(platInfo.getPlatStatus());
        if (platIdExists != null) {
            bindingResult
                    .rejectValue("productId", "error.product",
                            "There is already a product with the code provided");
        }
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult);
        }
        return ResponseEntity.ok(platService.save(platInfo));
    }

    @PutMapping("/seller/plat/{id}/edit")
    public ResponseEntity edit(@PathVariable("id") Long platId,
                               @Valid @RequestBody Plat plat,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult);
        }
        if (!platId.equals(plat.getId())) {
            return ResponseEntity.badRequest().body("Id Not Matched");
        }

        return ResponseEntity.ok(platService.update(plat));
    }

    @DeleteMapping("/seller/plat/{id}/delete")
    public ResponseEntity delete(@PathVariable("id") Long platId) {
        platService.delete(platId);
        return ResponseEntity.ok().build();
    }

}
