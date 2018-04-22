package com.iloooo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("")
    public String admin(HttpSession session) {
        if (null == session.getAttribute("adminUser")) {
            return "redirect:/adminLogin";
        } else {
            return "/admin";
        }
    }
}
