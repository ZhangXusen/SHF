package com.atguigu.service;

import com.atguigu.entity.UserFollow;
import com.atguigu.vo.UserFollowVo;
import com.github.pagehelper.PageInfo;

public interface UserFollowService extends BaseService<UserFollow> {
    void follow(Long userId, Long houseId);

    Boolean isFollow(Long id, Long houseId);

    PageInfo<UserFollowVo> findPageList(Integer pageNum, Integer pageSize, Long id);
}
