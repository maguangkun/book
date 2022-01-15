package com.mgk.account.book.common.utils.BaiDuPictureUtil;
import com.alibaba.fastjson.JSONObject;
import com.mgk.account.book.common.utils.Base64TransitionToImageUtil;

import java.net.URLEncoder;

/**
* 图像清晰度增强
*/
public class Image_definition_enhance {

    /**
    * 重要提示代码中所需工具类
    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * 下载
    */
    public static String image_definition_enhance() {
        // 请求url
//        String url = "https://aip.baidubce.com/rest/2.0/image-process/v1/image_definition_enhance";
        String url="https://aip.baidubce.com/rest/2.0/image-process/v1/image_quality_enhance";//无损房大
        try {
            // 本地文件路径
            String filePath = "D:\\mgktest\\百度识别图片文字内容\\2017年数据\\十二月份\\20171211.png";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth("S3ZUd0TUSCHLBUpFH2iVdEwf","syKmFLQ2O6YE8bYqoidtO8gALtV2gtv8");

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String s = Image_definition_enhance.image_definition_enhance();
        JSONObject jsonObject = JSONObject.parseObject(s);
        Base64TransitionToImageUtil.base64StrToFile(jsonObject.getString("image"),"20171211.png","D:\\mgktest\\百度识别图片文字内容\\2017年数据\\十二月份\\");
    }
}