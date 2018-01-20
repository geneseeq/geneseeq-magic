package com.geneseeq.common.utils;

import java.io.*;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import net.sf.json.JSONObject;


public class HttpPostUrl {
    private static Logger logger = Logger.getLogger(HttpPostUrl.class);


    private static long startTime = 0L;
    private static long endTime = 0L;
    private static int status = 0;

    public static String post(String parameters, String expressUrl) throws ParseException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(expressUrl);

        String body = null;
        logger.info("parameters:" + parameters);

        if (httppost != null & parameters != null && !"".equals(parameters.trim())) {
            try {
                httppost.addHeader("Content-type", "application/json; charset=utf-8");
                httppost.setHeader("Accept", "application/json");
                httppost.setEntity(new StringEntity(parameters));
                startTime = System.currentTimeMillis();
                HttpResponse response = httpclient.execute(httppost);
                endTime = System.currentTimeMillis();
                int statusCode = response.getStatusLine().getStatusCode();
                logger.info("StatusCode:" + statusCode);
                logger.info("Calling API takes time(in milliseconds):" + (endTime - startTime));
                if (statusCode == 200) {
                    System.out.println("Server normal response....." + statusCode);
                } else {
                    logger.error("Method failed:" + response.getStatusLine());
                    status = 1;
                }
                // Read the response body
                body = EntityUtils.toString(response.getEntity());

            } catch (IOException e) {
                status = 3;
            } finally {
                logger.info("Call interface state:" + status);
            }

        }
        return body;
    }

    public static String SubmitPost(Map<String, String> map, String orderUrl) throws ParseException {
        HttpClient httpclient = new DefaultHttpClient();
        MultipartEntity reqEntity = new MultipartEntity();
        String result = "";
        HttpPost httppost = new HttpPost(orderUrl);
        try {
            if (!map.get("image").equals("")) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getKey() == "image") {
                        reqEntity.addPart(entry.getKey(), new FileBody(new File(entry.getValue())));
                    } else {
                        reqEntity.addPart(entry.getKey(),
                                new StringBody(entry.getValue(), Charset.forName(Content.Character)));
                    }
                }
            } else {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    reqEntity.addPart(entry.getKey(),
                            new StringBody(entry.getValue(), Charset.forName(Content.Character)));
                }
            }

            httppost.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(httppost);

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                System.out.println("Server normal response....." + statusCode);
                HttpEntity resEntity = response.getEntity();
                String resEntityStr = EntityUtils.toString(resEntity);
                JSONObject jsonObject = JSONObject.fromObject(resEntityStr);
                logger.info(resEntityStr);
                logger.info("调用lims接口返回的情况：" + jsonObject.get("errmsg"));
                EntityUtils.consume(resEntity);
                if (jsonObject.get("error").equals("0")) {
                    result = "Success";
                }
                if (jsonObject.get("error").equals("9")) {
                    logger.info("errmsg:" + jsonObject.get("errmsg"));
                    result = "orderExist";
                }

            } else {
                logger.info("调用lims接口返回的状态：" + statusCode);
                result = "Failed";
            }
        } catch (Exception e) {
            logger.info("Request failure");
            e.printStackTrace();
            result = "RequestFailure";
        } finally {

        }
        return result;
    }

    /*public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        String ts = String.valueOf(DateUtils.currentTimeStamp());
        String sig = MD5Test.GetMD5Code(ts + Content.OrderKey);
        map.put("ts", ts);
        map.put("sig", sig);
        for (int i = 2; i < Content.Orderfield.length; i++) {
            if (i == Content.Orderfield.length - 1) {
                map.put(Content.Orderfield[i], "D:/zzz/tu.png");
            } else {
                map.put(Content.Orderfield[i], "3");
            }
        }
        try {
            System.out.println(SubmitPost(map));

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     }*/

}


