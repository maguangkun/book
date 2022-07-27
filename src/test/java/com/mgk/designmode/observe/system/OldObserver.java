package com.mgk.designmode.observe.system;

import java.util.Observable;
import java.util.Observer;

public class OldObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String temp  = (String) arg;
        System.out.println(temp+"old");
    }
}
