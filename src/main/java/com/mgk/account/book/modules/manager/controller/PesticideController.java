package com.mgk.account.book.modules.manager.controller;

import com.mgk.account.book.common.utils.Result;
import com.mgk.account.book.modules.base.pojo.AbstractController;
import com.mgk.account.book.modules.manager.pojo.ChemicalDO;
import com.mgk.account.book.modules.manager.pojo.PesticideDO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager/PesticideController")
public class PesticideController extends AbstractController<PesticideDO> {

    @Override
    public Result add(PesticideDO pesticideDO) {
        return null;
    }

    @Override
    public Result delete(PesticideDO pesticideDO) {
        return null;
    }

    @Override
    public Result update(PesticideDO pesticideDO) {
        return null;
    }

    @Override
    public Result search(PesticideDO pesticideDO) {
        return null;
    }

    @Override
    public Result list(PesticideDO pesticideDO) {
        return null;
    }
}
