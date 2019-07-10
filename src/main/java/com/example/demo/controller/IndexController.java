package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index.html")
    public String getArticleList(Model model) {
        model.addAttribute("content", "这是一个SpringSecurity入门例子！");
        return "index";
    }
}
