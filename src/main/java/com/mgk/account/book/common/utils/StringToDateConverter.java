package com.mgk.account.book.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
 
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 请求时日期转换类
 */
public class StringToDateConverter implements Converter<String, LocalDateTime> {
	@Override
	public LocalDateTime convert(String source) {
		if (StringUtils.isEmpty(source) || "null".equals(source)) {
			return null;
		}
		source = source.trim();
		try {
			SimpleDateFormat formatter;
			if (source.contains("-")) {
				LocalDateTime dtDate =  LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
				return dtDate;
			} else if (source.contains("/")) {
				LocalDateTime dtDate =  LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
				return dtDate;
			}
		} catch (Exception e) {
			throw new RuntimeException(String.format("parser %s to LocalDateTime fail", source));
		}
		throw new RuntimeException(String.format("parser %s to LocalDateTime fail", source));
 
	}
}