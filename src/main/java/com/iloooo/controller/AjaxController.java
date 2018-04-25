package com.iloooo.controller;

import com.iloooo.entity.Class;
import com.iloooo.entity.Homework;
import com.iloooo.entity.Task;
import com.iloooo.entity.Type;
import com.iloooo.entity.User;
import com.iloooo.service.ClassService;
import com.iloooo.service.impl.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
    private LoginServiceImpl loginService;
    private UploadServiceImpl uploadService;
    private AdminServiceImpl adminService;
    private TypeServiceImpl typeService;
    private HomeworkServiceImpl homeworkService;
    private ClassServiceImpl classService;

    @Autowired
    public AjaxController(LoginServiceImpl loginService, UploadServiceImpl uploadService, AdminServiceImpl adminService, TypeServiceImpl typeService, HomeworkServiceImpl homeworkService, ClassServiceImpl classService) {
        this.loginService = loginService;
        this.uploadService = uploadService;
        this.adminService = adminService;
        this.typeService = typeService;
        this.homeworkService = homeworkService;
        this.classService = classService;
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

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateFile(@RequestParam(value = "file", required = true) MultipartFile file,
                                          @RequestParam(value = "params", required = false) String params,
                                          MultipartHttpServletRequest request) {
        Map<String, Object> msg = new HashMap<String, Object>();
        long typeId = Long.valueOf(params);
        Task task = uploadService.getTaskByTypeId(typeId);
        String serverPath = request.getServletContext().getRealPath("/");
        boolean flag = uploadService.updateHomework(file,
                ((User) request.getSession().getAttribute("loginUser")).getId(), typeId, task.getId(), serverPath);
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

    @RequestMapping("/password")
    @ResponseBody
    public Map<String, Object> password(@RequestParam("id") Long id, @RequestParam(value = "oldpassword", required = false) String oldPassword, @RequestParam(value = "newpassword", required = false) String newPassword) {
        Map<String, Object> map = new HashMap<>();
        User user = loginService.getUserById(id);
        if (null != user && user.getPassword().equals(oldPassword)) {
            user.setPassword(newPassword);
            loginService.updateUser(user);
            map.put("msg", true);
        } else {
            map.put("msg", false);
        }
        return map;
    }

    @RequestMapping(path = "/upload/data", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uploadData(HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        User user = (User) session.getAttribute("loginUser");
        List<Type> types = typeService.getTypeAll();
        List<Task> tasks = uploadService.getTaskNow();
        Class userClass = classService.getClassById(user.getClassId());
        List<Homework> homeworks = homeworkService.getHomeworkListByUserId(user.getId());
        user.setPassword(null);
        map.put("user", user);
        map.put("userClass",userClass);
        map.put("types", types);
        map.put("tasks", tasks);
        map.put("homeworks", homeworks);
        return map;
    }

}
