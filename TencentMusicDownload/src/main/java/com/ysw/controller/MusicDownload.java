package com.ysw.controller;

import com.ysw.utils.HttpHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yunshuaiwei
 * @className MusicDownload
 * @description: TODO
 * @date 2021/10/24 14:46
 */
@RestController
public class MusicDownload {

    @Autowired
    private RestTemplate restTemplate;

    public String getMusic(){
        String uri = "https://mp.weixin.qq.com/s/x5KVA4NO0Lo7DS5dKiFkDA";

        //请求头
        HttpHeaders httpHeader = HttpHeader.getHttpHeader();
        HttpEntity<String> entity = new HttpEntity<String>("parameters", httpHeader);
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        //请求到的主页面body体
        String body = result.getBody();

        //查找mediaid
        String pattern = "voice_encode_fileid=\"[\\w]*\"";
        Pattern compile = Pattern.compile(pattern);
        assert body != null;
        Matcher matcher = compile.matcher(body);
        //保存mediaid
        ArrayList<String> strings = new ArrayList<>();
        //正则表达式匹配mediaid
        while (matcher.find()) {
            String group = matcher.group(0);
            StringBuilder stringBuilder = new StringBuilder(group);
            String substring = stringBuilder.substring(21, group.length() - 1);
            strings.add(substring);
        }

        //下载歌曲到文件
        int i=1;
        FileOutputStream fileOutputStream=null;
        for (String string : strings) {
            uri = "https://res.wx.qq.com/voice/getvoice?mediaid=" + string;
            try {
                URL url = new URL(uri);
                URLConnection urlConnection = url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                fileOutputStream = new FileOutputStream("F:\\test\\"+i+".mp3");
                i++;
                int bytesum = 0;
                int byteread;
                byte[] buffer = new byte[1024];
                while ((byteread = inputStream.read(buffer)) != -1) {
                    bytesum += byteread;
                    fileOutputStream.write(buffer, 0, byteread);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileOutputStream!=null){
                        fileOutputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "success";
    }
}
