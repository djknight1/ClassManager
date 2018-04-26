package com.iloooo.controller;

import com.iloooo.entity.Type;
import com.iloooo.entity.User;
import com.iloooo.service.UserService;
import com.iloooo.service.impl.TypeServiceImpl;
import com.iloooo.service.impl.UploadServiceImpl;
import com.iloooo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/upload")
public class UploadController {
    private TypeServiceImpl typeService;
    private UploadServiceImpl uploadService;
    private UserServiceImpl userService;

    @Autowired
    public UploadController(UploadServiceImpl uploadService, UserServiceImpl userService, TypeServiceImpl typeService) {
        this.typeService = typeService;
        this.uploadService = uploadService;
        this.userService = userService;
    }

    @RequestMapping("")
    public String submit(HttpServletRequest request, HttpSession session, Model model) {
        List<Type> types = typeService.getTypeAll();
        if (null == (User) session.getAttribute("loginUser")) {
            return "redirect:/";
        } else {
            return "upload";
        }
    }

//    @RequestMapping("/test")
////    public String test() {
////        return "test";
////    }
////
////    @RequestMapping("/testAjax")
////    @ResponseBody
////    public Map<String, Object> testAjax() {
////        Map<String, Object> map = new HashMap<>();
////        map.put("user", userService.getUserAll());
////        map.put("type", uploadService.getTypeAll());
////        return map;
////    }
}
