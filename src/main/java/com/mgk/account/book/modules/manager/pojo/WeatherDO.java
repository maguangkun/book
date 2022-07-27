package com.mgk.account.book.modules.manager.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mgk.account.book.modules.base.pojo.AbstractBaseDO;
import io.swagger.annotations.ApiModel;

@TableName("T_Weather")
@ApiModel(value="天气表", description="天气表")
public class WeatherDO extends AbstractBaseDO {
}
