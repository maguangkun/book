package com.mgk.designmode.factory;

public class GuanZhuangFactory extends ChouXiangFactory {
    @Override
    public Botany getFactory(String type) {
        Botany botany=null;
        switch (type){
            case "mogu":
                botany=new GuangZhuangMoGu();
                break;
            case "caidou":
                botany=new GuanZhuangCaiDou();
                break;
        }
        return botany;
    }
}
