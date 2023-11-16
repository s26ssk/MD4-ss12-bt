package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.service.CategoryServiceImp;
import com.ra.model.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductServiceImp productService;
    @Autowired
    private CategoryServiceImp categoryService;

    @GetMapping("/list")
    public String productList(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product";
    }

    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "product-create";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.create(product);
        System.out.println(product.getCategory().getCategoryId());
        return "redirect:/product/list";
    }
    @GetMapping("/delete/{productCode}")
    public String deleteProduct(@PathVariable("productCode") Integer productCode) {
        productService.delete(productCode);
        return "redirect:/product/list";
    }
    @GetMapping("/edit/{productCode}")
    public String editProduct(@PathVariable("productCode") Integer productCode, Model model) {
        Product product = productService.findId(productCode);
        model.addAttribute("product", product);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "product-edit";
    }
    @PostMapping("/update/{productCode}")
    public String updateProduct(@PathVariable("productCode") Integer productCode, @ModelAttribute("product") Product product) {
        productService.update(product, productCode);
        return "redirect:/product/list";
    }
}
