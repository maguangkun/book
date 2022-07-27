package com.mgk.designmode.observe;

public class Test {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        Demo1Observer demo1Observer =new Demo1Observer(concreteSubject);
        VIewObserver vIewObserver =new VIewObserver(concreteSubject);
        concreteSubject.SenMeasurements(1,2,3);
        concreteSubject.SenMeasurements(4,5,6);
    }
}
