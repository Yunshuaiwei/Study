import java.util.Arrays;

/**
 * @author yunshuaiwei
 * @className Solution
 * @description: TODO
 * @date 2021/10/20 7:03
 */
public class Solution {

    /**
     * @author yunshuaiwei
     * @description 替换字符串中的空格
     * @date 7:04 2021/10/20
     * @Param [s]
     * @Return java.lang.String
     */
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ' ') {
                str.append("%20");
                continue;
            }
            str.append(aChar);
        }
        return str.toString();
    }

    /**
     * @author yunshuaiwei
     * @description 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     * @date 7:12 2021/10/20
     * @Param [s, n]
     * @Return java.lang.String
     */
    public String reverseLeftWords(String s, int n) {

        StringBuilder sBuilder = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            char c = sBuilder.charAt(i);
            sBuilder.append(c);
        }
        s = sBuilder.toString();
        return s.substring(n);
    }

    /**
     * @author yunshuaiwei
     * @description 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * @date 7:19 2021/10/20
     * @Param [nums]
     * @Return int
     */
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        while (i < j){
            if (nums[i++]==nums[j--]){
                return nums[i-1];
            }
        }
        return nums[i];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.replaceSpace("We are happy.");

        String str = solution.reverseLeftWords("abcdefg", 2);

        int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};
        int i = solution.findRepeatNumber(arr);
        System.out.println(i);
    }
}
