package com.atguigu.dao;

import com.atguigu.entity.Role;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;


public interface RoleDao extends BaseDao<Role> {
    List<Role> findAll();

    Role getById(Long id);

    Integer insert(Role role);

    void delete(Long id);

    Integer update(Role role);

    Page<Role> findPage(Map<String, Object> filters);


}
