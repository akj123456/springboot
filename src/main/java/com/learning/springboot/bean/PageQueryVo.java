package com.learning.springboot.bean;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;


@Data
public class PageQueryVo<T> implements Serializable {

    private Page<T> page;

    private T query;
}
