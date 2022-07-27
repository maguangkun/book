package com.mgk.account.book;

import cn.hutool.core.util.CharsetUtil;
import com.mgk.account.book.modules.user.service.SysUserService;
import com.mgk.account.book.modules.vegetables.entity.Vegetables;
import com.mgk.account.book.modules.vegetables.service.VegetablesService;
import com.mgk.account.entity.CarCsvDTOByName;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CsvVegetableQiaoxi {
    @Autowired(required=true)
    SysUserService SysUserServiceImpl;
    @Autowired(required=true)
    VegetablesService vegetablesService;

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File("D:\\mgktest\\百度识别图片文字内容\\桥西\\2022-3-30-19-16-15-166520249928999-石家庄桥西蔬菜中心批发市场有限公司-采集-副本的数据-后羿采集器.csv"));
        InputStreamReader inputStream = new InputStreamReader(fileInputStream, CharsetUtil.CHARSET_UTF_8);
        // 设置解析策略，csv的头和POJO属性的名称对应，也可以使用@CsvBindByName注解来指定名称
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(CarCsvDTOByName.class);

        CsvToBean csvToBean = new CsvToBeanBuilder(inputStream)
                .withMappingStrategy(strategy)
                .build();
        List<CarCsvDTOByName> carCsvDTOList = csvToBean.parse();
        for (CarCsvDTOByName carCsvDTOByName : carCsvDTOList) {
            System.out.println(carCsvDTOByName);
        }
    }
    @Test
    void Save() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File("D:\\mgktest\\百度识别图片文字内容\\桥西\\2022-3-30-20-38-19-171443646901000-石家庄桥西蔬菜中心批发市场有限公司-采集-副本的数据-后羿采集器.csv"));
        InputStreamReader inputStream = new InputStreamReader(fileInputStream, CharsetUtil.CHARSET_GBK);
        // 设置解析策略，csv的头和POJO属性的名称对应，也可以使用@CsvBindByName注解来指定名称
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(CarCsvDTOByName.class);

        CsvToBean csvToBean = new CsvToBeanBuilder(inputStream)
                .withMappingStrategy(strategy)
                .build();
        List<CarCsvDTOByName> carCsvDTOList = csvToBean.parse();
        List<Vegetables> vegetables = new ArrayList<>();
        Vegetables vegetables1 = null;
        for (CarCsvDTOByName carCsvDTOByName : carCsvDTOList) {
            if(carCsvDTOByName.getVegetableName().contains("菜品")){
                continue;
            }
            vegetables1 = new Vegetables();
            vegetables1.setName(carCsvDTOByName.getVegetableName());
            vegetables1.setAve((Double.valueOf(carCsvDTOByName.getAvePrice())/2)+"");
            vegetables1.setCreateTime(carCsvDTOByName.getCreateTime().replace(".","-"));
            vegetables1.setHeight((Double.valueOf(carCsvDTOByName.getHeightPrice())/2)+"");
            vegetables1.setLow(((Double.valueOf(carCsvDTOByName.getLowPrice())/2)+""));
            vegetables1.setRegion("石家庄桥西蔬菜中心批发市场");
            vegetables1.setRemark(carCsvDTOByName.toString());
            vegetables1.setSpecification(carCsvDTOByName.getSpecification());
            vegetables1.setUnit(carCsvDTOByName.getUnit());
            vegetables.add(vegetables1);
        }


        for (Vegetables v:vegetables) {
            System.out.println(v.toString());
            vegetablesService.save(v);
//            System.out.println(v.toString());
        }
    }
}
