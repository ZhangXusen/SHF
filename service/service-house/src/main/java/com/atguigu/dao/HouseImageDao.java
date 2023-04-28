package com.atguigu.dao;

import com.atguigu.entity.HouseImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseImageDao extends BaseDao<HouseImage> {
    List<HouseImage> findList(@Param("houseId") Long houseId, @Param("type") Integer type);
}
