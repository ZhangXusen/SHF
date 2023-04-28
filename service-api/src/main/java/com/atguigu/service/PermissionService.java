package com.atguigu.service;

import com.atguigu.entity.Permission;

import java.util.List;
import java.util.Map;

public interface PermissionService extends BaseService<Permission> {

    List<Map<String, Object>> findPerByRoleId(Long id);

    void assignPer(Long roleId, Long[] permissionIds);

    List<Permission> getMenuPerListByAdminId(Long userId);

    List<Permission> findAllMenu();

    List<String> getPerCodesByAdminId(Long id);
}
