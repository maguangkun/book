package com.mgk.account.book.modules.manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mgk.account.book.modules.manager.dao.ChemicalDao;
import com.mgk.account.book.modules.manager.dao.ManpowerDao;
import com.mgk.account.book.modules.manager.pojo.ChemicalDO;
import com.mgk.account.book.modules.manager.pojo.ManpowerDO;
import com.mgk.account.book.modules.manager.service.ChemicalService;
import com.mgk.account.book.modules.manager.service.ManpowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChemicalServiceImpl extends ServiceImpl<ChemicalDao, ChemicalDO> implements ChemicalService {
}
