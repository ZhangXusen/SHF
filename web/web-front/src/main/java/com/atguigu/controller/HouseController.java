package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.entity.*;
import com.atguigu.result.Result;
import com.atguigu.service.*;
import com.atguigu.vo.HouseQueryVo;
import com.atguigu.vo.HouseVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/house")
public class HouseController extends BaseController {
    @Reference
    private HouseService houseService;

    @Reference
    private CommunityService communityService;
    @Reference
    private HouseImageService houseImageService;
    @Reference
    private HouseBrokerService houseBrokerService;

    @Reference
    private UserFollowService userFollowService;

    @RequestMapping("/list/{pageNum}/{pageSize}")
    public Result findPageList(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, @RequestBody HouseQueryVo query) {
        PageInfo<HouseVo> pageInfo = houseService.findPageList(pageNum, pageSize, query);
        return Result.ok(pageInfo);
    }

    @GetMapping("/info/{houseId}")
    public Result GetInfo(@PathVariable("houseId") Long houseId, HttpServletRequest request) {
        House house = houseService.getById(houseId);
        Community community = communityService.getById(house.getCommunityId());
        List<HouseImage> houseImage = houseImageService.findList(houseId, 1);
        List<HouseBroker> houseBroker = houseBrokerService.findHouseBrokerById(houseId);
        Map<String, Object> map = new HashMap<>();
        map.put("house", house);
        map.put("community", community);
        map.put("houseBroker", houseBroker);
        map.put("houseImage1List", houseImage);
        Boolean isFollow = false;
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("user");
        isFollow = userFollowService.isFollow(userInfo.getId(), houseId);
        map.put("isFollow", isFollow);
        return Result.ok(map);
    }
}
