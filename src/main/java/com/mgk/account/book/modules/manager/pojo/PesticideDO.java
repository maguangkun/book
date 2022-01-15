package com.mgk.account.book.modules.manager.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mgk.account.book.modules.base.pojo.AbstractBaseDO;
import io.swagger.annotations.ApiModel;

/**
 * 化肥农药
 */
@TableName("T_Pesticide")
@ApiModel(value="化肥农药信息", description="化肥农药信息表")
public class PesticideDO extends AbstractBaseDO {
    private Long vegetableCycleId;//蔬菜周期Id
    private String area ;//土地面积
    private String remark;//备注
    private String weather;//天气
    private Integer temperature;//温度
    private String disease;//病害

    public Long getVegetableCycleId() {
        return vegetableCycleId;
    }

    public void setVegetableCycleId(Long vegetableCycleId) {
        this.vegetableCycleId = vegetableCycleId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
