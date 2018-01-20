package com.geneseeq.common.utils;

import java.io.*;
import java.net.*;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;

public class WebServicePost {
    private static class LazyHolder {
        private static final WebServicePost INSTANCE = new WebServicePost();
    }
    private WebServicePost (){}
    public static final WebServicePost getInstance() {
        return LazyHolder.INSTANCE;
    }

    static Logger logger = Logger.getLogger(WebServicePost.class);

    public String sendGet(String url, String num, String MD5token) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?num=" + num + "&tokenMD5=" + MD5token;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("Accept-Charset", "utf-8");
            connection.setRequestProperty("contentType", "utf-8");
            // 建立实际的连接
            connection.connect();

            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            result = "500";
            logger.info("发送GET请求出现异常！", e);
        }
        return result;
    }



}