package com.mgk.account.book.modules.manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mgk.account.book.modules.manager.dao.ProcessDao;
import com.mgk.account.book.modules.manager.pojo.ProcessDO;
import com.mgk.account.book.modules.manager.service.ProcessService;
import org.springframework.stereotype.Service;

@Service
public class ProcessServiceImpl extends ServiceImpl<ProcessDao, ProcessDO> implements ProcessService {
}
