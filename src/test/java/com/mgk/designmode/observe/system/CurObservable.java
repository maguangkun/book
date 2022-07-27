package com.mgk.designmode.observe.system;

import java.util.Observable;
import java.util.Vector;

public class CurObservable extends Observable {
    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }
}
