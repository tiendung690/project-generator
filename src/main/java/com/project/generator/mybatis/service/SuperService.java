package com.project.generator.mybatis.service;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

public class SuperService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements IService<T> {
}
