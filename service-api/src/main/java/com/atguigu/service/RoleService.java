package com.atguigu.service;

import com.atguigu.entity.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;


public interface RoleService extends BaseService<Role> {
    List<Role> findAll();

    Integer insert(Role role);

    void delete(Long id);

    Role getById(Long id);

    Integer update(Role role);

    PageInfo<Role> findPage(Map<String, Object> filters);

    Map<String, Object> findRoleByAdminId(Long adminId);

    void assignRole(Long adminId, Long[] roleIds);
}
