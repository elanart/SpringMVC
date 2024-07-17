package com.tll.controllers;

import com.tll.services.CategoryService;
import com.tll.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String home(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("cates", this.categoryService.getCategories());
        model.addAttribute("products", this.productService.getProducts(params));

        return "home";
    }
}
