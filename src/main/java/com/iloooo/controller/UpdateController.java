package com.iloooo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/update")
public class UpdateController {

    @RequestMapping("")
    public String submit() {
        return "update";
    }
}
