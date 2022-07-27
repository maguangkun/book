package com.mgk.account.book.modules.vegetables.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
@Data
@TableName("vegetablespricestats")//蔬菜价格统计表
public class Vegetables {
       @TableId
       private Long vegtablesId;
       private String name;//蔬菜名称
       private String low;//低
       private String height;//高
       private String ave;//均价
       private String region;//里庄
       private String createTime;
       private String user;
       private String weather;
       private String remark;//备注
        private String specification;//品质
        private String unit;//单位

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "Vegetables{" +
                "vegtablesId=" + vegtablesId +
                ", name='" + name + '\'' +
                ", low='" + low + '\'' +
                ", height='" + height + '\'' +
                ", ave='" + ave + '\'' +
                ", region='" + region + '\'' +
                ", createTime='" + createTime + '\'' +
                ", user='" + user + '\'' +
                ", weather='" + weather + '\'' +
                ", remark='" + remark + '\'' +
                ", specification='" + specification + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }

    public Long getVegtablesId() {
        return vegtablesId;
    }

    public void setVegtablesId(Long vegtablesId) {
        this.vegtablesId = vegtablesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getAve() {
        return ave;
    }

    public void setAve(String ave) {
        this.ave = ave;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}