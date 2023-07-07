package com.example.pp312.controller;

import com.example.pp312.model.User;
import com.example.pp312.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getAllUsers(Model model) {
        model.addAttribute("users",userService.getAllUsers());
        return "users";
    }
   @GetMapping("/new")
   public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
       return "add";
   }
    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user",userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/edit")
    public String update(User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
}
