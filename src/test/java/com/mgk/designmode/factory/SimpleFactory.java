package com.mgk.designmode.factory;

public class SimpleFactory {
    public static Botany GetBotany(String type){
        Botany botany=null;
        switch (type){
            case "huanggua":
                botany=new HuangGua();
                break;
            case "xihongshi":
                botany=new XiHongShi();
                break;
        }
        return botany;
    }
}
