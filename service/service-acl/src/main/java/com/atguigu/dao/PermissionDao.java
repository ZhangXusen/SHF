package com.atguigu.dao;

import com.atguigu.entity.Permission;

import java.util.List;
import java.util.Map;

public interface PermissionDao extends BaseDao<Permission> {


    List<Permission> findAll();

    List<Permission> getMenuPerByAdminId(Long userId);

    List<String> getPerCodesByAdminId(Long id);

    List<String> getAllPerCodes();
}
