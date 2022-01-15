package com.mgk.account.book.modules.vegetables.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mgk.account.book.common.utils.Result;
import com.mgk.account.book.modules.vegetables.entity.Vegetables;
import com.mgk.account.book.modules.vegetables.service.impl.VegetablesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController()
@RequestMapping("VegeController")
public class VegeController{
    @Autowired
    private VegetablesServiceImpl vegetablesService;
    @PostMapping("hello")
    public String hello(String param){
        return String.format("Hello World %s",param);
    }


    @RequestMapping(value = "/AddVegeTablePrice", method = RequestMethod.POST)
    public Result AddVegeTablePrice(@ModelAttribute Vegetables vegetables){


        return Result.ok();
    }


    @PostMapping("getVegeNameList")
    public List getNameList(){
        List<Vegetables> vegetablesList = vegetablesService.list(new LambdaQueryWrapper<Vegetables>()
                .groupBy(Vegetables::getName)
                .select(Vegetables::getName));
        StringBuilder sbf= new StringBuilder();
        System.out.println(sbf.toString());
        return vegetablesList;
    }
    @PostMapping("getVegeRegionList")
    public List getVegeRegionList(){
        List<Vegetables> vegetablesList = vegetablesService.list(new LambdaQueryWrapper<Vegetables>()
                .groupBy(Vegetables::getRegion)
                .select(Vegetables::getRegion));
        StringBuilder sbf= new StringBuilder();
        System.out.println(sbf.toString());
        return vegetablesList;
    }

    @PostMapping("GetVegetableMonth")
    public  List  GetVegetableMonth(String startDate,String endDate,String name,String region){
        List list = new ArrayList();
        QueryWrapper<Vegetables> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("name",name);
        queryWrapper.eq("name",name);
        queryWrapper.eq("region",region);
        queryWrapper.between("createTime",startDate,endDate);
        List<Vegetables> vegetablesList = vegetablesService.list(queryWrapper);
        list.add(AddHeight(vegetablesList));
        list.add(AddAve(vegetablesList));
        list.add(AddLow(vegetablesList));
        list.add(AddCreateTime(vegetablesList));
        return list;
    }
    @PostMapping("SearchDoubleYear")
    public  List  SearchDoubleYear(String startDate,String endDate,String name,String region) throws ParseException {
        List list = new ArrayList();
        //当前年份
        QueryWrapper<Vegetables> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        queryWrapper.eq("region",region);
        queryWrapper.between("createTime",startDate,endDate);
        List<Vegetables> vegetablesList = vegetablesService.list(queryWrapper);
        list.add(AddLow(vegetablesList));
        list.add(AddCreateTime(vegetablesList));
        //去年数据
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        queryWrapper.eq("region",region);
        queryWrapper.between("createTime",getOldYear(startDate),getOldYear(endDate));
        vegetablesList = vegetablesService.list(queryWrapper);
        list.add(AddLow(vegetablesList));
        list.add(AddCreateTime(vegetablesList));
        return list;
    }
    private String getOldYear(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(date);
        int i = parse.getYear()+1900;
        return date.replace(""+i,(i-1)+"");
    }
    private String AddCreateTime(List<Vegetables> vegetablesList){
        StringBuilder sbf = new StringBuilder();
        sbf.append("[");
        for (Vegetables vegetables:vegetablesList) {
            sbf.append(vegetables.getCreateTime());
            sbf.append(",");
        }
        if (sbf.lastIndexOf(",")!=-1){
            sbf= sbf.deleteCharAt(sbf.lastIndexOf(","));
        }
        sbf.append("]");
        return sbf.toString();
    }
    private String AddLow(List<Vegetables> vegetablesList){
        StringBuilder sbf = new StringBuilder();
        sbf.append("[");
        for (Vegetables vegetables:vegetablesList) {
            sbf.append(vegetables.getLow());
            sbf.append(",");
        }
        if (sbf.lastIndexOf(",")!=-1){
            sbf= sbf.deleteCharAt(sbf.lastIndexOf(","));
        }
        sbf.append("]");
        return sbf.toString();
    }
    private String AddHeight(List<Vegetables> vegetablesList){
        StringBuilder sbf = new StringBuilder();
        sbf.append("[");
        for (Vegetables vegetables:vegetablesList) {
            sbf.append(vegetables.getHeight());
            sbf.append(",");
        }
        if (sbf.lastIndexOf(",")!=-1){
            sbf= sbf.deleteCharAt(sbf.lastIndexOf(","));
        }
        sbf.append("]");
        return sbf.toString();
    }
    private String AddAve(List<Vegetables> vegetablesList){
        StringBuilder sbf = new StringBuilder();
        sbf.append("[");
        for (Vegetables vegetables:vegetablesList) {
            sbf.append(vegetables.getAve());
            sbf.append(",");
        }
        if (sbf.lastIndexOf(",")!=-1){
            sbf= sbf.deleteCharAt(sbf.lastIndexOf(","));
        }
        sbf.append("]");
        return sbf.toString();
    }
}
