package com.mgk.account.book;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mgk.account.book.modules.user.service.SysUserService;
import com.mgk.account.book.modules.vegetables.entity.Vegetables;
import com.mgk.account.book.modules.vegetables.service.VegetablesService;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class BookApplicationTests {

    @Autowired(required=true)
    SysUserService SysUserServiceImpl;
    @Autowired(required=true)
    VegetablesService vegetablesService;
//    @Test
//    void SaveUser() {
//        SysUserEntity sysUserEntity = new SysUserEntity();
//        sysUserEntity.setUsername("mgk");
//        sysUserEntity.setPassword("123456");
//        sysUserEntity.setEmail("446690606@qq.com");
//        sysUserEntity.setCreateTime(new Date());
//        sysUserEntity.setStatus(0);
//        sysUserEntity.setMobile("13321181799");
//        SysUserServiceImpl.save(sysUserEntity);
//    }
    private static String TTT="2021-11-18";
    private static String str ="大白菜毛菜0.5一0.8\n" +
            "净菜0.7一1\n" +
            "菠菜1.8一2.3\n" +
            "香菜2.5一4\n" +
            "茴香2一3\n" +
            "韭菜2一3.2\n" +
            "小白菜0.5一0.7\n" +
            "小油菜0.8一1.2\n" +
            "大葱1.5一2.2\n" +
            "小葱2.8一5\n" +
            "茄子2一2.5\n" +
            "黄瓜2一2.3\n" +
            "芹菜1.6一2\n" +
            "散花3一5\n" +
            "甘蓝1.6一2\n" +
            "白萝卜0.6一0.7\n" +
            "西红柿1.6一2\n" +
            "小冬瓜0.3一0.45\n" +
            "大冬瓜0.3一0.35\n" +
            "小吊瓜0.3一0.5\n" +
            "干瓜0.5一0.6\n" +
            "尖椒1.4一1.7\n" +
            "红线椒1.2一2\n" +
            "线椒1.4一1.6\n" +
            "芸豆1.6一2\n" +
            "白不老2一3.2\n" +
            "彩椒1.6一2\n" +
            "圆椒1.8一3.1\n" +
            "生菜0.8一1\n" +
            "油麦1.8一2.45\n" +
            "土豆0.5一0.9\n" +
            "红薯0.6一0.7\n" +
            "西瓜红薯1一1.2\n" +
            "花生3.8一4.1";
    @Test
    void SaveVegetables() {
        List<Vegetables> vegetables = dealVegStr();
        for (Vegetables v:vegetables) {
            vegetablesService.save(v);
        }
    }
//    @Test
//    void  GetVegetableMonth(){
//        List<Vegetables> vegetablesList = vegetablesService.list(new LambdaQueryWrapper<Vegetables>()
//                .groupBy(Vegetables::getCreateTime)
//                .select(Vegetables::getCreateTime));
//        StringBuilder sbf= new StringBuilder();
//        sbf.append("[");
//        for (Vegetables vegetables:vegetablesList) {
//            sbf.append(String.format("\"%s\"",vegetables.getCreateTime()));
//            sbf.append(",");
//        }
//        sbf.append("]");
//        System.out.println(sbf.toString());
//    }
//    @Test
//    void  GetVegetablePric(){
//        QueryWrapper<Vegetables> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("name","甘蓝");
//        List<Vegetables> vegetablesList = vegetablesService.list(queryWrapper);
//        StringBuilder sbf= new StringBuilder();
//        sbf.append("[");
//        for (Vegetables vegetables:vegetablesList) {
//            sbf.append(String.format("%s",vegetables.getAve()));
//            sbf.append(",");
//        }
//        sbf.append("]");
//        System.out.println(sbf.toString());
//        sbf= new StringBuilder();
//        sbf.append("[");
//        for (Vegetables vegetables:vegetablesList) {
//            sbf.append(String.format("\"%s\"",vegetables.getCreateTime()));
//            sbf.append(",");
//        }
//        sbf.append("]");
//        System.out.println(sbf.toString());
//    }

    public static List<Vegetables> dealVegStr(){
        List<Vegetables> list = new ArrayList<Vegetables>();

        String[] split = str.split("\n");
        for (String str : split) {
            Vegetables vegetables = new Vegetables();
            String regex="([\u4e00-\u9fa5]+)";
            Matcher matcher = Pattern.compile(regex).matcher(str);
            if(matcher.find()){
                System.out.println(matcher.group(0));
            }
            vegetables.setCreateTime(TTT);
            vegetables.setName(matcher.group(0));
            vegetables.setLow(getPirce(str.replace(matcher.group(0),""))[0]);
            vegetables.setHeight(getPirce(str.replace(matcher.group(0),""))[1]);
            vegetables.setAve(getPirce(str.replace(matcher.group(0),""))[2]);
            vegetables.setRegion("里庄批发市场");

            list.add(vegetables);
        }
        for (Vegetables temp :list) {
            System.out.println(temp.toString());
        }
        return list;
    }
    private static String[] getPirce(String str){
        String arr[]={"","",""};
        if(str.indexOf("-")!= -1){
            String[] split;
            if(str.contains("一")){
                split= str.split("一");
            }else{
                split= str.split("-");
            }

            arr[0]=split[0].trim();
            arr[1]=split[1].trim();
            arr[2]= String.valueOf((Double.valueOf(split[0].trim())+Double.valueOf(split[1].trim()))/2);

        }else if(str.indexOf("一")!= -1){
            String[] split;
            if(str.contains("一")){
                split= str.split("一");
            }else{
                split= str.split("-");
            }

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
