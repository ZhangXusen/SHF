package com.atguigu.service;

import com.atguigu.dao.BaseDao;
import com.atguigu.entity.UserInfo;

public interface UserInfoService extends BaseService<UserInfo> {
    UserInfo getUserInfoByPhone(String phone);
}
