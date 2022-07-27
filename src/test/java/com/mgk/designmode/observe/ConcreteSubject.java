package com.mgk.designmode.observe;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject{
    private int wendu;
    private int shidu;
    private int tianqi;
    private ArrayList list = new ArrayList<Observer>();

    @Override
    public void registerObserve(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserve(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObserve() {
        for (int i = 0; i < list.size(); i++) {
            Observer o = (Observer)list.get(i);
            o.update(wendu,shidu,tianqi);
        }
    }
    public void SenMeasurements(int wendu,int shidu ,int tianqi){
        this.shidu=shidu;
        this.wendu=wendu;
        this.tianqi=tianqi;
        notifyObserve();
    }
}
