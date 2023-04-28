package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.entity.UserInfo;
import com.atguigu.result.Result;
import com.atguigu.service.UserFollowService;
import com.atguigu.vo.UserFollowVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/userInfo")
public class UserFollowController extends BaseController {
    @Reference
    private UserFollowService userFollowService;

    @RequestMapping("/auth/follow/{houseId}")
    public Result Follow(@PathVariable("houseId") Long houseId, HttpServletRequest request) {
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("user");
        userFollowService.follow(userInfo.getId(), houseId);
        return Result.ok();
    }

    @GetMapping("/auth/list/{pageNum}/{pageSize}")
    public Result MyFollows(
            @PathVariable("pageNum") Integer pageNum,
            @PathVariable("pageSize") Integer pageSize,
            HttpServletRequest request) {

        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("user");
        PageInfo<UserFollowVo> pageInfo = userFollowService.findPageList(pageNum, pageSize, userInfo.getId());

        return Result.ok(pageInfo);
    }

    @GetMapping("/auth/cancelFollow/{userId}")
    public Result CancelFollow(
            @PathVariable("userId") Long userId
    ) {
        userFollowService.delete(userId);
        return Result.ok();
    }


}
