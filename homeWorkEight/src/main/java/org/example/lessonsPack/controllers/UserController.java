package org.example.lessonsPack.controllers;

import org.example.lessonsPack.dao.ClientDao;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final ClientDao clientDao;

    public UserController(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/users-list")
    public String usersListGet(Model model){
        model.addAttribute("usersList", clientDao.findAll());
        return "users-list";
    }

}
