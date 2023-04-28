package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.entity.Admin;
import com.atguigu.entity.Permission;
import com.atguigu.service.AdminService;
import com.atguigu.service.PermissionService;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.List;

@Controller
public class IndexController {
//    @RequestMapping("/")
//    public String index() {
//        System.out.println("index");
//        return "frame/index";
//    }

    @Reference
    private AdminService adminService;
    @Reference
    private PermissionService permissionService;

    @RequestMapping("/")
    public String index(Map map) {

        Long userId = 1L;
//        Admin admin = adminService.getById(userId);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Admin admin = adminService.getByUsername(user.getUsername());
        List<Permission> permissionList = permissionService.getMenuPerListByAdminId(admin.getId());
        map.put("admin", admin);
        map.put("permissionList", permissionList);

        return "frame/index";
    }

    @RequestMapping("/main")
    public String Main() {
        return "frame/main";
    }

    @RequestMapping("/login")
    public String Login() {
        return "frame/login";
    }

    @RequestMapping("/logout")
    public String Logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/auth")
    public String auth() {
        return "frame/auth";
    }
}
