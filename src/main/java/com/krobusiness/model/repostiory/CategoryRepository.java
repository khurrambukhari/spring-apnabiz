package com.krobusiness.model.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krobusiness.model.entities.Category;
import com.krobusiness.model.entities.enums.CategoryNameEnum;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryNameEnum category);
}
