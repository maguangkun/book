package com.mgk.designmode.factory;

public class LuoShengFactory extends ChouXiangFactory {
    @Override
    public Botany getFactory(String type) {
        Botany botany=null;
        switch (type){
            case "mogu":
                botany=new LuoShengMoGu();
                break;
            case "caidou":
                botany=new LuoShengCaiDou();
                break;
        }
        return botany;
    }
}
