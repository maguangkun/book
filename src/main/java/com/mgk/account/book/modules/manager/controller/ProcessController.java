package com.mgk.account.book.modules.manager.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mgk.account.book.common.utils.Result;
import com.mgk.account.book.modules.base.pojo.AbstractController;
import com.mgk.account.book.modules.manager.pojo.ProcessDO;
import com.mgk.account.book.modules.manager.pojo.VegetableCycleDO;
import com.mgk.account.book.modules.manager.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/manager/ProcessController")
public class ProcessController extends AbstractController<ProcessDO> {
    @Autowired
    private ProcessService processService;
    @RequestMapping("add")
    @Override
    public Result add(ProcessDO processDO) {
        boolean save = processService.save(processDO);
        return Result.ok(processDO);
    }

    @RequestMapping("delete")
    @Override
    public Result delete(ProcessDO processDO) {
        processDO.setDeleteTime(LocalDateTime.now());
        boolean b = processService.updateById(processDO);
        return Result.ok(b);
    }
    @PostMapping("update")
    public Result update(ProcessDO processDO) {
        processDO.setUpdateTime(LocalDateTime.now());
        boolean b = processService.saveOrUpdate(processDO);
        return Result.ok(processDO);
    }
    @RequestMapping("search")
    @Override
    public Result search(ProcessDO processDO) {
        return null;
    }

    @RequestMapping("list")
    @Override
    public Result list(ProcessDO processDO) {
        QueryWrapper<ProcessDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("vegetableCycleId",processDO.getVegetableCycleId());
        queryWrapper.isNull("deleteTime") ;
        List<ProcessDO> list = processService.list(queryWrapper);
        return Result.ok(list);
    }
}
