package com.iloooo.controller;

import com.iloooo.bean.User;
import com.iloooo.service.impl.AdminServiceImpl;
import com.iloooo.service.impl.LoginServiceImpl;
import com.iloooo.service.impl.UploadServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
    private LoginServiceImpl loginService;
    private UploadServiceImpl updateService;
    private AdminServiceImpl adminService;

    public AjaxController(LoginServiceImpl loginService, UploadServiceImpl updateService, AdminServiceImpl adminService) {
        this.loginService = loginService;
        this.updateService = updateService;
        this.adminService = adminService;
    }

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

    //管理员登陆
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

    @RequestMapping(path = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateFile(@RequestParam(value = "file", required = true) MultipartFile file, MultipartHttpServletRequest request) {
        Map<String, Object> msg = new HashMap<String, Object>();
        System.out.println("-------");
        //MultipartFile file = (MultipartFile) request.getAttribute("file");
        System.out.println(file.getName());
        String serverPath = request.getServletContext().getRealPath("/");
        boolean flag = updateService.updateHomework(file,
                ((User) request.getSession().getAttribute("loginUser")).getId(),1,1,serverPath);
                //(Long)request.getAttribute("typeId"),
                //(Long)request.getAttribute("taskId"), serverPath);
        if (flag) {
            msg.put("code", 1);
            msg.put("msg", "请求成功");
            msg.put("data", null);
        } else {
            msg.put("code", 0);
            msg.put("msg", "请求失败");
            msg.put("data", null);
        }
        return msg;
    }

    @RequestMapping(path = "/download", method = RequestMethod.POST)
    @ResponseBody
    public void downloadFile() {

    }

    @RequestMapping("/test")
    public Map<String, Object> test(MultipartFile file) {
//  /ajax/test    HtttpServletRequest request
//      System.out.println(((File)request.getAttribute("file")).getName());
        System.out.println(file.getName());

        Map map = new HashMap<String, Object>();
        map.put("msg", 1);
        return map;
    }
}
