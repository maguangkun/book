package com.mgk.designmode.factory;

public class GuanZhuangCaiDou extends Botany {
    public GuanZhuangCaiDou() {
        name="菜豆";
    }

    @Override
    public void fruit() {
        System.out.println("贯庄菜豆");
    }
}
