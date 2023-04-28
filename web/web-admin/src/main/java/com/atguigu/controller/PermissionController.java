package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.entity.Permission;
import com.atguigu.service.PermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController extends BaseController {

    @Reference
    private PermissionService permissionService;


    @RequestMapping()
    public String index(Map map) {
        List<Permission> list = permissionService.findAllMenu();
        map.put("list", list);
        return "permission/index";
    }

    @GetMapping("/create")
    public String Create(Map map, Permission permission) {
        map.put("permission", permission);
        return "permission/create";
    }

    @PostMapping("/save")
    public String Save(Permission permission) {
        permissionService.insert(permission);
        return "common/successPage";
    }

    @PostMapping(value = "/update")
    public String update(Permission permission) {
        permissionService.update(permission);
        return "common/successPage";
    }

    @GetMapping("/edit/{id}")
    public String Edit(Map map, @PathVariable("id") Long id) {
        Permission permission = permissionService.getById(id);
        map.put("permission", permission);
        return "permission/edit";
    }

    @GetMapping("/delete/{id}")
    public String Delete(Map map, @PathVariable("id") Long id) {
        permissionService.delete(id);
        return "redirect:/permission";
    }

}
