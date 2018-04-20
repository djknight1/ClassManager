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
@RequestMapping("/login")
public class LoginController {

    private UserManagerServiceImpl userManagerService;

    @Autowired
    public LoginController(UserManagerServiceImpl userManagerService) {
        this.userManagerService = userManagerService;
    }

    @RequestMapping("")
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/register/username", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Boolean> username(@Param("id") long id) {
        Map<String, Boolean> result = new HashMap<>();
        if (userManagerService.isUsernameEmpty(id)) {
            result.put("msg", true);
        } else {
            result.put("msg", false);
        }
        return result;
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/register/result")
    @ResponseBody
    public Map<String,Object> registerResult(HttpServletRequest request) {

        Map<String, Object> result = new HashMap<>();
        HttpSession session = request.getSession();
        User user = new User();
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("nickname"));
        userManagerService.createUser(user);
        if (null == session.getAttribute("loginUser")) {
            session.setAttribute("loginUser", user);
            session.setMaxInactiveInterval(60 * 30);
        }
        result.put("msg", "注册成功");
        return result;
    }

    @RequestMapping(path = "/check", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Boolean> loginCheck(@Param("username") String username, @Param("password") String password, HttpSession session) {
        Map<String, Boolean> msg = new HashMap<String, Boolean>();
        if (userManagerService.isCorrectUser(username, password)) {
            msg.put("msg", true);
            session.setAttribute("loginUser", userManagerService.getUserByUsername(username));
        } else {
            msg.put("msg", false);
        }

        return msg;
    }
}
