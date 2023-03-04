package file;

import cn.hutool.core.date.BetweenFormater;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpUtil;
import org.apache.logging.log4j.util.Strings;

import java.io.File;
import java.util.UUID;


/**
 * @className: FileDownload
 * @description: TODO
 * @author: yunshuaiwei
 * @date: 2021/11/1 19:04
 * @version: 1.0
 */
public class FileDownload {

    /**
     * @return java.lang.String
     * @author yunshuaiwei
     * @description 从网络URL中下载文件
     * @date 15:33 2021/11/2
     * @params [fileUrl, staticAndMksDir]
     */
    public static Long downLoadFromUrl(String fileUrl, String diskPath, String fileName) {
        String path;
        long size = 0;
        if (fileUrl != null) {
            //文件后缀
            String fileSuffix = fileUrl.substring(fileUrl.lastIndexOf("."));
            try {
                if (Strings.isBlank(fileName)) {
                    fileName = UUID.randomUUID().toString();
                }
                File file = new File(diskPath);
                if (!file.exists()) {
                    //创建文件夹
                    boolean mkdir = file.mkdir();
                    if (!mkdir) {
                        throw new RuntimeException("创建文件夹失败，路径为：" + diskPath);
                    }
                }
                path = diskPath + File.separator + fileName + fileSuffix;
                File tmp = new File(path);
                if (tmp.exists()) {
                    fileName = UUID.randomUUID().toString();
                }
                path = diskPath + File.separator + fileName + fileSuffix;
                String begin = DateUtil.now();
                DateTime beginTime = DateUtil.parse(begin);
                //带进度显示的文件下载
                size = HttpUtil.downloadFile(fileUrl, FileUtil.file(path), new StreamProgress() {
                    @Override
                    public void start() {
                        Console.log("开始下载，时间为：" + begin);
                    }

                    @Override
                    public void progress(long progressSize) {
                        Console.log("已下载：{}", FileUtil.readableFileSize(progressSize));
                    }

                    @Override
                    public void finish() {
                        String end = DateUtil.now();
                        DateTime endTime = DateUtil.parse(end);
                        long between = DateUtil.between(beginTime, endTime, DateUnit.MS);
                        Console.log("下载完成，用时：" + DateUtil.formatBetween(between, BetweenFormater.Level.SECOND));
                    }
                });
            } catch (Exception e) {
                Console.log("下载异常，异常信息为：" + e.getMessage());
            }
        }
        return size;
    }
}
