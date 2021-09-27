package com.longdi.service;

import com.longdi.domain.User;

import java.util.List;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/9/25 21:51
 */
public interface UserService {
    List<User> list();

    void save(User user, Long[] roleIds);

    void del(long userId);

    User login(String username, String password);
}
