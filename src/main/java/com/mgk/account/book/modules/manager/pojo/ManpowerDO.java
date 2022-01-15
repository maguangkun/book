package com.mgk.account.book.modules.manager.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mgk.account.book.modules.base.pojo.AbstractBaseDO;

import java.lang.ref.PhantomReference;

/**
 * 人工成本
 */
@TableName("T_Manpower")
public class ManpowerDO extends AbstractBaseDO {
    private Long vegetableCycleId;//蔬菜周期Id
    private String name;//人员名称
    private String remark;//备注
    private Double price;//单价
    private Double total;//总价

    public Long getVegetableCycleId() {
        return vegetableCycleId;
    }

    public void setVegetableCycleId(Long vegetableCycleId) {
        this.vegetableCycleId = vegetableCycleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
