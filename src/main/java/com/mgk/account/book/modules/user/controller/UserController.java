package com.mgk.account.book.modules.user.controller;

import com.mgk.account.book.common.conf.JwtConfigProperties;
import com.mgk.account.book.common.utils.JWTUtil;
import com.mgk.account.book.common.utils.Result;
import com.mgk.account.book.modules.user.entity.SysUserEntity;
import com.mgk.account.book.modules.user.service.impl.SysUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "/user", tags = "用户接口")
public class UserController {

    @Autowired
    private SysUserServiceImpl userService;

    @Autowired
    private JwtConfigProperties jwtConfigProperties;

    @PostMapping("/login")
    public Result login(String username, String password){
        SysUserEntity user = userService.login(username, password);
        if (user != null){
            // 登录成功，返回token
            return Result.ok("登录成功", JWTUtil.sign(username, jwtConfigProperties));
        }else {
            return Result.error("登录失败");
        }
    }

    /**
     * 未登录，没有token会重定向到这个方法来
     * @param msg
     * @return
     * @throws UnsupportedEncodingException
     */
    @CrossOrigin(origins ="*",maxAge = 3600)
    @GetMapping("/unlogin")
    public Result unlogin(String msg) throws UnsupportedEncodingException {
        return Result.error(new String(msg.getBytes(), "UTF-8"));
    }

    /**
     * 获取所有用户，返回json数据，访问时需要在header中带上token（headers加上Authorization: token内容）
     * @return 返回json数据
     */
    @RequestMapping("/get/all")
    @ApiOperation(value = "查询所有用户")
    public Result getAllUsers(){
        List<SysUserEntity> allUsers = userService.list();
        return allUsers != null ? Result.ok(allUsers) : Result.error();
    }
}

