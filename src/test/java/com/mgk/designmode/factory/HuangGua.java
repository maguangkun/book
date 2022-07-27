package com.mgk.designmode.factory;

public class HuangGua extends Botany {
    public HuangGua() {
        name="黄瓜";
    }

    @Override
    public void fruit() {
        System.out.println("长条带刺的绿色瓜");
    }
}
