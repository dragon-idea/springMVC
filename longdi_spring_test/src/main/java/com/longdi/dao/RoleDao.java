package com.longdi.dao;

import com.longdi.domain.Role;

import java.util.List;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/9/25 18:09
 */
public interface RoleDao {
    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleByUserId(Long id);
}
