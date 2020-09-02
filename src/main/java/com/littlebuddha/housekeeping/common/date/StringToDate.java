package com.littlebuddha.housekeeping.common.date;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate implements Converter<String, Date> {
    @Override
    public Date convert(String date) {
        if(date == null){
            throw new RuntimeException("请传值");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(date);
        } catch (Exception e) {
            throw new RuntimeException("字符串转日期数据转换出错");
        }
    }
}
