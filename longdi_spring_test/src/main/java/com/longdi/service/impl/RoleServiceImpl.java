package com.longdi.service.impl;

import com.longdi.dao.RoleDao;
import com.longdi.domain.Role;
import com.longdi.service.RoleService;

import java.util.List;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/9/25 18:06
 */
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> list() {
       List<Role> roleList= roleDao.findAll();
        return roleList;
    }

    public void save(Role role) {
        roleDao.save(role);
    }
}
