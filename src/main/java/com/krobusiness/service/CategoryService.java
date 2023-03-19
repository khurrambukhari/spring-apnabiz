package com.krobusiness.service;

import java.util.List;

import com.krobusiness.model.entities.Category;
import com.krobusiness.model.entities.enums.CategoryNameEnum;

public interface CategoryService {
    Category findByName(CategoryNameEnum category);

    List<Category> initCategories();
}
