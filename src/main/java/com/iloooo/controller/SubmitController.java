package com.iloooo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/submit")
public class SubmitController {

    @RequestMapping("")
    public String submit() {
        return "submit";
    }
}
