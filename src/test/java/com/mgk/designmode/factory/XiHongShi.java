package com.mgk.designmode.factory;

public class XiHongShi extends Botany {
    public XiHongShi() {
        name="西红柿";
    }

    @Override
    public void fruit() {
        System.out.println("红色甜甜的西红柿");
    }
}
