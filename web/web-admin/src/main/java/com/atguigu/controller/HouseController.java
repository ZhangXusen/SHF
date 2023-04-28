package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.entity.*;
import com.atguigu.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller()
@RequestMapping("/house")
public class HouseController extends BaseController {
    @Reference
    private HouseService houseService;

    @Reference
    private CommunityService communityService;

    @Reference
    private DictService dictService;
    @Reference
    private HouseUserService houseUserService;
    @Reference
    private HouseImageService houseImageService;
    @Reference
    private HouseBrokerService houseBrokerService;

    @RequestMapping()
    public String index(Map map, HttpServletRequest req) {
        Map<String, Object> filters = getFilters(req);
        map.put("filters", filters);
        PageInfo<House> page = houseService.findPage(filters);
        map.put("page", page);
        List<Community> communityList = communityService.findAll();
        map.put("communityList", communityList);
        List<Dict> houseType = dictService.getDictByCode("houseType");
        map.put("houseTypeList", houseType);
        List<Dict> floor = dictService.getDictByCode("floor");
        map.put("floorList", floor);
        List<Dict> buildStructureList = dictService.getDictByCode("buildStructure");
        map.put("buildStructureList", buildStructureList);
        List<Dict> directionList = dictService.getDictByCode("direction");
        map.put("directionList", directionList);
        List<Dict> decorationList = dictService.getDictByCode("decoration");
        map.put("decorationList", decorationList);
        List<Dict> houseUseList = dictService.getDictByCode("houseUse");
        map.put("houseUseList", houseUseList);
        return "house/index";
    }

    @GetMapping("/create")
    public String Create(Map map) {
        List<Community> communityList = communityService.findAll();
        map.put("communityList", communityList);
        List<Dict> houseType = dictService.getDictByCode("houseType");
        map.put("houseTypeList", houseType);
        List<Dict> floor = dictService.getDictByCode("floor");
        map.put("floorList", floor);
        List<Dict> buildStructureList = dictService.getDictByCode("buildStructure");
        map.put("buildStructureList", buildStructureList);
        List<Dict> directionList = dictService.getDictByCode("direction");
        map.put("directionList", directionList);
        List<Dict> decorationList = dictService.getDictByCode("decoration");
        map.put("decorationList", decorationList);
        List<Dict> houseUseList = dictService.getDictByCode("houseUse");
        map.put("houseUseList", houseUseList);
        return "house/create";
    }

    @PostMapping("/save")
    public String save(House house) {
        houseService.insert(house);

        return "common/successPage";
    }

    @RequestMapping("/edit/{id}")
    public String Edit(Map map, @PathVariable("id") Long id) {
        House house = houseService.getById(id);
        map.put("house", house);
        List<Community> communityList = communityService.findAll();
        map.put("communityList", communityList);
        List<Dict> houseType = dictService.getDictByCode("houseType");
        map.put("houseTypeList", houseType);
        List<Dict> floor = dictService.getDictByCode("floor");
        map.put("floorList", floor);
        List<Dict> buildStructureList = dictService.getDictByCode("buildStructure");
        map.put("buildStructureList", buildStructureList);
        List<Dict> directionList = dictService.getDictByCode("direction");
        map.put("directionList", directionList);
        List<Dict> decorationList = dictService.getDictByCode("decoration");
        map.put("decorationList", decorationList);
        List<Dict> houseUseList = dictService.getDictByCode("houseUse");
        map.put("houseUseList", houseUseList);
        return "house/edit";
    }

    @PostMapping(value = "/update")
    public String update(House house) {

        houseService.update(house);

        return "common/successPage";
    }

    @RequestMapping("/delete/{id}")
    public String Delete(Map map, @PathVariable("id") Long id) {
        houseService.delete(id);
        return "redirect:/house";
    }

    /*发布*/
    @GetMapping("/publish/{id}/{status}")
    public String Publish(Map map, @PathVariable("id") Long id, @PathVariable("status") Integer status) {
        houseService.publish(id, status);
        return "redirect:/house";
    }

    @RequestMapping("/{houseId}")
    public String Detail(Map map, @PathVariable("houseId") Long houseId) {
        House house = houseService.getById(houseId);
        map.put("house", house);
        Community community = communityService.getById(house.getCommunityId());
        map.put("community", community);
        List<HouseImage> houseImageList = houseImageService.findList(houseId, 1);
        map.put("houseImage1List", houseImageList);
        List<HouseImage> houseImageList2 = houseImageService.findList(houseId, 2);
        map.put("houseImage2List", houseImageList2);
        List<HouseBroker> houseBrokerList = houseBrokerService.findHouseBrokerById(houseId);
        map.put("houseBrokerList", houseBrokerList);
        List<HouseUser> houseUserList = houseUserService.findHouseUserById(houseId);
        map.put("houseUserList", houseUserList);
        return "house/show";
    }
}
