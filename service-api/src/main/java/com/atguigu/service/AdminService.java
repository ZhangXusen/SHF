package com.atguigu.service;

import com.atguigu.entity.Admin;

import java.util.List;

public interface AdminService extends BaseService<Admin> {
    List<Admin> findAll();

    Admin getByUsername(String username);
}
