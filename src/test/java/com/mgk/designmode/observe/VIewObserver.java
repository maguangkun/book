package com.mgk.designmode.observe;

public class VIewObserver implements Observer,DisplayElement {
    private int wendu;
    private int shidu;
    private int tianqi;

    public VIewObserver(Subject subject) {
        subject.registerObserve(this);
    }

    @Override
    public void display() {

        System.out.println(String.format("适度hh：%d 温度hh：%d 天气hh：%d",shidu,wendu,tianqi));
    }

    @Override
    public void update(int shidu, int wendu, int tianqi) {
        this.shidu=shidu;
        this.wendu=wendu;
        this.tianqi=tianqi;
        display();
    }
}
