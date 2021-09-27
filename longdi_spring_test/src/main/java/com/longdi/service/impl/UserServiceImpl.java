package com.longdi.service.impl;

import com.longdi.dao.RoleDao;
import com.longdi.dao.UserDao;
import com.longdi.domain.Role;
import com.longdi.domain.User;
import com.longdi.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/9/25 21:52
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<User> list() {
         List<User> userList=userDao.findAll();
         //封装userList中的每个User的roles数据
        for (User user : userList) {
            //获得user的id
              Long id=user.getId();
              //将id作为参数，查询当前userId对应的roe集合数据
          List<Role> roles=roleDao.findRoleByUserId(id);
          user.setRoles(roles);
        }
        return userList;
    }

    public void save(User user, Long[] roleIds) {
        //第一步，向sys_user表存储数据
         Long userId =userDao.save(user);
        //第二步，向sys_user_role关系表中存储多条数据
        userDao.saveUserRel(userId,roleIds);
    }

    public void del(long userId) {
        // 1.删除sys_user_role关系表
        userDao.delUserRoleRel(userId);
        // 2.删除sys_user表
        userDao.del(userId);
    }

    public User login(String username, String password) {
        try{
            User user=userDao.findByUsernameAndPassword(username,password);
            return user;
        }catch (EmptyResultDataAccessException e){
                return null;
        }
    }
}
