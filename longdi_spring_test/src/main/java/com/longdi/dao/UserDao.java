package com.longdi.dao;

import com.longdi.domain.User;

import java.util.List;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/9/25 21:58
 */
public interface UserDao {
    List<User> findAll();

    Long save(User user);

    void saveUserRel(Long id, Long[] roleIds);

    void delUserRoleRel(long userId);

    void del(long userId);

    User findByUsernameAndPassword(String username, String password);
}
