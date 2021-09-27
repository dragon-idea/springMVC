package com.longdi.service;

import com.longdi.domain.Role;

import java.util.List;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/9/25 18:04
 */
public interface RoleService {

   public List<Role> list();

    void save(Role role);
}
