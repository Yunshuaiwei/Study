import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yunshuaiwei
 * @className MusicDownload
 * @description: TODO
 * @date 2021/10/24 22:07
 */
public class MusicDownload {
    //公众号URL
    private static String URI = "https://mp.weixin.qq.com/s/1iYXFxI-DJtoyhwMqduGvA";

    //查找mediaid正则表达式
    private static final String REGEX;

    static {
        REGEX = "voice_encode_fileid=\"[\\w]*\"";
    }

    public void downloadMusic() {
        System.out.println("开始下载......");
        //请求头
        HttpHeaders httpHeader = HttpHeader.getHttpHeader();
        HttpEntity<String> entity = new HttpEntity<String>("parameters", httpHeader);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange(URI, HttpMethod.GET, entity, String.class);
        //请求到的主页面body体
        String body = result.getBody();
        List<String> strings = searchMediaid(body);
        System.out.println("正在下载......");
        boolean b = musicToFile(strings);
        if (b) {
            System.out.println("下载完成!");
        } else {
            System.out.println("下载失败!");
        }
    }

    /**
     * @author yunshuaiwei
     * @description 从页面中查找音频的mediaid
     * @date 22:17 2021/10/24
     * @Param [body]
     * @Return java.util.List<java.lang.String>
     */
    private List<String> searchMediaid(String body) {
        if (Strings.isEmpty(body)) {
            throw new RuntimeException("页面body体为空");
        }
        Pattern compile = Pattern.compile(REGEX);
        Matcher matcher = compile.matcher(body);
        //保存mediaid
        ArrayList<String> strings = new ArrayList<>();
        while (matcher.find()) {
            String group = matcher.group(0);
            StringBuilder stringBuilder = new StringBuilder(group);
            String substring = stringBuilder.substring(21, group.length() - 1);
            strings.add(substring);
        }
        if (strings.isEmpty()) {
            System.out.println("没有匹配到mediaid");
            return strings;
        }
        System.out.println("匹配到的mediaid为：" + strings.toString());
        return strings;
    }

    /**
     * @author yunshuaiwei
     * @description 保存歌曲到文件
     * @date 22:31 2021/10/24
     * @Param [mediaIds]
     * @Return boolean
     */
    private boolean musicToFile(List<String> mediaIds) {
        //下载歌曲到文件
        FileOutputStream fileOutputStream = null;
        for (String mediaId : mediaIds) {
            //音频页面的URL
            URI = "https://res.wx.qq.com/voice/getvoice?mediaid=" + mediaId;
            try {
                URL url = new URL(URI);
                URLConnection urlConnection = url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                UUID uuid = UUID.randomUUID();
                //存储位置
                fileOutputStream = new FileOutputStream("F:\\test\\" + uuid + ".mp3");
                int byteSum = 0;
                int byteRead;
                byte[] buffer = new byte[1024];
                while ((byteRead = inputStream.read(buffer)) != -1) {
                    byteSum += byteRead;
                    fileOutputStream.write(buffer, 0, byteRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MusicDownload download = new MusicDownload();
        download.downloadMusic();
    }
}
