package com.mgk.account.book.modules.manager.controller;

import com.mgk.account.book.common.utils.Result;
import com.mgk.account.book.modules.base.pojo.AbstractController;
import com.mgk.account.book.modules.manager.pojo.MarginDO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager/MarginController")
public class MarginController extends AbstractController<MarginDO> {
    @Override
    public Result add(MarginDO marginDO) {
        return null;
    }

    @Override
    public Result delete(MarginDO marginDO) {
        return null;
    }

    @Override
    public Result update(MarginDO marginDO) {
        return null;
    }

    @Override
    public Result search(MarginDO marginDO) {
        return null;
    }

    @Override
    public Result list(MarginDO marginDO) {
        return null;
    }
}
