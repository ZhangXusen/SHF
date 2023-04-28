package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.entity.*;
import com.atguigu.service.AdminService;
import com.atguigu.service.HouseBrokerService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/houseBroker")
public class HouseBrokerController extends BaseController {

    @Reference
    private HouseBrokerService houseBrokerService;

    @Reference
    private AdminService adminService;

    @GetMapping("/create")
    public String Create(Map map, @RequestParam("houseId") Long houseId) {
        map.put("houseId", houseId);
        List<Admin> adminList = adminService.findAll();
        map.put("adminList", adminList);
        return "houseBroker/create";
    }

    @PostMapping("/save")
    public String save(HouseBroker houseBroker) {
        Admin admin = adminService.getById(houseBroker.getBrokerId());
        houseBroker.setBrokerName(admin.getName());
        houseBroker.setBrokerHeadUrl(admin.getHeadUrl());
        houseBrokerService.insert(houseBroker);
        return "common/successPage";
    }

    @GetMapping("/edit/{id}")
    public String Edit(Map map, @PathVariable("id") Long id) {
        List<Admin> adminList = adminService.findAll();
        map.put("adminList", adminList);
        HouseBroker houseBroker = houseBrokerService.getById(id);
        map.put("houseBroker", houseBroker);
        return "houseBroker/edit";
    }

    @PostMapping("/update")
    public String update(HouseBroker houseBroker) {
        Admin admin = adminService.getById(houseBroker.getBrokerId());
        houseBroker.setBrokerName(admin.getName());
        houseBroker.setBrokerHeadUrl(admin.getHeadUrl());
        houseBrokerService.update(houseBroker);
        return "common/successPage";
    }

    @GetMapping("/delete/{houseId}/{id}")
    public String Delete(@PathVariable("houseId") Long houseId, @PathVariable("id") Long id) {
        houseBrokerService.delete(id);
        return "redirect:/house/" + houseId;
    }
}
