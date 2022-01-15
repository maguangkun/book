package com.mgk.account.book;

import com.mgk.account.book.modules.user.service.SysUserService;
import com.mgk.account.book.modules.vegetables.entity.Vegetables;
import com.mgk.account.book.modules.vegetables.service.VegetablesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
public class LuoShengShuCaiJiDi {
    @Autowired(required=true)
    SysUserService SysUserServiceImpl;
    @Autowired(required=true)
    VegetablesService vegetablesService;
    @Test
    void SaveVegetables() {
        String [] strs ={"2021-09-22","2021-09-23","2021-09-24","2021-09-25","2021-09-26"};
        for (String str :strs) {
            Vegetables vegetables = new Vegetables();
            vegetables.setCreateTime(str);
            vegetables.setName("小白菜");
            vegetables.setLow(getPirce("1-1.4")[0]);//最低价
            vegetables.setHeight(getPirce("1-1.4")[1]);//最高价
            vegetables.setAve(getPirce("1-1.4")[2]);//平均价
            vegetables.setRegion("落生批发市场");
            vegetablesService.save(vegetables);
        }
    }
    private static String[] getPirce(String str){
        String arr[]={"","",""};
        if(str.indexOf("-")!= -1){
            String[] split = str.split("-");
            arr[0]=split[0].trim();
            arr[1]=split[1].trim();
            arr[2]= String.valueOf((Double.valueOf(split[0].trim())+Double.valueOf(split[1].trim()))/2);
        }else {
            arr[0]=str.trim();
            arr[1]=str.trim();
            arr[2]=str.trim();
        }
        return arr;
    }
}
