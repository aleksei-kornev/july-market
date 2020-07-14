package com.geekbrains.july.market.services;

import com.geekbrains.july.market.entities.Category;
import com.geekbrains.july.market.entities.Product;
import com.geekbrains.july.market.exceptions.CategoryNotFoundException;
import com.geekbrains.july.market.exceptions.ProductNotFoundException;
import com.geekbrains.july.market.repositories.CategoriesRepository;
import com.geekbrains.july.market.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class CategoriesService {
    private CategoriesRepository categoriesRepository;

    @Autowired
    public void setCategoriesRepository(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public Category saveOrUpdate(Category category) {
        return categoriesRepository.save(category);
    }

    public Category findById(Long id) {
        return categoriesRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Can't found category with id = " + id));
    }

    public List<Category> findAll() {
        return categoriesRepository.findAll();
    }

}
