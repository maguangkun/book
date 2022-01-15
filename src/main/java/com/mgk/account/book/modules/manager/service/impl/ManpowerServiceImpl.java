package com.mgk.account.book.modules.manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mgk.account.book.modules.manager.dao.ManpowerDao;
import com.mgk.account.book.modules.manager.pojo.ManpowerDO;
import com.mgk.account.book.modules.manager.service.ManpowerService;
import org.springframework.stereotype.Service;

@Service
public class ManpowerServiceImpl extends ServiceImpl<ManpowerDao, ManpowerDO> implements ManpowerService {
}
