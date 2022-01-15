package com.mgk.account.book.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 请求时日期转换类
 */
public class LongToEmptyConverter implements Converter<String, Long> {
	@Override
	public Long convert(String source) {
		if (StringUtils.isEmpty(source) || "null".equals(source)) {
			return null;
		}
		try {
		} catch (Exception e) {
			throw new RuntimeException(String.format("parser %s to Long fail", source));
		}
		throw new RuntimeException(String.format("parser %s to Long fail", source));
 
	}
}