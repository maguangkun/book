package com.mgk.designmode.decorate;

/**
 * 饮料类
 */
public abstract class Beverage {
    //描述饮料
    String description="Unknown Beverage";

    public String getDescription() {
        return description;
    }

    //返回价格
    public abstract Double cost();
}
