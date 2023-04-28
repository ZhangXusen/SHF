package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.entity.Admin;
import com.atguigu.service.AdminService;
import com.atguigu.service.HouseImageService;
import com.atguigu.service.RoleService;
import com.atguigu.util.QiniuUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
    @Reference
    private AdminService adminService;

    @Reference
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping()
    public String findPage(Map map, HttpServletRequest req) {
        Map<String, Object> filter = getFilters(req);
        map.put("filters", filter);
        PageInfo<Admin> page = adminService.findPage(filter);
        map.put("page", page);
        return "admin/index";
    }

    @GetMapping("/create")
    public String create() {
        return "admin/create";
    }

    @PostMapping("/save")
    public String insert(Admin admin, HttpServletRequest req) {
        //对admin密码加密
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminService.insert(admin);
        return "common/successPage";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        adminService.delete(id);
        return "redirect:/admin";
    }

    @RequestMapping("/edit/{id}")
    public String goEdit(@PathVariable Long id, ModelMap map) {
        Admin admin = adminService.getById(id);
        map.put("admin", admin);
        return "admin/edit";
    }

    @RequestMapping("/update")
    public String update(Admin admin) {
        adminService.update(admin);
        return "common/successPage";
    }

    @GetMapping("/uploadShow/{id}")
    public String UploadPage(Map map, @PathVariable("id") Long id) {
        map.put("id", id);
        return "admin/upload";
    }

    @PostMapping("/upload/{id}")
    public String Upload(@PathVariable("id") Long id,
                         @RequestParam("file") MultipartFile files) throws IOException {
        String fileName = UUID.randomUUID().toString();
        QiniuUtils.upload2Qiniu(files.getBytes(), fileName);
        Admin admin = adminService.getById(id);
        admin.setId(id);
        admin.setHeadUrl("http://rtnppjdqy.hn-bkt.clouddn.com/" + fileName);
        adminService.update(admin);
        return "common/successPage";
    }

    @RequestMapping("/assignShow/{id}")
    public String GoAssign(@PathVariable("id") Long id, ModelMap modelMap) {
        Map<String, Object> roleByAdminId = roleService.findRoleByAdminId(id);
        modelMap.addAllAttributes(roleByAdminId);
        modelMap.addAttribute("adminId", id);

        return "admin/assignShow";
    }

    @PostMapping("/assignRole")
    public String assignRole(Long adminId, Long[] roleIds) {
        roleService.assignRole(adminId, roleIds);
        return "common/successPage";
    }
}
