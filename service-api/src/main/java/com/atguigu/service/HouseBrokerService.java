package com.atguigu.service;

import com.atguigu.dao.BaseDao;
import com.atguigu.entity.HouseBroker;

import java.util.List;

public interface HouseBrokerService extends BaseService<HouseBroker> {
    List<HouseBroker> findHouseBrokerById(Long houseId);
}
