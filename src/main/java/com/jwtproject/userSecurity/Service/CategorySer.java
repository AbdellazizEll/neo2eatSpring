package com.jwtproject.userSecurity.Service;



import com.jwtproject.userSecurity.Entity.Category;

import java.util.List;

public interface CategorySer {
    public Category addCategory(Category category);
    public List<Category> findAllCategories();
    public Category updateCategory(Category category);
    public Category findCategoryById(Long id);

    public Category findByCategoryType(String categoryType);

    public void deleteCategory(Long id);
}
