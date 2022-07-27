package com.mgk.designmode.factory;

public class LuoShengCaiDou extends Botany {
    public LuoShengCaiDou() {
        name="菜豆";
    }

    @Override
    public void fruit() {
        System.out.println("落生菜豆");
    }
}
