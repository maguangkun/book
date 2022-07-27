package com.mgk.designmode.factory;

public class BotanyTest {
    public static void main(String[] args) {
        //SimpleFactory.GetBotany 简单工厂
        Botany botany = SimpleFactory.GetBotany("huanggua");//new HuangGua();
        botany.fruit();
        botany =SimpleFactory.GetBotany("xihongshi");//new XiHongShi();
        botany.fruit();


        //抽象工厂
        ChouXiangFactory chouXiangFactory = new GuanZhuangFactory();
        chouXiangFactory.fruit("mogu");
        chouXiangFactory.fruit("caidou");
        chouXiangFactory = new LuoShengFactory() ;
        chouXiangFactory.fruit("mogu");
        chouXiangFactory.fruit("caidou");


    }
}
