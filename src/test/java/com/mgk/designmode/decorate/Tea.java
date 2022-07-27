package com.mgk.designmode.decorate;

public class Tea extends Beverage{
    public Tea() {
               description="真龙牌绿茶，采用山泉水炮制而成";
    }
    @Override
    public Double cost() {
        return Double.valueOf(12);
    }
}
