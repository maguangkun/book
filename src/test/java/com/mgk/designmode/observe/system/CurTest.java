package com.mgk.designmode.observe.system;

import java.util.Observable;

public class CurTest {

    public static void main(String[] args) {
        CurObservable curObservable = new CurObservable();
        CurObserver curObserver = new CurObserver();
        OldObserver oldObserver = new OldObserver();
        curObservable.addObserver(curObserver);
        curObservable.addObserver(oldObserver);
        curObservable.setChanged();
        curObservable.notifyObservers("456");
    }
}
