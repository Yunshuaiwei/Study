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
        downloadMusic();
        downloadFile();
    }

    /**
     * @author yunshuaiwei
     * @description 下载公众号中的音频
     * @date 15:54 2021/11/7
     * @Param []
     * @Return void
     */
    private static void downloadMusic(){
        //下载公众号中的音频
        MusicDownload download = new MusicDownload();
        download.downloadMusic();
    }

    /**
     * @author yunshuaiwei
     * @description 下载文件
     * @date 15:53 2021/11/7
     * @Param []
     * @Return void
     */
    private static void downloadFile(){
        //文件下载的URL
        String url = "https://scootersoftware.com/BCompare-zh-3.3.13.18981.exe";
        //文件的存储位置
        String path = "F:\\test";
        long size = FileDownload.downLoadFromUrl(url, path);
        System.out.println("文件大小为：" + DataSizeUtil.format(size));
    }
}
