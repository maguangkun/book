package com.mgk.account.book.modules.manager.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author 马广坤
 * @since 2021-10-09
 */
@TableName("vegetableproject")
@ApiModel(value="Vegetableproject对象", description="")
public class Vegetableproject implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;//蔬菜名称

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("createTime")
    private LocalDateTime createTime;//蔬菜项目创建时间

    @TableField("deleteTime")
    private LocalDateTime deleteTime;

    @TableField("createDate")
    private LocalDateTime createDate;//项目系统创建时间

    @TableField("deleteDate")
    private LocalDateTime deleteDate;

    private String variety;//蔬菜品种

    @TableField("varietySource")
    private String varietySource;//蔬菜品种商，在谁家买的

    @TableField("plantingWay")
    private String plantingWay;//种植方式

    @TableField("plantingRegion")
    private String plantingRegion;//种植区域

    private String weather;//天气

    private String temperature;//温度

    @TableField("userId")
    private Long userId;//用户

    private Integer acres;//种植亩数量

    private String space;//间距

    @TableField("seedWeight")
    private String seedWeight;//种子重量

    private String remark;//备注描述


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(LocalDateTime deleteTime) {
        this.deleteTime = deleteTime;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(LocalDateTime deleteDate) {
        this.deleteDate = deleteDate;
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

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
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

    @Override
    public String toString() {
        return "Vegetableproject{" +
        "id=" + id +
        ", name=" + name +
        ", createTime=" + createTime +
        ", deleteTime=" + deleteTime +
        ", createDate=" + createDate +
        ", deleteDate=" + deleteDate +
        ", variety=" + variety +
        ", varietySource=" + varietySource +
        ", plantingWay=" + plantingWay +
        ", plantingRegion=" + plantingRegion +
        ", weather=" + weather +
        ", temperature=" + temperature +
        ", userId=" + userId +
        ", acres=" + acres +
        ", space=" + space +
        ", seedWeight=" + seedWeight +
        ", remark=" + remark +
        "}";
    }
}
