package lessonPack.controllers;

import lessonPack.services.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    ProductServiceImpl productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("message", "hello");

        return "index";
    }
}
