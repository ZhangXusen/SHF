package com.atguigu.service;

import com.atguigu.dao.BaseDao;
import com.atguigu.entity.HouseImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseImageService extends BaseService<HouseImage> {
    List<HouseImage> findList(Long houseId, Integer type);
}
