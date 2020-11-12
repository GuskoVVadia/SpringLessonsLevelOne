package org.example.lessonFive.controller;

import org.example.lessonFive.domain.Product;
import org.example.lessonFive.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productServiceEmpl;

    public ProductController(ProductServiceImpl productServiceEmpl) {
        this.productServiceEmpl = productServiceEmpl;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("productsList", productServiceEmpl.getAll());
        return "list";
    }

    @GetMapping("/new")
    public String getFormNewProduct(Model model){
        model.addAttribute("product", new Product());
        return "new_product_form";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addNewProduct(Product product){
        productServiceEmpl.save(product);
        return "redirect:/products";
    }

    @GetMapping("/filter")
    public String filterByCost(Model model){
        return "filter";
    }

    @PostMapping(params = {"max", "min"})
    public String productsByPrice(Model model,
                                  @RequestParam(name="max") Double priceFrom,
                                  @RequestParam(name="min") Double priceTo){
        List<Product> products = productServiceEmpl.getByPrice(priceFrom, priceTo);
        model.addAttribute("productsList", products);
        return "list";
    }



}
