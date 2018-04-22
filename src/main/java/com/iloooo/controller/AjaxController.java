package com.iloooo.controller;

import com.iloooo.service.AdminService;
import com.iloooo.service.UpdateService;
import com.iloooo.service.impl.AdminServiceImpl;
import com.iloooo.service.impl.LoginServiceImpl;
import com.iloooo.service.impl.UpdateServiceImpl;
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
@RequestMapping("/ajax")
public class AjaxController {
    private LoginServiceImpl userManagerService;
    private UpdateServiceImpl updateService;
    private AdminServiceImpl adminService;

    @Autowired
    public AjaxController(LoginServiceImpl userManagerService, UpdateServiceImpl updateService, AdminServiceImpl adminService) {
        this.userManagerService = userManagerService;
        this.updateService = updateService;
        this.adminService = adminService;
    }



    //用户登陆
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
