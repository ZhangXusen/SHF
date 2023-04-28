package com.atguigu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.Impl.BaseServiceImpl;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.DictDao;
import com.atguigu.entity.Dict;
import com.atguigu.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = DictService.class)
public class DictServiceImpl extends BaseServiceImpl<Dict> implements DictService {
    @Autowired
    private DictDao dictDao;

    @Override
    protected BaseDao<Dict> getEntityDao() {
        return dictDao;
    }

    @Override
    public List<Map<String, Object>> findZnodes(Long id) {
        // 返回数据[{ id:2, isParent:true, name:"随意勾选 2"}]
        List<Map<String, Object>> res = new ArrayList<>();
        //根据id获取子节点数据
        List<Dict> chilrens = dictDao.findListByParentId(id);
        for (Dict chilren : chilrens) {
            Integer num = dictDao.countIsParent(chilren.getId());
            Map map = new HashMap<>();
            map.put("id", chilren.getId());
            map.put("isParent", num > 0 ? true : false);
            map.put("name", chilren.getName());
            res.add(map);
        }
        //判断该节点是否是父节点
        //全部权限列表
        return res;
    }

    @Override
    public List<Dict> getDictByCode(String dictCode) {
        Dict dict = dictDao.getDictByCode(dictCode);
        if (dict == null) return null;
        return this.findListByParentId(dict.getId());
    }

    @Override
    public List<Dict> findListByParentId(Long parentId) {

        return dictDao.findListByParentId(parentId);
    }

    @Override
    public String getNameById(Long id) {
        return dictDao.getNameById(id);
    }
}
