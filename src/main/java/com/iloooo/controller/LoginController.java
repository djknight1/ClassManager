package com.iloooo.controller;


import com.iloooo.entity.User;
import com.iloooo.service.impl.LoginServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController {

    @RequestMapping("/")
    public String login(HttpSession session) {
        if (null==session.getAttribute("loginUser")){
            return "login";
        } else{
            return "redirect:/upload";
        }
    }

    @RequestMapping("/password")
    public String password() {
        return "password";
    }

    @RequestMapping("/loginAdmin")
    public String loginAdmin(HttpSession session) {
        if (null==session.getAttribute("adminUser")){
            return "login-admin";
        } else{
            return "redirect:/admin";
        }
    }

    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        if (null != user) {
            session.removeAttribute("loginUser");
        }
        return "redirect:/";
    }


}
