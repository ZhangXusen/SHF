package com.atguigu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.Impl.BaseServiceImpl;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.HouseBrokerDao;
import com.atguigu.entity.HouseBroker;
import com.atguigu.entity.HouseImage;
import com.atguigu.service.HouseBrokerService;
import com.atguigu.service.HouseImageService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service(interfaceClass = HouseBrokerService.class)
public class HouseBrokerServiceImpl extends BaseServiceImpl<HouseBroker> implements HouseBrokerService {
    @Autowired
    private HouseBrokerDao houseBrokerDao;

    @Override
    protected BaseDao<HouseBroker> getEntityDao() {
        return houseBrokerDao;
    }

    @Override
    public List<HouseBroker> findHouseBrokerById(Long houseId) {
        return houseBrokerDao.findHouseBrokerById(houseId);
    }
}
