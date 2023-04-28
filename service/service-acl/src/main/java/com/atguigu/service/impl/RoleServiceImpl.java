package com.atguigu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.Impl.BaseServiceImpl;
import com.atguigu.dao.AdminRoleDao;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.RoleDao;
import com.atguigu.entity.Role;
import com.atguigu.service.RoleService;
import com.atguigu.util.CastUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service(interfaceClass = RoleService.class)
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private AdminRoleDao adminRoleDao;

    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    protected BaseDao<Role> getEntityDao() {
        return roleDao;
    }

    @Override
    public Integer insert(Role role) {
        return roleDao.insert(role);
    }

    @Override
    public void delete(Long id) {
        roleDao.delete(id);
    }

    @Override
    public Role getById(Long id) {
        return roleDao.getById(id);
    }

    @Override
    public Integer update(Role role) {
        roleDao.update(role);
        return null;
    }

    @Override
    public PageInfo<Role> findPage(Map<String, Object> filters) {
        //当前页数
        int pageNum = CastUtil.castInt(filters.get("pageNum"));
        int pageSize = CastUtil.castInt(filters.get("pageSize"));
        PageHelper.startPage(pageNum, pageSize);
        Page<Role> page = roleDao.findPage(filters);
        return new PageInfo<Role>(page, 5);
    }

    @Override
    public Map<String, Object> findRoleByAdminId(Long adminId) {
        List<Role> roleList = roleDao.findAll();
        List<Long> roleIds = adminRoleDao.findRoleIdsByAdminId(adminId);
        List<Role> noAssginRoleList = new ArrayList<>();
        List<Role> assginRoleList = new ArrayList<>();

        for (Role role : roleList) {
            if (roleIds.contains(role.getId())) {
                assginRoleList.add(role);
            } else {
                noAssginRoleList.add(role);
            }
        }

        Map<String, Object> roleMap = new HashMap<>();
        roleMap.put("assginRoleList", assginRoleList);
        roleMap.put("noAssginRoleList", noAssginRoleList);
        return roleMap;
    }

    @Override
    public void assignRole(Long adminId, Long[] roleIds) {
        adminRoleDao.deleteByAdminId(adminId);
        for (Long roleId : roleIds) {
            if (roleId != null) {
                adminRoleDao.insertRoleIDAndAdminId(roleId, adminId);
            }
        }
    }
}
