package com.mgk.account.book.common.utils.BaiDuPictureUtil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.net.URLEncoder;

/**
* 通用文字识别
*/
public class GeneralBasic {

    /**
    * 重要提示代码中所需工具类
    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * 下载
    */
    public static String generalBasic(String filePath,String flag ) {
        // 请求url
        //https://aip.baidubce.com/rest/2.0/ocr/v1/accurate_basic
//        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic";//普通
//        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate_basic";//精准
//        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/webimage";//网络
          String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/form";//表格
//          String url = "https://aip.baidubce.com/rest/2.0/solution/v1/form_ocr/request";//异步表格

        try {
            // 本地文件路径
//            filePath = "D:\\mgktest\\百度识别图片文字内容\\测试\\瓜果茄子.png";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;
            if(flag.equals("1")){
                param += "&table_border=none";//表格线

            }else if(flag.equals("3")){//普通解析
                url = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate_basic";
            }else{
                param += "&is_sync=true";
                param += "&request_type=excel";
                url = "https://aip.baidubce.com/rest/2.0/solution/v1/form_ocr/request";//异步表格
            }
//
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();//"[调用鉴权接口获取的token]";

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String getExcel(String id) {
        // 请求url
        //https://aip.baidubce.com/rest/2.0/ocr/v1/accurate_basic
//        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic";//普通
//        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate_basic";//精准
//        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/webimage";//网络
          String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/form";//表格
//        String url = "https://aip.baidubce.com/rest/2.0/solution/v1/form_ocr/get_request_result";//异步表格

        try {
            String param = "request_id=" + id;
//             param += "&table_border=none";//表格线
//            param += "&result_type=excel";
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();//"[调用鉴权接口获取的token]";

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String s = GeneralBasic.generalBasic("D:\\mgktest\\百度识别图片文字内容\\2018年数据\\一月份\\20180101.png","3");
        JSONObject jsonObject = JSONObject.parseObject(s);
//        JSONArray forms_result = (JSONArray)jsonObject.get("result");
//        jsonObject = (JSONObject) forms_result.get(0);
//        System.out.println("id:"+jsonObject.get("request_id"));
//        GeneralBasic.getExcel("25043443_2923121");

//        https://aip.baidubce.com/rest/2.0/solution/v1/form_ocr/get_request_result
    }
}