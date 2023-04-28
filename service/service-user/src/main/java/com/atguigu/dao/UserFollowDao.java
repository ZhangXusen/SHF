package com.atguigu.dao;

import com.atguigu.entity.UserFollow;
import com.atguigu.vo.UserFollowVo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserFollowDao extends BaseDao<UserFollow> {
    Integer getCountByUserId(@Param("id") Long id, @Param("houseId") Long houseId);

    Page<UserFollowVo> findPageList(Long id);
}
