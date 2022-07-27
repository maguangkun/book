package com.mgk.designmode.factory;

public class LuoShengMoGu extends Botany {
    public LuoShengMoGu() {
        name="蘑菇";
    }

    @Override
    public void fruit() {
        System.out.println("落生蘑菇");
    }
}
