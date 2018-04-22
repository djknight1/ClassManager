package com.iloooo.controller;

import com.iloooo.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/update")
public class UpdateController {

    @RequestMapping("")
    public String submit(HttpSession session) {
        if (null == (User) session.getAttribute("loginUser")) {
            return "redirect:/";
        } else {

            return "update";
        }
    }
}
