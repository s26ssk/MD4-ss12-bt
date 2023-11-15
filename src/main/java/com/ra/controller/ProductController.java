package com.ra.controller;

import com.ra.model.entity.Product;
import com.ra.model.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductService productService = new ProductService();

    @GetMapping("/list")
    public String productList(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product";
    }

    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.create(product);
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
        return "edit";
    }
    @PostMapping("/update/{productCode}")
    public String updateProduct(@PathVariable("productCode") Integer productCode, @ModelAttribute("product") Product product) {
        productService.update(product, productCode);
        return "redirect:/product/list";
    }


}
