package org.example.lessonsPack.controllers;

import org.example.lessonsPack.domain.Product;
import org.example.lessonsPack.services.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/products")
public class MainController {

    private final ProductServiceImpl productService;
    private Product finderProduct;

    public MainController(ProductServiceImpl productService) {
        this.productService = productService;
        this.finderProduct = null;
    }

    //Возвращаем лист продуктов
    @RequestMapping(value = "/list")
    public String getAllProducts(Model model){
        model.addAttribute("productsList", productService.getAll());
        return "list";
    }

    //Метод для формы создания продукта
    @GetMapping("/new")
    public String getFormNewProduct(Model model){
        model.addAttribute("product", new Product());
        return "new_product_form";
    }

    //Метод сохранения продукта с последующей адресацией к листу продуктов
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addNewProduct(Product product){
        productService.save(product);
        return "redirect:/products/list";
    }

    //метод для поиска продукта по названию
    @GetMapping("/finder-product-by-title")
    public String finderProductByTitleFormGet(Model model){
        model.addAttribute("product", new Product());
        return "user_find_product_by_title";
    }

    //метод для поиска продукта по названию с последующей адресацией на форму с изменениями
    @PostMapping(value = "/finder-product-by-title")
    public String finderProductByTitleFormPost(Product product, Model model){
        System.out.println("здесь что-то делаем с продуктом " + product.getTitle());
        finderProduct = productService.getProductByTitle(product.getTitle());
        System.out.println("Здесь по идее перенаправляем на страницу редактирования");
        return "redirect:/products/form-edit-product";
    }

    @GetMapping("/form-edit-product")
    public String editFormProductGet(Model model){
        model.addAttribute("product", new Product());
        if (finderProduct == null){
            finderProduct = new Product();
        }
        model.addAttribute("finderProduct", finderProduct);
        return "form-edit-product";
    }

    @PostMapping("/form-edit-product")
    public String editFormProductPost(Product product){
        productService.update(finderProduct, product);
        finderProduct = null;
        return "redirect:/products/list";
    }

}
