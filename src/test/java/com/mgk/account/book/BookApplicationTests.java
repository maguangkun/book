package com.mgk.account.book;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mgk.account.book.common.utils.HttpClientUtil;
import com.mgk.account.book.common.utils.WeatherUtil;
import com.mgk.account.book.modules.manager.pojo.WeatherDO;
import com.mgk.account.book.modules.manager.service.WeatherService;
import com.mgk.account.book.modules.user.service.SysUserService;
import com.mgk.account.book.modules.vegetables.entity.Vegetables;
import com.mgk.account.book.modules.vegetables.service.VegetablesService;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class BookApplicationTests {

    @Autowired(required=true)
    SysUserService SysUserServiceImpl;
    @Autowired(required=true)
    VegetablesService vegetablesService;
    @Autowired
    private HttpClientUtil httpClientUtil;
    @Autowired
    WeatherService WeatherServiceImpl;
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
    private static String TTT="2022-03-15";
    private static String str ="韭菜1.8一1.95\n" +
            "香菜1.7一1.85\n" +
            "茴香1.8一2.1\n" +
            "香菜1.6一2\n" +
            "芹菜1一1.6\n" +
            "菠菜1一1.2\n" +
            "油麦1.2一1.8\n" +
            "生菜1.3一1.6\n" +
            "羊角葱1一1.5\n" +
            "小葱1.5一1.9\n" +
            "大葱3一3.6\n" +
            "尖椒4.6一5\n" +
            "甘蓝0.6一0.8\n" +
            "茼蒿1一1.6\n" +
            "普罗旺斯西红柿4.5一4.7\n" +
            "西红柿2一2.9\n" +
            "白萝卜0.6一0.8\n" +
            "红萝卜1一1.3\n" +
            "圆椒2一2.6\n" +
            "圆茄子2.6一2.9\n" +
            "娃娃菜1一1.3\n" +
            "紫皮葱头0.7一0.85\n" +
            "蘑菇2.8一3\n" +
            "小白菜1一1.3\n" +
            "小油菜1.6一2\n" +
            "红皮土豆0.7一0.8\n" +
            "土豆0.6一0.65";
//    @Test
    void SaveVegetables() {
        List<Vegetables> vegetables = dealVegStr();
        for (Vegetables v:vegetables) {
            vegetablesService.save(v);
        }
    }

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

    @Test
    public void addWeather() throws ParseException {
        SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2016-10-11");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        while (true)
        {
            date=calendar.getTime();
            String format = sdf.format(date);
            if (format.equals("2022-08-11")){
                break;
            }
            System.out.println("当前日期："+format);
            String json = httpClientUtil.get("https://api.binstd.com/weather2/query?appkey=b7656633b2c60ec1&city=石家庄&date="+format);
            System.out.println(json);
            WeatherDO result = JSONObject.parseObject(json).getObject("result", WeatherDO.class);
            result.setCreateTime(LocalDateTime.now());
            WeatherServiceImpl.save(result);
            calendar.add(Calendar.DATE, 1);
        }
    }

    @Test
    public void getWeatherList() throws ParseException {
        List<WeatherDO> list = WeatherServiceImpl.list();
        for (WeatherDO WeatherDO :list) {
            WeatherDO.setWindpower(WeatherDO.getWindpower().replace("级",""));
            WeatherDO.setWeatherCode(WeatherUtil.GetWeather(WeatherDO.getWeather()));
            WeatherDO.setDateCode(WeatherDO.getDate().replace("-",""));
            WeatherDO.setWinddiretCode(WeatherUtil.GetWinddirect(WeatherDO.getWinddirect()));
            WeatherServiceImpl.saveOrUpdate(WeatherDO);
        }
    }

    public static void main(String[] args) throws ParseException {
      String date ="2016-11-12";
        byte[] bytes = date.getBytes();
        int[] ints = bytearray2intarray(bytes);
        System.out.println(ints);
    }
    public static int[] bytearray2intarray(byte[] barray)
    {
        int[] iarray = new int[barray.length];
        int i = 0;
        for (byte b : barray)
            iarray[i++] = b & 0xff;
        return iarray;
    }
}
