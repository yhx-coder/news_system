package com.example.controller.admin;

import com.example.pojo.Admin;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: ming
 * @date: 2021/10/26 21:09
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    @GetMapping(path = {"/", "/index", "/index.html", ""})
    public String index(HttpServletRequest request) {
        request.setAttribute("path", "index");
        return "admin/index";
    }

    @PostMapping("/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        HttpSession session) {

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            session.setAttribute("errorMsg", "用户名或密码不能为空");
            return "admin/login";
        }

        Admin admin = adminService.login(userName, password);
        if (admin != null) {
            session.setAttribute("loginUser", admin.getAdminNickName());
            session.setAttribute("loginUserId", admin.getAdminId());
            // 设置一下登录的过期时间
            session.setMaxInactiveInterval(2 * 60 * 60);
            return "redirect:/admin/index";
        } else {
            session.setAttribute("errorMsg", "登录失败，请重新登录");
            return "admin/login";
        }
    }

    @GetMapping("/profile")
    public String profile(HttpServletRequest request) {
        Long loginUserId = (Long) request.getSession().getAttribute("loginUserId");
        Admin adminUser = adminService.getUserDetailById(loginUserId);
        if (adminUser == null) {
            return "admin/login";
        }
        request.setAttribute("path", "profile");
        request.setAttribute("loginUserName", adminUser.getLoginName());
        request.setAttribute("nickName", adminUser.getAdminNickName());
        return "admin/profile";
    }

    @PostMapping("/profile/password")
    @ResponseBody
    public String passwordUpdate(@RequestParam("originalPassword") String originalPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 HttpServletRequest req){
        if (StringUtils.isEmpty(originalPassword)||StringUtils.isEmpty(newPassword)){
            return "参数不能为空";
        }
        Long userId = (Long) req.getSession().getAttribute("loginUserId");
        boolean update = adminService.updatePassword(userId, originalPassword, newPassword);
        if (update){
            req.getSession().removeAttribute("loginUserId");
            req.getSession().removeAttribute("loginUser");
            req.getSession().removeAttribute("errorMsg");
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

    @PostMapping(path = "/profile/name")
    @ResponseBody
    public String nameUpdate(@RequestParam("loginUserName") String newLoginName,
                             @RequestParam("nickName") String newNickname,
                             HttpServletRequest request){
        if (StringUtils.isEmpty(newLoginName) || StringUtils.isEmpty(newNickname)){
            return "参数不能为空！";
        }
        Long userId = (Long) request.getSession().getAttribute("loginUserId");

        if (adminService.updateName(userId,newLoginName,newNickname)) {
            request.getSession().setAttribute("loginUser",newNickname);
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("loginUserId");
        request.getSession().removeAttribute("loginUser");
        request.getSession().removeAttribute("errorMsg");
        return "redirect:/admin/login";
    }
}
