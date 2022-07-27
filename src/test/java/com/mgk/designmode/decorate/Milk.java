package com.mgk.designmode.decorate;

public class Milk extends Decorate{
    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public Double cost() {
        return Double.valueOf(1)+beverage.cost();
    }

    @Override
    public String getDescription() {
        return "牛奶"+beverage.getDescription();
    }
}
