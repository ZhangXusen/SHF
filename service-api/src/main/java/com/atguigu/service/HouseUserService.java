package com.atguigu.service;

import com.atguigu.dao.BaseDao;
import com.atguigu.entity.HouseUser;

import java.util.List;

public interface HouseUserService extends BaseService<HouseUser> {
    List<HouseUser> findHouseUserById(Long houseId);
}
