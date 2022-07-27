package com.mgk.designmode.observe;

public class Demo1Observer implements Observer,DisplayElement {
    private int wendu;
    private int shidu;
    private int tianqi;

    public Demo1Observer(Subject subject) {
        subject.registerObserve(this);
    }

    @Override
    public void display() {

        System.out.println(String.format("适度：%d 温度：%d 天气：%d",shidu,wendu,tianqi));
    }

    @Override
    public void update(int shidu, int wendu, int tianqi) {
        this.shidu=shidu;
        this.wendu=wendu;
        this.tianqi=tianqi;
        display();
    }
}
