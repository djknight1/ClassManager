package com.iloooo.controller;

import com.iloooo.service.impl.AdminServiceImpl;
import com.iloooo.service.impl.LoginServiceImpl;
import com.iloooo.service.impl.UpdateServiceImpl;
import org.apache.ibatis.annotations.Param;
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
    private LoginServiceImpl loginService;
    private UpdateServiceImpl updateService;
    private AdminServiceImpl adminService;

    public AjaxController(LoginServiceImpl loginService, UpdateServiceImpl updateService, AdminServiceImpl adminService) {
        this.loginService = loginService;
        this.updateService = updateService;
        this.adminService = adminService;
    }

    /*@Autowired*/

    //用户登陆
    @RequestMapping(path = "/check", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Boolean> loginCheck(@Param("id") long id, @Param("password") String password, HttpSession session) {
        Map<String, Boolean> msg = new HashMap<String, Boolean>();
        if (loginService.isCorrectUser(id, password)) {
            msg.put("msg", true);
            session.setAttribute("loginUser", loginService.getUserById(id));
        } else {
            msg.put("msg", false);
        }

        return msg;
    }

    //用户登陆
    @RequestMapping(path = "/adminCheck", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Boolean> adminLoginCheck(@Param("username") String username, @Param("password") String password, HttpSession session) {
        Map<String, Boolean> msg = new HashMap<String, Boolean>();
        if (adminService.isCorrectAdmin(username, password)) {
            msg.put("msg", true);
            session.setAttribute("adminUser", adminService.getAdminByUsername(username));
        } else {
            msg.put("msg", false);
        }

        return msg;
    }
}
