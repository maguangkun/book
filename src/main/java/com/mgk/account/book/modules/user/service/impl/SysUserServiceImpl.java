/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.mgk.account.book.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mgk.account.book.modules.user.dao.SysUserDao;
import com.mgk.account.book.modules.user.entity.SysUserEntity;
import com.mgk.account.book.modules.user.service.SysUserService;
import com.mgk.account.book.modules.vegetables.entity.Vegetables;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * 系统用户
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Override
    public SysUserEntity login(String username, String password) {
        List list = new ArrayList();
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        List<SysUserEntity> vegetablesList = this.list(queryWrapper);
        if (vegetablesList.size()==1){
            return vegetablesList.get(0);
        }
        return null;
    }

    @Override
    public SysUserEntity queryByUserName(String username) {
        List list = new ArrayList();
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        List<SysUserEntity> vegetablesList = this.list(queryWrapper);
        if (vegetablesList.size()==1){
            return vegetablesList.get(0);
        }
        return null;
    }
}