package com.mgk.account.book;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mgk.account.book.common.utils.BaiDuPictureUtil.GeneralBasic;
import com.mgk.account.book.modules.user.service.SysUserService;
import com.mgk.account.book.modules.vegetables.entity.Vegetables;
import com.mgk.account.book.modules.vegetables.service.VegetablesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
public class ShanDongShouGuang {

    @Autowired(required=true)
    SysUserService SysUserServiceImpl;
    @Autowired(required=true)
    VegetablesService vegetablesService;
    private static String TTT="2017-08-23";
    private static String FILEPATH="D:\\mgktest\\百度识别图片文字内容\\2018年数据\\一月份\\";//20170823.png
    //今夜到明天阴有小到中雨并伴有雷电，偏东风3-4级，雷雨地区雷雨时阵风6-7级，23-29
    private static String WEATHER="阴有中雨局部暴雨并伴有雷电，南风转北风3-4级雷雨时阵风6-7级，25到28度";
    //日期数组
    String [] dateArr = {"2017-08-31"};
    //图片数组
    String [] pictureArr = {"20170901"};

    @Test
    void    SaveVegetables() throws ParseException {
        File file = new File(FILEPATH);
        String[] list = file.list();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        for (String arr : list) {
            if(!arr.contains("png")){
                continue;
            }
            Date parse = simpleDateFormat.parse(arr.replace(".png", ""));
            SimpleDateFormat ccc = new SimpleDateFormat("yyyy-MM-dd");
            String format = ccc.format(parse);
            List<Vegetables> vegetables = dealVegStr(getBody(arr),format);
            for (Vegetables v:vegetables) {
//                vegetablesSe          rvice.save(v);
            }
        }
        /**
         *单独加载
         */

//            List<Vegetables> vegetables = dealVegStr(getBody("20171211.png"),"2017-12-11");
//            for (Vegetables v:vegetables) {
////                vegetablesService.save(v);
//            }



//        for (int i = 0; i < pictureArr.length; i++) {
//            List<Vegetables> vegetables = dealVegStr(getBody(pictureArr[i]),dateArr[i]);
//            for (Vegetables v:vegetables) {
//                vegetablesService.save(v);
//            }
//        }

//        for (String image: pictureArr) {
//
//        }

    }
    private static JSONArray getBody(String image){
        String s = GeneralBasic.generalBasic(FILEPATH+image,"1");
        JSONObject jsonObject = JSONObject.parseObject(s);
        JSONArray forms_result = (JSONArray)jsonObject.get("forms_result");
        jsonObject = (JSONObject) forms_result.get(0);
        System.out.println("Body数据"+jsonObject.get("body"));
        return (JSONArray)jsonObject.get("body");
    }
    public static List<Vegetables> dealVegStr(JSONArray body,String date){
        Iterator<Object> iterator = body.iterator();
        List<Vegetables> list = new ArrayList<Vegetables>();
        String name="";
        while (iterator.hasNext()){

            JSONObject next = (JSONObject)iterator.next();
            if(next.getInteger("column")==0){
                name = (String)next.get("words");
            }else if(next.getInteger("column")==1){
                Vegetables vegetables = new Vegetables();
                String words = (String)next.get("words");
                vegetables.setCreateTime(date);//TTT
                vegetables.setName(name);
                vegetables.setLow(getPirce(words)[0]);
                vegetables.setHeight(getPirce(words)[1]);
                vegetables.setAve(getPirce(words)[2]);
                vegetables.setRegion("山东寿光");
//                vegetables.setWeather(WEATHER);
                list.add(vegetables);

            }

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

        }else {
            arr[0]=str.trim();
            arr[1]=str.trim();
            arr[2]=str.trim();
        }
        return arr;
    }
}
