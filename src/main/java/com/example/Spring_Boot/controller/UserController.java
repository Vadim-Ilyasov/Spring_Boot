package com.example.Spring_Boot.controller;

import com.example.Spring_Boot.model.User;
import com.example.Spring_Boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String showUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("users", user);
        return "new-user";
    }

    @PostMapping("/")
    public String addUser(@ModelAttribute("users")  User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("users", userService.getUserById(id));
        return "show_user";
    }

    @GetMapping("/{id}/replacement")
    public String replacement(Model model, @PathVariable("id") Long id) {
        model.addAttribute("users", userService.getUserById(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("users") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/update";
        }
        userService.updateUser( user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/";

    }

}
