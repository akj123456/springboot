package com.learning.springboot.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learning.springboot.bean.ScoreBean;
import com.learning.springboot.bean.UserBean;
import com.learning.springboot.mapper.UserMapper;
import com.learning.springboot.service.UserService;
import com.learning.springboot.bean.PageQueryVo;
import com.learning.springboot.utils.Noutils;
import javafx.scene.input.DataFormat;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;

    @Override
    public UserBean loginIn(UserBean userBean) {
        return userMapper.getInfo(userBean);

    }

    @Override
    public List<UserBean> getList() {
        return userMapper.getList();
    }

    @Override
    public void newUser(UserBean userBean) {
        userBean.setId(Noutils.getRandomID());
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        userBean.setCreattime(ts);
        userMapper.newUser(userBean);
    }

    @Override
    public String deleteUser(UserBean userBean) {
        int result = userMapper.deleteUser(userBean);
        if (result != 0) {
            return "SUCCESS!";
        } else {
            return "FAIL!";
        }
    }

    @Override
    public Page<UserBean> getUserpageList(PageQueryVo<UserBean> page) {
        UserBean query = page.getQuery();
        return userMapper.getUserpageList(page.getPage(), query);

    }

    @Override
    public Page<UserBean> scorePagelist(PageQueryVo<UserBean> page) {
        UserBean query = page.getQuery();
        return userMapper.scorePagelist(page.getPage(),query);
    }
}

