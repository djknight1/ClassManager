package com.iloooo.controller;


import com.iloooo.bean.User;
import com.iloooo.service.UserManagerService;
import com.iloooo.service.impl.UserManagerServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController {

    private UserManagerServiceImpl userManagerService;

    @Autowired
    public LoginController(UserManagerServiceImpl userManagerService) {
        this.userManagerService = userManagerService;
    }

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/check", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Boolean> loginCheck(@Param("id") long id, @Param("password") String password, HttpSession session) {
        Map<String, Boolean> msg = new HashMap<String, Boolean>();
        if (userManagerService.isCorrectUser(id, password)) {
            msg.put("msg", true);
            session.setAttribute("loginUser", userManagerService.getUserById(id));
        } else {
            msg.put("msg", false);
        }

        return msg;
    }
}
