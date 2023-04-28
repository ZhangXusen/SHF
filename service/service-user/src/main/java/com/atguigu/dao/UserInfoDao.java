package com.atguigu.dao;

import com.atguigu.entity.UserInfo;

public interface UserInfoDao extends BaseDao<UserInfo> {
    UserInfo getByPhone(String phone);
}
