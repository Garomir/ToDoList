package com.ramich.ToDoList.controllers;

import com.ramich.ToDoList.entities.User;
import com.ramich.ToDoList.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/registration")
    public String registerPage(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String register(User user, BindingResult result){
        User existing = userService.findByUsername(user.getUsername());
        if (existing != null){
            result.rejectValue("username", null, "Пользователь с таким именем уже есть");
        }

        if (result.hasErrors()){
            return "registration";
        }

        userService.saveUser(user);
        return "redirect:/login";
    }
}