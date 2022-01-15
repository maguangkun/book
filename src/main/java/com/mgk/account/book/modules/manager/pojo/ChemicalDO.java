package com.mgk.account.book.modules.manager.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mgk.account.book.modules.base.pojo.AbstractBaseDO;

/**
 * 化肥或者农药厂商信息以及数量价格名称详细信息
 */
@TableName("T_Chemical")
public class ChemicalDO  extends AbstractBaseDO{
    private Long pesticideId;
    private String name;
    private String source;//来源
    private Double price;//价格
    private Double total;//总价
    private Integer number;//数量
    private Integer capacity;//容量 //毫升
    private Integer capacity1;//容量//斤
    private String remark;//备注

    public Long getPesticideId() {
        return pesticideId;
    }

    public void setPesticideId(Long pesticideId) {
        this.pesticideId = pesticideId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCapacity1() {
        return capacity1;
    }

    public void setCapacity1(Integer capacity1) {
        this.capacity1 = capacity1;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
