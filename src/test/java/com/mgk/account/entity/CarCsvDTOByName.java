package com.mgk.account.entity;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
//菜品,最低价,平均价,最高价格,规格,单位,发布日期
@Data
public class CarCsvDTOByName {
    @CsvBindByPosition(position = 0)
    private String vegetableName;//菜名

    @CsvBindByPosition(position = 1)
    private String lowPrice;

    @CsvBindByPosition(position = 2)
    private String avePrice;

    @CsvBindByPosition(position = 3)
    private String heightPrice;

    @CsvBindByPosition(position = 4)
    private String specification;

    @CsvBindByPosition(position = 5)
    private String unit;

    @CsvBindByPosition(position = 6)
    private String createTime;//创建日期
}