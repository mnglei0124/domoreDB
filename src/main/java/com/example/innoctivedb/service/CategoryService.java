package com.example.innoctivedb.service;

import com.example.innoctivedb.model.Category;
import com.example.innoctivedb.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> updateCategory(Long id, Category updatedCategory) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setName(updatedCategory.getName());
            categoryRepository.save(category);
            return Optional.of(category);
        } else  {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
