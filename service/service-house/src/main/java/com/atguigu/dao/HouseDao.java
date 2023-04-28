package com.atguigu.dao;

import com.atguigu.entity.Dict;
import com.atguigu.entity.House;
import com.atguigu.vo.HouseQueryVo;
import com.atguigu.vo.HouseVo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface HouseDao extends BaseDao<House> {
    Page<HouseVo> findPageList(@Param("vo") HouseQueryVo houseQueryVo);
}
