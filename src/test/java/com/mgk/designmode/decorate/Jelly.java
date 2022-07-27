package com.mgk.designmode.decorate;

public class Jelly extends Decorate{
    public Jelly(Beverage beverage) {
        this.beverage = beverage;
    }
    private Beverage beverage;
    @Override
    public Double cost() {
        return Double.valueOf(2)+beverage.cost();
    }

    @Override
    public String getDescription() {
        return "果冻"+beverage.getDescription();
    }
}
