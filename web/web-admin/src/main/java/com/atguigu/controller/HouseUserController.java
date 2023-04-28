package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.entity.Admin;
import com.atguigu.entity.HouseBroker;
import com.atguigu.entity.HouseUser;
import com.atguigu.service.AdminService;
import com.atguigu.service.HouseBrokerService;
import com.atguigu.service.HouseUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/houseUser")
public class HouseUserController extends BaseController {

    @Reference
    private HouseUserService houseUserService;

    @Reference
    private AdminService adminService;

    @GetMapping("/create")
    public String Create(Map map, @RequestParam("houseId") Long houseId) {
        map.put("houseId", houseId);
        return "houseUser/create";
    }

    @PostMapping("/save")
    public String save(HouseUser houseUser) {
        houseUserService.insert(houseUser);
        return "common/successPage";
    }

    @GetMapping("/edit/{id}")
    public String Edit(Map map, @PathVariable("id") Long id) {
        HouseUser houseUser = houseUserService.getById(id);
        map.put("houseUser", houseUser);
        return "houseUser/edit";
    }

    @PostMapping("/update")
    public String update(HouseUser houseUser) {
        houseUserService.update(houseUser);
        return "common/successPage";
    }

    @GetMapping("/delete/{houseId}/{id}")
    public String Delete(@PathVariable("houseId") Long houseId, @PathVariable("id") Long id) {
        houseUserService.delete(id);
        return "redirect:/house/" + houseId;
    }
}
