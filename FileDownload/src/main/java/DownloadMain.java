import cn.hutool.core.io.unit.DataSizeUtil;
import file.FileDownload;
import music.MusicDownload;

/**
 * @author yunshuaiwei
 * @className DownloadMain
 * @description: TODO
 * @date 2021/11/7 15:51
 */
public class DownloadMain {

    public static void main(String[] args) {
        //文件下载的URL
        String url = "https://mp32.9ku.com/upload/128/2018/02/24/876051.mp3";
        //下载公众号音频
//        downloadMusic(url);
        //下载文件
        downloadFile(url);
    }

    /**
     * @author yunshuaiwei
     * @description 下载公众号中的音频
     * @date 15:54 2021/11/7
     * @Param []
     * @Return void
     */
    private static void downloadMusic(String url) {
        //下载公众号中的音频
        MusicDownload download = new MusicDownload();
        download.downloadMusic(url);
    }

    /**
     * @author yunshuaiwei
     * @description 下载文件
     * @date 15:53 2021/11/7
     * @Param []
     * @Return void
     */
    private static void downloadFile(String url) {
        //文件的存储位置
        String path = "F:\\test";
        long size = FileDownload.downLoadFromUrl(url, path);
        System.out.println("文件大小为：" + DataSizeUtil.format(size));
    }
}
