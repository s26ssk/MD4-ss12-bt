package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.service.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImp categoryService;
    @GetMapping("/list")
    public String categoryList(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);

        return "category";
    }

    @GetMapping("/create")
    public String createCategory(Model model) {
        model.addAttribute("category", new Category());
        return "category-create";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryService.create(category);
        return "redirect:/category/list";
    }
    @GetMapping("/delete/{categoryId}")
    public String deleteCategory(@PathVariable("categoryId") Integer categoryId) {
        categoryService.delete(categoryId);
        return "redirect:/category/list";
    }
    @GetMapping("/edit/{categoryId}")
    public String editCategory(@PathVariable("categoryId") Integer categoryId, Model model) {
        Category category = categoryService.findId(categoryId);
        model.addAttribute("category", category);
        return "category-edit";
    }
    @PostMapping("/update/{categoryId}")
    public String updateCategory(@PathVariable("categoryId") Integer categoryId, @ModelAttribute("category") Category category) {
        categoryService.update(category, categoryId);
        return "redirect:/category/list";
    }
}
