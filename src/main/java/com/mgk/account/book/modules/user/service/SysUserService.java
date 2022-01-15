/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.mgk.account.book.modules.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mgk.account.book.modules.user.entity.SysUserEntity;


/**
 * 系统用户
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysUserService extends IService<SysUserEntity> {
    SysUserEntity login(String username, String password);
    SysUserEntity queryByUserName(String username);
}
