package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("title", "首页");
        model.addAttribute("content", "这是一个SpringSecurity入门例子！");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin/admin")
    public String admin(Model model) {
        model.addAttribute("title", "管理员页");
        return "admin/admin";
    }

    @GetMapping("/user/user")
    public String user(Model model) {
        model.addAttribute("title", "用户页");
        return "user/user";
    }
}
