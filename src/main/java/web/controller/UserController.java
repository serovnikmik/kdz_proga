package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.models.User;
import web.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("list", userService.getAllUsers());
        return "user/list";
    }

    @GetMapping("/addExamples")
    public String addExamples(){
        userService.saveExampleUsers();
        return "user/examples";
    }

    @GetMapping("/deleteAllUsers")
    public String deletAllUsers(){
        userService.deleteAllUsers();
        return "user/deleteAllUsers";
    }

}