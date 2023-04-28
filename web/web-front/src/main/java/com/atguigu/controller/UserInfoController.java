package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.entity.*;
import com.atguigu.result.Result;
import com.atguigu.result.ResultCodeEnum;
import com.atguigu.service.*;
import com.atguigu.util.MD5;
import com.atguigu.vo.HouseQueryVo;
import com.atguigu.vo.HouseVo;
import com.atguigu.vo.LoginVo;
import com.atguigu.vo.RegisterVo;
import com.github.pagehelper.PageInfo;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController extends BaseController {
    @Reference
    private UserInfoService userInfoService;

    @GetMapping("/sendCode/{phone}")
    public Result SendCode(@PathVariable("phone") String phone, HttpServletRequest req) {
        String code = "8888";
        req.getSession().setAttribute("code", code);
        return Result.ok(code);
    }

    @PostMapping("/register")
    public Result SendCode(@RequestBody RegisterVo req, HttpSession session) {
        String phone = req.getPhone();
        String password = req.getPassword();
        String nickName = req.getNickName();
        String code = req.getCode();
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password) || StringUtils.isEmpty(nickName) || StringUtils.isEmpty(code)) {
            return Result.build(null, ResultCodeEnum.PARAM_ERROR);
        }
        String code1 = (String) session.getAttribute("code");
        if (!code1.equals(code)) {
            return Result.build("验证码错误", ResultCodeEnum.CODE_ERROR);
        }
        UserInfo userInfo = userInfoService.getUserInfoByPhone(phone);
        if (null != userInfo) {
            return Result.build(null, ResultCodeEnum.PHONE_REGISTER_ERROR);
        }
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setNickName(nickName);
        userInfo1.setPassword(MD5.encrypt(password));
        userInfo1.setPhone(phone);
        userInfo1.setStatus(1);
        return Result.build(userInfo1, ResultCodeEnum.SUCCESS);
    }

    @PostMapping("/login")
    public Result Login(@RequestBody LoginVo data, HttpServletRequest request) {
        String phone = data.getPhone();
        String password = data.getPassword();
        //判空
        if (StringUtils.isEmpty(password) || StringUtils.isEmpty(phone)) {
            return Result.build(null, ResultCodeEnum.PARAM_ERROR);

        }
        UserInfo userInfo = userInfoService.getUserInfoByPhone(phone);
        //未注册
        if (null == userInfo) {
            return Result.build(null, ResultCodeEnum.ACCOUNT_ERROR);
        }
        if (!MD5.encrypt(password).equals(userInfo.getPassword())) {
            return Result.build(null, ResultCodeEnum.PARAM_ERROR);
        }
        if (userInfo.getStatus() == 0) {
            return Result.build(null, ResultCodeEnum.ACCOUNT_LOCK_ERROR);
        }

        request.getSession().setAttribute("user", userInfo);

        HashMap<String, Object> uerInfoRes = new HashMap<>();
        uerInfoRes.put("phone", userInfo.getPhone());
        uerInfoRes.put("nickName", userInfo.getNickName());
        return Result.ok(uerInfoRes);
    }

    @GetMapping("/logout")
    public Result Logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return Result.ok();
    }
}
