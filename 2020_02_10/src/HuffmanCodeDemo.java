import java.io.*;
import java.util.*;

/**
 * @author DELL
 * @Date 2020/2/10 13:46
 **/
public class HuffmanCodeDemo {
    public static void main(String[] args) {
        String srcFile = "C:\\Users\\DELL\\Pictures\\头像2.jpeg";
        String dstFile = "C:\\Users\\DELL\\Pictures\\dst.jpeg";

//        zipFile(srcFile,dstFile);
//        System.out.println("压缩文件Ok!");

        /*String str = "i like like like java do you like a java";
        byte[] bytes = str.getBytes();
        byte[] zip = huffmanZip(bytes);
        System.out.println(Arrays.toString(zip));
        byte[] by = deCode(huffmanCode, zip);
        System.out.println(new String(by));*/

        String zipFile = "C:\\Users\\DELL\\Pictures\\dst.jpeg";
        String zipDstFile = "C:\\Users\\DELL\\Pictures\\头像2.jpeg";
        unZipFile(zipFile, zipDstFile);
        System.out.println("解压成功！");
    }

    /**
     * 解压
     *
     * @param zipFile 压缩文件
     * @param dstFile 解压后的文件路径
     */
    public static void unZipFile(String zipFile, String dstFile) {
        FileInputStream is = null;
        ObjectInputStream ois = null;
        FileOutputStream os = null;
        try {
            is = new FileInputStream(zipFile);
            ois = new ObjectInputStream(is);
            byte[] huffmanBytes = (byte[]) ois.readObject();
            Map<Byte, String> huffmanCode = (Map<Byte, String>) ois.readObject();
            byte[] bytes = deCode(huffmanCode, huffmanBytes);
            os = new FileOutputStream(dstFile);
            os.write(bytes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (ois != null) {
                    ois.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件压缩
     *
     * @param srcFile
     * @param dstFile
     */
    public static void zipFile(String srcFile, String dstFile) {
        ObjectOutputStream objectOutputStream = null;
        OutputStream os = null;
        FileInputStream is = null;
        try {
            is = new FileInputStream(srcFile);
            byte[] b = new byte[is.available()];
            //读取文件
            int read = is.read(b);
            //对文件压缩
            byte[] bytes = huffmanZip(b);
            //文件输出流
            os = new FileOutputStream(dstFile);
            //创建一个和文件输出流关联的ObjectOutputStream
            objectOutputStream = new ObjectOutputStream(os);
            //将赫夫曼编码后的字节数组写入压缩文件
            objectOutputStream.writeObject(bytes);
            //以对象流方式写入赫夫曼编码，有利于恢复原文件
            objectOutputStream.writeObject(huffmanCode);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (os != null) {
                    os.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 数据的压缩
     *
     * @param bytes 原始数组
     * @return 压缩后的数组
     */
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        //创建赫夫曼树
        Node root = createHuffmanTree(nodes);
        //根据赫夫曼树生成赫夫曼编码
        Map<Byte, String> codes = getCodes(root);
        //对数组进行压缩
        byte[] zipBytes = zip(bytes, codes);
        return zipBytes;
    }

    /**
     * 解压
     *
     * @param huffmanCode 赫夫曼编码表
     * @param huffmanByte 赫夫曼编码得到的字节数组
     * @return 返回解压后的字符串对用的数组
     */
    private static byte[] deCode(Map<Byte, String> huffmanCode, byte[] huffmanByte) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanByte.length; i++) {
            boolean flag = (i == huffmanByte.length - 1);
            stringBuilder.append(byteToBitString(!flag, huffmanByte[i]));
        }
        //查询编码表
        HashMap<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCode.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        //存放byte
        ArrayList<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if (b == null) {//没有匹配到
                    count++;
                } else {//匹配到了
                    flag = false;
                }
            }
            i += count;
            list.add(b);
        }
        //循环结束后list中存放了所有字符
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     * 将byte转成二进制字符串
     *
     * @param flag 标志是否需要补位，如果为true则补位
     * @param b
     * @return 返回b的对应二进制字符串(补码)
     */
    private static String byteToBitString(boolean flag, byte b) {
        int temp = b;//将b转成int
        if (flag) {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);//返回二进制补码
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    /**
     * 压缩后的数组
     *
     * @param bytes
     * @param huffmanCode
     * @return
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCode) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte aByte : bytes) {
            stringBuilder.append(huffmanCode.get(aByte));
        }
        //将stringBuilder中存放的字符串转换成byte[]
        //统计byte[] huffmanCodeBytes的长度
        int len = 0;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //压缩后的byte数组
        byte[] by = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {//不够八位
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            by[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return by;
    }

    //存放编码
    static HashMap<Byte, String> huffmanCode = new HashMap<Byte, String>();
    //存放路径
    static StringBuilder stringBuilder = new StringBuilder();

    /**
     * 得到赫夫曼编码表
     *
     * @param root 赫夫曼树的根节点
     * @return 返回赫夫曼编码表
     */
    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        return huffmanCode;
    }

    /**
     * 得到赫夫曼编码表
     *
     * @param node
     * @param code
     * @param stringBuilder
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node != null) {
            if (node.data == null) {//非叶子节点
                //递归
                getCodes(node.left, "0", stringBuilder2);
                //向右递归
                getCodes(node.right, "1", stringBuilder2);
            } else {//叶子节点
                huffmanCode.put(node.data, stringBuilder2.toString());
            }
        }
    }

    private static List<Node> getNodes(byte[] bytes) {
        ArrayList<Node> nodes = new ArrayList<>();

        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    /**
     * 构建赫夫曼树
     *
     * @param nodes
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //构建新的二叉树
            Node newNode = new Node(null, leftNode.weight + rightNode.weight);
            newNode.left = leftNode;
            newNode.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(newNode);
        }
        //赫夫曼树的根节点
        return nodes.get(0);
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    private static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("赫夫曼树为空！");
        }
    }
}
