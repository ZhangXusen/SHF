package com.atguigu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.Impl.BaseServiceImpl;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.PermissionDao;
import com.atguigu.dao.RolePermissionDao;
import com.atguigu.entity.Permission;
import com.atguigu.helper.PermissionHelper;
import com.atguigu.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.CollectionUtils;
import org.springframework.util.SimpleIdGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = PermissionService.class)
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Override
    protected BaseDao<Permission> getEntityDao() {

        return permissionDao;
    }


    @Override
    public List<Map<String, Object>> findPerByRoleId(Long id) {
        //获取所有权限
        List<Permission> permissionList = permissionDao.findAll();
        //获取当前角色的所有权限
        List<Long> permissionIds = rolePermissionDao.findPerIdsByRoleId(id);

        List<Map<String, Object>> list = new ArrayList<>();
        for (Permission permission : permissionList) {
            //{ id:1, pId:0, name:"随意勾选 1", open:true},
            //该权限是否属于当前角色的权限，是则入Map
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", permission.getId());
            map.put("pId", permission.getParentId());
            map.put("name", permission.getName());
            //如果该用户已经有了该权限
            if (permissionIds.contains(permission.getId())) {
                map.put("checked", true);
            }
            list.add(map);
        }
        return list;
    }

    @Override
    public void assignPer(Long roleId, Long[] permissionIds) {
        rolePermissionDao.deleteByRoleId(roleId);
        for (Long permissionId : permissionIds) {
            if (permissionId != null) {
                rolePermissionDao.insertRoleIdAndPerId(roleId, permissionId);
            }
        }
    }

    @Override
    public List<Permission> getMenuPerListByAdminId(Long userId) {
        List<Permission> permissionList = null;
        //系统管理员
        if (userId == 1) {
            permissionList = permissionDao.findAll();

        } else {
            permissionList = permissionDao.getMenuPerByAdminId(userId);
        }
        return PermissionHelper.bulid(permissionList);
    }

    @Override
    public List<Permission> findAllMenu() {

        List<Permission> permissionList = permissionDao.findAll();
        if (CollectionUtils.isEmpty(permissionList)) return null;
        else
            return PermissionHelper.bulid(permissionList);
    }

    @Override
    public List<String> getPerCodesByAdminId(Long id) {
        List<String> permissionCodes = null;
        if (id == 1) {
            permissionCodes = permissionDao.getAllPerCodes();
        } else {
            permissionCodes = permissionDao.getPerCodesByAdminId(id);
        }
        return permissionCodes;
    }
}
