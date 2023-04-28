package com.atguigu.dao;

import com.atguigu.entity.HouseBroker;

import java.util.List;

public interface HouseBrokerDao extends BaseDao<HouseBroker> {
    List<HouseBroker> findHouseBrokerById(Long houseId);
}
