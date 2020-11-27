package org.example.lessonsPack.controllers;

import org.example.lessonsPack.domain.Product;
import org.example.lessonsPack.services.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private final ProductServiceImpl productService;

    public MainController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/products")
    public String getAllProducts(Model model){
        model.addAttribute("productsList", productService.getAll());
        return "list";
    }

    @GetMapping("/products/new")
    public String getFormNewProduct(Model model){
        model.addAttribute("product", new Product());
        return "new_product_form";
    }

    @RequestMapping(value = "/products/new", method = RequestMethod.POST)
    public String addNewProduct(Product product){
        productService.save(product);
        return "redirect:/products";
    }

}
