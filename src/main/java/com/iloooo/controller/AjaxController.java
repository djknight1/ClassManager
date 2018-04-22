package com.iloooo.controller;

import com.iloooo.bean.User;
import com.iloooo.service.impl.AdminServiceImpl;
import com.iloooo.service.impl.LoginServiceImpl;
import com.iloooo.service.impl.UploadServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

    @RequestMapping(path = "/upload")
    @ResponseBody
    public Map<String, Boolean> updateFile(HttpServletRequest request) {
        Map<String, Boolean> msg = new HashMap<String, Boolean>();
        MultipartFile file = (MultipartFile) request.getAttribute("file");
        String serverPath = request.getServletContext().getRealPath("/");
        boolean flag = updateService.updateHomework(file,
                ((User) request.getSession().getAttribute("loginUser")).getId(),
                (Long)request.getAttribute("typeId"),
                (Long)request.getAttribute("taskId"), serverPath);
        if (flag) {
            msg.put("msg", true);
        } else {
            msg.put("msg", false);
        }
        return msg;
    }


}
