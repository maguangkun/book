package com.mgk.account.book.common.utils;

import com.sun.org.apache.regexp.internal.RE;

public class WeatherUtil {
    //天气类型
    private static final String ZHONGYU="1";
    private static final String ZHONGXUE="2";
    private static final String DUOYUN="3";
    private static final String DUOYUNZQ="4";
    private static final String DAYU="5";
    private static final String DAXUE="6";
    private static final String XIAOYU="7";
    private static final String XIAOXUE="8";
    private static final String YANGSHA="9";
    private static final String QING="10";
    private static final String QINGZHUANDY="11";
    private static final String FUCHEN="12";
    private static final String YIN="13";
    private static final String ZHENYUN="14";
    private static final String YU="15";
    private static final String YUJIAXUE="16";
    private static final String LEIZHENYU="17";
    private static final String WU="18";
    private static final String MAI="19";

    //风向
    private static final String FNULL="0";
    private static final String DBF="1";
    private static final String DNF="2";
    private static final String DF="3";
    private static final String BF="4";
    private static final String NF="5";
    private static final String WF="6";
    private static final String WCXF="7";
    private static final String WCXFX="8";
    private static final String XBF="9";
    private static final String XNF="10";
    private static final String XF="11";
    private static final String JF="12";

    public static String GetWeather(String weather){
        switch (weather)
            {
                case "中雨":
                    return ZHONGYU;
                case "中雪":
                    return ZHONGXUE;
                case "多云":
                    return DUOYUN;
                case "多云转晴":
                    return DUOYUNZQ;
                case "大雨":
                    return DAYU;
                case "大雪":
                    return DAXUE;
                case "小雨":
                    return XIAOYU;
                case "小雪":
                    return XIAOXUE;
                case "扬沙":
                    return YANGSHA;
                case "晴":
                    return QING;
                case "晴转多云":
                    return QINGZHUANDY;
                case "浮尘":
                    return FUCHEN;
                case "阴":
                    return  YIN;
                case "阵雨":
                    return ZHENYUN;
                case "雨":
                    return YU;
                case "雨夹雪":
                    return YUJIAXUE;
                case "雷阵雨":
                    return LEIZHENYU;
                case "雾":
                    return WU;
                case "霾":
                    return MAI;
            }
            return "0";
    }
    public static String GetWinddirect(String windsock){
        switch (windsock) {
            case "东北风":
                return DBF;
            case "东南风":
                return DNF;
            case "东风":
                return DF;
            case "北风":
                return BF;
            case "南风":
                return NF;
            case "微风":
                return WF;
            case "无持续风":
                return WCXF;
            case "无持续风向":
                return WCXFX;
            case "西北风":
                return XBF;
            case "西南风":
                return XNF;
            case "西风":
                return XF;
            case "静风":
                return JF;
        }
        return "0";
    }
}
