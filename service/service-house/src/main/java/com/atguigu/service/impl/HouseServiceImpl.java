package com.atguigu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.Impl.BaseServiceImpl;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.DictDao;
import com.atguigu.dao.HouseDao;
import com.atguigu.entity.House;
import com.atguigu.service.HouseService;

import com.atguigu.vo.HouseQueryVo;
import com.atguigu.vo.HouseVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Service(interfaceClass = HouseService.class)
public class HouseServiceImpl extends BaseServiceImpl<House> implements HouseService {
    @Autowired
    private HouseDao houseDao;

    @Autowired
    private DictDao dictDao;

    @Override
    protected BaseDao<House> getEntityDao() {
        return houseDao;
    }


    @Override
    public void publish(Long id, Integer status) {
        House house = new House();
        house.setId(id);
        house.setStatus(status);
        houseDao.update(house);
    }

    @Override
    public PageInfo<HouseVo> findPageList(Integer pageNum, Integer pageSize, HouseQueryVo query) {
        PageHelper.startPage(pageNum, pageSize);

        Page<HouseVo> page = houseDao.findPageList(query);
        List<HouseVo> list = page.getResult();
        for (HouseVo houseVo : list) {
            String houseType = dictDao.getNameById(houseVo.getHouseTypeId());
            String floor = dictDao.getNameById(houseVo.getFloorId());
            String direction = dictDao.getNameById(houseVo.getDirectionId());

            houseVo.setHouseTypeName(houseType);
            houseVo.setDirectionName(direction);
            houseVo.setFloorName(floor);
        }
        return new PageInfo<HouseVo>(page, 5);
    }

    @Override
    public House getById(Serializable id) {
        House house = houseDao.getById(id);
        String houseTypeName = dictDao.getNameById(house.getHouseTypeId());
        String directName = dictDao.getNameById(house.getDirectionId());
        String floorName = dictDao.getNameById(house.getFloorId());
        String decorationName = dictDao.getNameById(house.getDecorationId());
        String houseUseName = dictDao.getNameById(house.getHouseUseId());
        String buildName = dictDao.getNameById(house.getBuildStructureId());
        house.setHouseTypeName(houseTypeName);
        house.setBuildStructureName(buildName);
        house.setFloorName(floorName);
        house.setDecorationName(decorationName);
        house.setDirectionName(directName);
        house.setHouseUseName(houseUseName);
        return house;
    }
}
