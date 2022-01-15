package com.mgk.account.book.modules.manager.controller;

import com.mgk.account.book.common.utils.Result;
import com.mgk.account.book.modules.base.pojo.AbstractController;
import com.mgk.account.book.modules.manager.pojo.ChemicalDO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager/ChemicalController")
public class ChemicalController extends AbstractController<ChemicalDO> {
    @Override
    public Result add(ChemicalDO chemicalDO) {
        return null;
    }

    @Override
    public Result delete(ChemicalDO chemicalDO) {
        return null;
    }

    @Override
    public Result update(ChemicalDO chemicalDO) {
        return null;
    }

    @Override
    public Result search(ChemicalDO chemicalDO) {
        return null;
    }

    @Override
    public Result list(ChemicalDO chemicalDO) {
        return null;
    }
}
