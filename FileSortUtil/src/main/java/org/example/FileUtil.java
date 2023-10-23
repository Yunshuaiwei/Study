package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/10/23 20:14
 */
public class FileUtil {
    private static final String path = "F:\\test";
    private static final String targetPath = "F:\\test02";

    public static void main(String[] args) {
        fileSort();
    }

    /*
     * 根据文件名称排序
     * @author yunshuaiwei
     * @date 2023/10/23 20:24
     **/
    private static Boolean fileSort() throws RuntimeException {
        File file = new File(path);
        File[] files = file.listFiles();
        if (files == null) {
            return false;
        }
        List<File> list = Arrays.asList(files);

        // 创建一个Collator对象，使用拼音排序规则
        Collator collator = Collator.getInstance(java.util.Locale.CHINA);

        // 使用Collator对象创建一个Comparator
        Comparator<File> comparator = collator::compare;
        list.sort(new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if (o1.isDirectory() && o1.isFile()) {
                    return -1;
                }
                if (o1.isFile() && o1.isDirectory()) {
                    return 1;
                }
                return o1.getName().compareTo(o2.getName());
            }
        });
        File targetFile = new File(targetPath);
        if (targetFile.exists()) {
            boolean delete = targetFile.delete();
        }
        boolean mkdir = targetFile.mkdir();
        for (File file1 : list) {
            System.out.println(file1.getName());
            String name = targetFile.getPath();
            String fileName = name + "\\" + file1.getName();
            File file2 = new File(fileName);
            FileInputStream is = null;
            FileOutputStream os = null;
            try {
                is = new FileInputStream(file1);
                os = new FileOutputStream(file2);
                byte[] bytes = new byte[1024];
                int length;
                while ((length = is.read(bytes)) > 0) {
                    os.write(bytes, 0, length);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (is != null) {
                        is.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    if (os != null) {
                        os.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        return true;
    }
}