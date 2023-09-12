package com.learning.springboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learning.springboot.bean.UserBean;
import com.learning.springboot.mapper.UserMapper;
import com.learning.springboot.service.UserService;
import com.learning.springboot.bean.PageQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LoginController {

    //将Service注入Web层
    @Autowired
    UserService userService;

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(@RequestBody UserBean userBean) {
        userBean=userService.loginIn(userBean);
        if (userBean != null) {
            return "success";
        } else {
            return "error";
        }
    }
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    @ResponseBody
     List<UserBean> getList() {
        List<UserBean> User=userService.getList();
        return User;
    }
    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    @ResponseBody
    public String newUser(@RequestBody UserBean userBean){
        userService.newUser(userBean);
        if (userBean != null) {
            return "SUCCESS!!";
        } else {
            return "FAIL!!";
        }
    }
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    @ResponseBody
    public String deleteUser(@RequestBody UserBean userBean){
        return userService.deleteUser(userBean);
    }

    @RequestMapping(value = "/getUserpageList",method = RequestMethod.POST)
    @ResponseBody
    public Page<UserBean> getUserpageList(@RequestBody PageQueryVo<UserBean> page){
        return userService.getUserpageList(page);
    }
    @RequestMapping(value = "/scorePagelist",method = RequestMethod.POST)
    @ResponseBody
    public Page<UserBean> scorePagelist(@RequestBody PageQueryVo<UserBean> page){
        return userService.scorePagelist(page);
    }
}