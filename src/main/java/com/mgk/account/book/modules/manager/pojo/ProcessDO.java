package com.mgk.account.book.modules.manager.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mgk.account.book.modules.base.pojo.AbstractBaseDO;
import io.swagger.annotations.ApiModel;

/**
 * 步骤
 */
@TableName("T_Process")
@ApiModel(value="蔬菜管理流程表", description="蔬菜管理流程表")
public class ProcessDO extends AbstractBaseDO {
    private Long vegetableCycleId;//蔬菜周期Id
    private String operationType;//操作
    private String weather;//天气
    private Integer temperature;//温度
    private String remark;//备注

    public Long getVegetableCycleId() {
        return vegetableCycleId;
    }

    public void setVegetableCycleId(Long vegetableCycleId) {
        this.vegetableCycleId = vegetableCycleId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
