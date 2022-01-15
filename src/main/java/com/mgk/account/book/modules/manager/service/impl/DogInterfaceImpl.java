package com.mgk.account.book.modules.manager.service.impl;

import com.mgk.account.book.modules.manager.service.AnimalInterface;
import org.springframework.stereotype.Service;

@Service("DogInterfaceImpl")
public class DogInterfaceImpl implements AnimalInterface {
    @Override
    public void a() {
        System.out.println("Dog a");
    }
    public void b() {
        System.out.println("Dog b");
    }
}
