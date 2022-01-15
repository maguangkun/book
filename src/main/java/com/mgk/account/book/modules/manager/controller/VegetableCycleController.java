package com.mgk.account.book.modules.manager.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.mgk.account.book.common.utils.Result;
import com.mgk.account.book.modules.base.pojo.AbstractController;
import com.mgk.account.book.modules.manager.pojo.VegetableCycleDO;
import com.mgk.account.book.modules.manager.service.VegetableCycleService;
import com.mgk.account.book.modules.user.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;

/**
 * <p>
 *  周期表控制器
 * </p>
 *
 * @author 马广坤
 * @since 2021-10-09
 */
@RestController
@RequestMapping("/manager/VegetableCycleController")
public class VegetableCycleController  extends AbstractController<VegetableCycleDO> {
    @Autowired(required=true)
    private VegetableCycleService vegetableCycleService;
    @PostMapping("add")
    public Result add(VegetableCycleDO vegetableCycleDO){
        vegetableCycleDO.setUserId(super.getUser().getUserId());
        vegetableCycleService.save(vegetableCycleDO);
        return Result.ok(vegetableCycleDO);
    }
    @DeleteMapping("delete")
    public Result delete(VegetableCycleDO vegetableCycleDO){
        vegetableCycleDO.setDeleteTime(LocalDateTime.now());
        boolean b = vegetableCycleService.updateById(vegetableCycleDO);
//        boolean b = vegetableCycleService.removeById(vegetableCycleDO.getId());
        return Result.ok(b);
    }
    @PostMapping("update")
    public Result update(VegetableCycleDO vegetableCycleDO){
        vegetableCycleDO.setUpdateTime(LocalDateTime.now());
        boolean b = vegetableCycleService.saveOrUpdate(vegetableCycleDO);
        return Result.ok(vegetableCycleDO);
    }
    @PostMapping("search")
    public Result search(VegetableCycleDO vegetableCycleDO){
        List<VegetableCycleDO> list = vegetableCycleService.list();
        return Result.ok(list);
    }
    @GetMapping("list")
    @Override
    public Result list(VegetableCycleDO vegetableCycleDO) {
        vegetableCycleDO.setUserId(vegetableCycleDO.getId());
//        List<VegetableCycleDO> list = vegetableCycleService.list();
        QueryWrapper<VegetableCycleDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId",super.getUser().getUserId());
        queryWrapper.isNull("deleteTime") ;
        List<VegetableCycleDO> list = vegetableCycleService.list(queryWrapper);
        return Result.ok(list);
    }
}
