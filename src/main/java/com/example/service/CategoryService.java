
package com.example.service;

import com.example.model.Category;
import com.example.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(int id) {
        return categoryRepository.findById(id);
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public void update(Category category) {
        categoryRepository.update(category);
    }

    public void delete(int id) {
        categoryRepository.delete(id);
    }
}
