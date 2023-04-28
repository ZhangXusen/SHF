package com.atguigu.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.Impl.BaseServiceImpl;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.UserFollowDao;
import com.atguigu.entity.UserFollow;
import com.atguigu.service.*;
import com.atguigu.vo.UserFollowVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserFollowServiceImpl extends BaseServiceImpl<UserFollow> implements UserFollowService {
    @Autowired
    private UserFollowDao userFollowDao;
    @Reference
    private DictService dictService;

    @Override
    protected BaseDao<UserFollow> getEntityDao() {
        return userFollowDao;
    }

    @Override
    public void follow(Long userId, Long houseId) {
        UserFollow userFollow = new UserFollow();
        userFollow.setHouseId(houseId);
        userFollow.setUserId(userId);
        userFollowDao.insert(userFollow);
    }

    @Override
    public Boolean isFollow(Long id, Long houseId) {
        Integer count = userFollowDao.getCountByUserId(id, houseId);
        if (count > 0) return true;
        else return false;
    }

    @Override
    public PageInfo<UserFollowVo> findPageList(Integer pageNum, Integer pageSize, Long id) {
        PageHelper.startPage(pageNum, pageSize);
        Page<UserFollowVo> page = userFollowDao.findPageList(id);
        for (UserFollowVo userFollowVo : page) {
            String houseType = dictService.getNameById(userFollowVo.getHouseTypeId());
            String floor = dictService.getNameById(userFollowVo.getFloorId());
            String Direction = dictService.getNameById(userFollowVo.getDirectionId());
            userFollowVo.setFloorName(floor);
            userFollowVo.setDirectionName(Direction);
            userFollowVo.setHouseTypeName(houseType);
        }
        return new PageInfo<>(page, 5);
    }
}
