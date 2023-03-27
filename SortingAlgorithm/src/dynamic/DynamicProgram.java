package dynamic;

import java.util.List;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/8 23:22
 */
public class DynamicProgram {

    /**
     * 5. 最长回文子串
     *
     * @author yunshuaiwei
     * @date 2023/3/8 23:22
     **/
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int len = s.length();
        Boolean[][] dp = new Boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        //记录回文串长度及右边界
        int maxLen = 1;
        //回文串坐边界
        int begin = 0;
        //i表示回文串的长度
        for (int i = 2; i <= len; i++) {
            for (int j = 0; j < len; j++) {
                //k表示回文串的右边界下标
                int k = j + i - 1;
                if (k >= len) {
                    break;
                }
                if (chars[j] != chars[k]) {
                    //字符串从下标j到下标k不是回文串
                    dp[j][k] = false;
                } else {
                    if (k - j <= 2) {
                        dp[j][k] = true;
                    } else {
                        dp[j][k] = dp[j + 1][k - 1];
                    }
                }
                if (dp[j][k] && k - j + 1 > maxLen) {
                    maxLen = k - j + 1;
                    begin = j;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 22. 括号生成
     *
     * @author yunshuaiwei
     * @date 2023/3/9 22:51
     **/
    public List<String> generateParenthesis(int n) {

        return null;
    }

    /**
     * 53. 最大子数组和
     *
     * @author yunshuaiwei
     * @date 2023/3/9 22:56
     **/
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    /**
     * 45. 跳跃游戏 II
     *
     * @author yunshuaiwei
     * @date 2023/3/22 17:28
     **/
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int max = 0;
        int step = 0;
        for (int i = 0; i < length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        DynamicProgram program = new DynamicProgram();

        int[] nums = new int[]{2, 3, 1, 2, 4, 2, 3};
        System.out.println(program.jump(nums));
    }

}
