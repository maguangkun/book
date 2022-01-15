package com.mgk.account.book.modules.manager.controller;


import com.mgk.account.book.common.utils.JWTUtil;
import com.mgk.account.book.common.utils.Result;
import com.mgk.account.book.common.utils.StatusCode;
import com.mgk.account.book.modules.manager.entity.Vegetableproject;
import com.mgk.account.book.modules.manager.service.impl.VegetableprojectServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 马广坤
 * @since 2021-10-09
 */
@RestController
@RequestMapping("/promanager/vegetableproject")
public class VegetableprojectController {
    @Autowired
    private VegetableprojectServiceImpl vegetableprojectService;
    @RequestMapping("hello")
    public String hello(){
        Vegetableproject vegetableproject = new Vegetableproject();
        vegetableproject.setName("xbc");
        vegetableproject.setCreateDate(LocalDateTime.now());
        vegetableprojectService.save(vegetableproject);
        return "ok";
    }
    @PostMapping("AddVegetableProject")
    public Result AddVegetableProject(@ModelAttribute Vegetableproject vegetableproject, HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String username = JWTUtil.getUsername(token);
        if(StringUtils.isEmpty(username)){
            return Result.error(StatusCode.USERNOTHING,"用户登陆超时、请重新登陆。");
        }
        vegetableproject.setCreateDate(LocalDateTime.now());
        vegetableprojectService.save(vegetableproject);
        return Result.ok();
    }
    @RequestMapping("GetVegetableProjectList")
    public Result GetVegetableProjectList(){
        List<Vegetableproject> list = vegetableprojectService.list();
        return Result.ok(list);
    }

}

