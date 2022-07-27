package com.mgk.designmode.factory;

public class GuangZhuangMoGu extends Botany {
    public GuangZhuangMoGu() {
        name="蘑菇";
    }

    @Override
    public void fruit() {
        System.out.println("贯庄蘑菇");
    }
}
