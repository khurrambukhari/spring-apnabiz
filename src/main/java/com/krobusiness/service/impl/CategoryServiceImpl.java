package com.krobusiness.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krobusiness.handler.NotFoundException;
import com.krobusiness.model.entities.Category;
import com.krobusiness.model.entities.enums.CategoryNameEnum;
import com.krobusiness.model.repostiory.CategoryRepository;
import com.krobusiness.service.CategoryService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findByName(CategoryNameEnum category) {
        Optional<Category> byName = this.categoryRepository.findByName(category);

        if (byName.isPresent()) {
            return byName.get();
        } else {
            throw new NotFoundException("Category with this name not found");
        }
    }

    @Override
    public List<Category> initCategories() {
        List<Category> init = new ArrayList<>();
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values()).forEach(categoryNameEnum -> {
                Category category = new Category(categoryNameEnum);
                this.categoryRepository.save(category);
                init.add(category);
            });
        }
        return init;
    }
}
