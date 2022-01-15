package com.mgk.account.book.modules.manager.service.impl;

import com.mgk.account.book.modules.manager.service.AnimalInterface;
import org.springframework.stereotype.Service;

@Service("PigInterfaceImpl")
public class PigInterfaceImpl implements AnimalInterface {
    @Override
    public void a() {
        System.out.println("Pig a");
    }
    public void b() {
        System.out.println("Pig b");
    }
}
