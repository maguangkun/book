package com.mgk.designmode.decorate;

import com.mgk.designmode.decorate.*;

public class Test {
    public static void main(String[] args) {
//        tea();
//        coffee();
        //果冻+牛奶+焦糖咖啡
        milkJellyDarkRoast();
    }
    private  static void tea(){
        Beverage beverage = new Tea();
        System.out.println(beverage.cost());
        System.out.println(beverage.getDescription());
    }
    private static void coffee(){
        Beverage beverage = new Coffee();
        System.out.println(beverage.cost());
        System.out.println(beverage.getDescription());
    }
    private static void milkJellyDarkRoast(){
        Beverage beverage = new DarkRoast();
        Decorate milk = new Milk(beverage);
        Decorate jelly = new Jelly(milk);
        System.out.println(jelly.cost());
        System.out.println(jelly.getDescription());
    }
}
