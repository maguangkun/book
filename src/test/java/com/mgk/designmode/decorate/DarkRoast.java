package com.mgk.designmode.decorate;

public class DarkRoast extends Beverage{
    public DarkRoast() {
               description="焦糖咖啡";
    }
    @Override
    public Double cost() {
        return Double.valueOf(15);
    }




}
