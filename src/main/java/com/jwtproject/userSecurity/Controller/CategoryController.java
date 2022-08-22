package com.jwtproject.userSecurity.Controller;


import com.jwtproject.userSecurity.Entity.Category;
import com.jwtproject.userSecurity.Service.Impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Category")

@Component
public class CategoryController {

    @Autowired
    CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }
    @GetMapping("/all")
    public List<Category> getAllCategory () {
        List<Category> Categories = service.findAllCategories();
        return Categories;
    }

    @GetMapping("/find/{id}")
    public Category getCommandeById (@PathVariable("id") Long id) {
        Category category = service.findCategoryById(id);
        return category;
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        return service.addCategory(category);

    }

    @PutMapping("/update")
    public Category updateCategory(@RequestBody Category category) {
        return service.updateCategory(category);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        service.deleteCategory(id);
    }

}
