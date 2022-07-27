package com.mgk.designmode.decorate;

public class Coffee extends Beverage{
    public Coffee() {
               description="红太阳咖啡、种子采用长白山种植产地";
    }

    @Override
    public Double cost() {
        return Double.valueOf(15);
    }
}
