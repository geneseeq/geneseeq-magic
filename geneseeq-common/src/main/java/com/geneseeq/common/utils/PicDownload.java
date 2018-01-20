package com.geneseeq.common.utils;

import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PicDownload {

    private static Logger log = Logger.getLogger(PicDownload.class);

    /**
     * 获取媒体文件
     *
     * @param accessToken 接口访问凭证
     * @param savePath    文件在服务器上的存储路径
     */
    public static String downloadMedia(String accessToken, String mediaId, String savePath, String orderNumber) {
        String filePath = null;
        String requestUrl = "https://qyapi.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("MEDIA_ID", mediaId);
        //System.out.println(requestUrl);
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setRequestMethod("GET");

            if (!savePath.endsWith("/")) {
                savePath += "/";
            }
            filePath = savePath + orderNumber + mediaId + ".jpg";
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            byte[] buf = new byte[8096];
            int size = 0;
            while ((size = bis.read(buf)) != -1)
                fos.write(buf, 0, size);
            fos.close();
            bis.close();
            conn.disconnect();
            String info = String.format("下载媒体文件成功，filePath=" + filePath);
            log.info(info);
        } catch (Exception e) {
            filePath = null;
            String error = String.format("下载媒体文件失败：%s", e);
            log.error(error);
        }
        return filePath;
    }

    public static void main(String[] args) {

        System.out.println(downloadMedia("iugnLjADxqLonEfW1UWNk890PbSJXVGkRDNZSzvR4YI0-09wKvd-pcj2Wp9pQgsCO1klt266A319LiN_rqBbyzDa5cLijEBhMgMrbuMsED43sec1UcQj3Q7PBh8sdQv-v6YfV186bezpIUP4mXx8UJUVL5zCZ62JHFfxjyYRpkq4tHTiVzNZFMRueSEBvQHYxGqQXdytefQhEG5cysawgA", "1omrG-KPfCGJxRi07Uid3v0fxtVxcZ6jN3EyP0dTBV8E", "E:/Myimage", "595959"));

    }


}
