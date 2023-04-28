package com.atguigu.dao;

import com.atguigu.entity.Dict;

import java.util.List;


public interface DictDao extends BaseDao<Dict> {
    List<Dict> findListByParentId(Long parentId);

    Integer countIsParent(Long id);

    Dict getDictByCode(String dictCode);

    String getNameById(Long id);

}
