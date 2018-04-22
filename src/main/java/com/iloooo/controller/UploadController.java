package com.iloooo.controller;

import com.iloooo.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping("")
    public String submit(HttpServletRequest request, HttpSession session) {
        if (null == (User) session.getAttribute("loginUser")) {
            return "redirect:/";
        } else {
            return "upload";
        }
    }
}
