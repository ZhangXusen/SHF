package com.atguigu.service;

import com.atguigu.entity.Dict;

import java.util.List;

import java.util.Map;

public interface DictService extends BaseService<Dict> {
    List<Map<String, Object>> findZnodes(Long id);

    List<Dict> getDictByCode(String dictCode);

    List<Dict> findListByParentId(Long parentId);


    String getNameById(Long id);
}
