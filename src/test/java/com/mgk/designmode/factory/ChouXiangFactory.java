package com.mgk.designmode.factory;

public abstract class ChouXiangFactory {

    public final void fruit(String type){
        Botany botany = null;
        botany= getFactory(type);
        botany.fruit();
    }

    abstract Botany getFactory(String type);
}
