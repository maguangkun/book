package com.mgk.account.book.modules.manager.controller;

import com.mgk.account.book.common.utils.Result;
import com.mgk.account.book.modules.base.pojo.AbstractController;
import com.mgk.account.book.modules.manager.pojo.ManpowerDO;
import com.mgk.account.book.modules.manager.pojo.ProcessDO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager/ManpowerController")
public class ManpowerController extends AbstractController<ManpowerDO> {
    @Override
    public Result add(ManpowerDO manpowerDO) {
        return null;
    }

    @Override
    public Result delete(ManpowerDO manpowerDO) {
        return null;
    }

    @Override
    public Result update(ManpowerDO manpowerDO) {
        return null;
    }

    @Override
    public Result search(ManpowerDO manpowerDO) {
        return null;
    }

    @Override
    public Result list(ManpowerDO manpowerDO) {
        return null;
    }
}
