package com.mgk.account.book.modules.manager.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mgk.account.book.modules.base.pojo.AbstractBaseDO;
import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 蔬菜周期表
 */
@TableName("T_VEGETABLECYCLE")
@ApiModel(value="蔬菜周期表", description="蔬菜周期表")
public class VegetableCycleDO extends AbstractBaseDO {

    private String name;//蔬菜名称

    private String variety;//蔬菜品种

    @TableField("varietySource")
    private String varietySource;//蔬菜品种商，在谁家买的

    @TableField("plantingWay")
    private String plantingWay;//种植方式

    @TableField("plantingRegion")
    private String plantingRegion;//种植区域

    private String weather;//天气

    private Integer temperature;//温度

    @TableField("userId")
    private Long userId;//用户

    private Integer acres;//种植亩数量

    private String space;//间距

    @TableField("seedWeight")
    private String seedWeight;//种子重量

    private String remark;//备注描述

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getVarietySource() {
        return varietySource;
    }

    public void setVarietySource(String varietySource) {
        this.varietySource = varietySource;
    }

    public String getPlantingWay() {
        return plantingWay;
    }

    public void setPlantingWay(String plantingWay) {
        this.plantingWay = plantingWay;
    }

    public String getPlantingRegion() {
        return plantingRegion;
    }

    public void setPlantingRegion(String plantingRegion) {
        this.plantingRegion = plantingRegion;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAcres() {
        return acres;
    }

    public void setAcres(Integer acres) {
        this.acres = acres;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public String getSeedWeight() {
        return seedWeight;
    }

    public void setSeedWeight(String seedWeight) {
        this.seedWeight = seedWeight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}