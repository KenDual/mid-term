
package com.example.controller;


import com.example.model.Category;
import com.example.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // Hiển thị danh sách
    @GetMapping
    public String listCategory(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "view";
    }

    // Hiển thị form thêm mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "list-form-category";
    }

    // Hiển thị form cập nhật
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "list-form-category";
    }

    // Xử lý cập nhật
    @PostMapping("/edit")
    public String updateCategory(@ModelAttribute Category category) {
        categoryService.update(category);
        return "redirect:/categories";
    }
    
    @PostMapping("/save")
    public String saveCategory(@ModelAttribute Category category) {
        if (category.getId() == 0 || category.getId() <0){
            categoryService.save(category);
        } else {
            categoryService.update(category);
        }
        return "redirect:/categories";
    }

    // Xử lý xóa
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id) {
        categoryService.delete(id);
        return "redirect:/categories";
    }
}
