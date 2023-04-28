package com.atguigu.dao;

import com.atguigu.entity.Permission;
import com.atguigu.entity.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermissionDao extends BaseDao<RolePermission> {
    List<Long> findPerIdsByRoleId(Long id);

    void insertRoleIdAndPerId(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    void deleteByRoleId(Long roleId);
}
