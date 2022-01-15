package com.mgk.account.book.common.utils;

import sun.misc.BASE64Decoder;
import java.io.*;

/**
 * Base64编码转图片
 * 
 */
public class Base64TransitionToImageUtil {
    public static void main(String[] args) {
        String base64Str="";//base64字符串
        String parentPath="";//图片存放路径
        String fileName="";//图片存放路径名称
        base64StrToFile(base64Str,fileName,parentPath);
    }

    public static File base64StrToFile(String base64Str,String fileName,String parentPath){
        File file = new File(parentPath,fileName);
        FileOutputStream out = null;
        try {
            byte[] bytes1 = new BASE64Decoder().decodeBuffer(base64Str);
            ByteArrayInputStream in = new ByteArrayInputStream(bytes1);
            byte[] buffer = new byte[1024];
            out = new FileOutputStream(file);
            int byteSum = 0;
            int byteRead = 0;
            while ((byteRead = in.read(buffer)) != -1){
                byteSum += byteRead;
                out.write(buffer,0,byteRead);
            }
        }catch (Exception ex){
            throw new RuntimeException("transform base64 String into file 出错",ex);
        }finally {
            try {
                if(null != out){
                    out.close();
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
        return file;
    }
}
