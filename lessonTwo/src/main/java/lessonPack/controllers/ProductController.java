package lessonPack.controllers;

import lessonPack.InitData;
import lessonPack.domain.Product;
import lessonPack.repository.ProductJpaDAO;
import lessonPack.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductServiceImpl productServiceImpl;

    public void setProductServiceImpl(ProductServiceImpl productServiceImpl){
        this.productServiceImpl = productServiceImpl;
    }

    /**
     * Метод предоставления списка всех Products.
     * @param model Модель(интерфейс Spring)
     * @return list - имя отображения
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String list(Model model){

        List<Product> products = this.productServiceImpl.getAll();
        model.addAttribute("products", products);
        return "list";
    }

    @RequestMapping(value = "/listMin", method = RequestMethod.GET)
    public String listMin(Model model){
        List<Product> products = this.productServiceImpl.sortByMinAll();
        model.addAttribute("products", products);
        return "list";
    }


    /**
     * Предоставляет Product по id. Если же такого товара нет - создаёт новый.
     * @param model модель Spring
     * @param id id номер Product
     * @return имя отображения (product).
     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public String getById(Model model, @PathVariable("id") Long id){
//        Product product = this.productService.getById(id);
//        model.addAttribute("product", product == null ? new Product() : product);
//        return "product";
//    }

    /**
     * Метод обрабатывает все запросы с данного адреса.
     * Метод добавления ногового продукта
//     * @param model  модель
     * @return new-product
     */
//    @GetMapping("/new")
//    public String getFormNewProduct(Model model){
//        model.addAttribute("product", new Product());
//        return "new-product";
//    }
//
//    /**
//     * Метод Post для добавления нового продукта через сервис в репозиторий.
//     * @param product новый продукт
//     * @return перенаправляет на другой метод отображения продукта по id, с добавлением нового продукта.
//     */
//    @RequestMapping(value = "/new", method = RequestMethod.POST)
//    public String addNewProduct(Product product){
//        return "redirect:/products/" + this.productService.save(product).getId();
//    }



}
