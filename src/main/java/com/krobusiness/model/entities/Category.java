package com.krobusiness.model.entities;

import javax.persistence.*;

import com.krobusiness.model.entities.enums.CategoryNameEnum;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    private CategoryNameEnum name;

    public Category(CategoryNameEnum categoryNameEnum) {
        this.name = categoryNameEnum;
    }

    public Category() {
    }

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }
}