package com.learning.springboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learning.springboot.bean.UserBean;
import com.learning.springboot.bean.PageQueryVo;
import com.learning.springboot.mapper.UserMapper;

import java.util.List;

public interface UserService {
        UserBean loginIn(UserBean userBean);
        List<UserBean> getList();
        void newUser(UserBean userBean);
        String deleteUser(UserBean userBean);
        Page<UserBean> getUserpageList(PageQueryVo<UserBean> page);
        Page<UserBean> scorePagelist(PageQueryVo<UserBean> page);
}
