package com.mgk.account.book.modules.base.pojo;

import com.mgk.account.book.common.utils.JWTUtil;
import com.mgk.account.book.common.utils.Result;
import com.mgk.account.book.modules.user.entity.SysUserEntity;
import com.mgk.account.book.modules.user.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractController<T> {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected SysUserServiceImpl userService;
    public abstract Result add(T t);
    public abstract Result delete(T t);
    public abstract Result update(T t);
    public abstract Result search(T t);
    public abstract Result list(T t);

    protected SysUserEntity getUser(){
        String token = request.getHeader("Authorization");
        String username = JWTUtil.getUsername(token);
        SysUserEntity sysUserEntity = userService.queryByUserName(username);
        return sysUserEntity;
    }
}
