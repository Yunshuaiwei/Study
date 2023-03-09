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
        String url = "https://mp.weixin.qq.com/s/CewX024YNnO-7ompAs8lkQ";
        //下载公众号音频
        downloadMusic(url);
        //下载文件
//        downloadFile(url,"小幸运04");
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
    private static void downloadFile(String url,String fileName) {
        //文件的存储位置
        String path = "F:\\test";
        long size = FileDownload.downLoadFromUrl(url, path,fileName);
        System.out.println("文件大小为：" + DataSizeUtil.format(size));
    }
}
