package com.iloooo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping("")
    public String index(HttpSession session) {
        String ret;
        if (null != session.getAttribute("loginUser")) {
            ret = "submit";
        } else {
            ret = "login";
        }
        return ret;
    }

}
