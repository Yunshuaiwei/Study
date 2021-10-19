import java.io.File;
import java.util.Arrays;

/**
 * @author yunshuaiwei
 * @className EditFileName
 * @description: TODO
 * @date 2021/10/19 22:12
 */
public class EditFileName {
    //文件夹路径
    private static final String dirPath = "E:\\JFashion\\歌曲";

    public void changeFileName() {
        File file = new File(dirPath);
        File[] files = file.listFiles();
        if (files == null) {
            return;
        }
        System.out.println(dirPath + "，该路径下有 " + files.length + "个文件！");
        for (File file1 : files) {
            String name = file1.getName();
            String[] s = name.split("_");
            if (s.length > 1) {
                //重命名
                String newFileName = dirPath + "\\" + s[1];
                boolean res = file1.renameTo(new File(newFileName));
                //若重命名失败则表示该文件已经存在
                if (!res) {
                    //删除文件
                    boolean delete = file1.delete();
                    System.out.println("删除的文件名为：" + file1.getName() + "；删除成功：" + delete);
                }
            }
        }
        String[] list = file.list();
        System.out.println(Arrays.toString(list));
        System.out.println(dirPath + "，该路径下有 " + files.length + "个文件！");
    }

    public static void main(String[] args) {
        EditFileName editFileName = new EditFileName();
        editFileName.changeFileName();
    }

}
