package Algorithm;

/**
 * @author DELL
 * @Date 2020/2/17 16:46
 **/
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int i = kmpSearch(str1, str2, kmpNext(str2));
        System.out.println(i);

    }

    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            //当str1.charAt(i)!=str2.charAt(j)时，调整j
            //kmp核心
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    /**
     * 得到字符串的部分匹配表
     *
     * @param dst 目标串
     * @return 匹配表
     */
    public static int[] kmpNext(String dst) {
        //保存匹配表
        int[] next = new int[dst.length()];
        next[0] = 0;//字符串长度为1时部分匹配值为0
        for (int i = 1, j = 0; i < dst.length(); i++) {
            //当dest.chartAt(i)!=dest.charAt(j)，我们需要从next[j-1]获取新的j
            //知道发现有dst.chartAt(i)==dst.charAt(j)成立才退出
            //kmp核心
            while (j > 0 && dst.charAt(i) != dst.charAt(j)) {
                j = next[j - 1];
            }

            if (dst.charAt(i) == dst.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
