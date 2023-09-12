package com.learning.springboot.mapper;

import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learning.springboot.bean.ScoreBean;
import com.learning.springboot.bean.UserBean;
import com.learning.springboot.bean.PageQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper  {
    //登录
    UserBean getInfo(UserBean userBean);
    //查询用户列表
    List<UserBean> getList();
    //新增用户
     void newUser(UserBean userBean);
     //删除用户
     int deleteUser(UserBean userBean);
     //分页列表
     Page<UserBean> getUserpageList(Page<UserBean> page, @Param(Constants.WRAPPER) UserBean query);
     //分页用户分数

     Page<UserBean> scorePagelist(Page<UserBean> page, @Param(Constants.WRAPPER) UserBean query);
}