package com.longdi.controller;

import com.longdi.domain.Role;
import com.longdi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/9/25 17:54
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/save")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:/role/list";
    }
    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView=new ModelAndView();
       List<Role> roleList= roleService.list();
       //设置模型
       modelAndView.addObject("roleList",roleList);
       //设置视图
        modelAndView.setViewName("role-list");
        return modelAndView;
    }
}
