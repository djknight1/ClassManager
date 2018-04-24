package com.iloooo.controller;

import com.iloooo.entity.Type;
import com.iloooo.entity.User;
import com.iloooo.service.impl.UploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/upload")
public class UploadController {

    UploadServiceImpl uploadService;

    @Autowired
    public UploadController(UploadServiceImpl uploadService) {
        this.uploadService = uploadService;
    }

    @RequestMapping("")
    public String submit(HttpServletRequest request, HttpSession session, Model model) {
        List<Type> types = uploadService.getTypeAll();
        if (null == (User) session.getAttribute("loginUser")) {
            return "redirect:/";
        } else {
            model.addAttribute("types", types);
            return "upload";
        }
    }
}
