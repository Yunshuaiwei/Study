import java.util.Arrays;

/**
 * @author yunshuaiwei
 * @className DynamicProgramStudy
 * @description: 动态规划练习
 * @date 2022/3/8 15:10
 */
public class DynamicProgramStudy {

    /**
     * @author yunshuaiwei
     * @description 斐波那契数列
     * @date 15:12 2022/3/8
     * @Param [n]
     * @Return int
     */
    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0, b = 1, res = 0;
        for (int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

    /**
     * @author yunshuaiwei
     * @description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * @date 15:27 2022/3/8
     * @Param [n]
     * @Return int
     */
    public static int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[0] = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = dp[0];
        }
        return dp[0];
    }

    /**
     * @author yunshuaiwei
     * @description 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
     * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
     * 请你计算并返回达到楼梯顶部的最低花费。
     * @date 15:34 2022/3/8
     * @Param [cost]
     * @Return int
     */
    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length];
        if (length < 3) {
            return Math.min(cost[0], cost[1]);
        }
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[length - 1], dp[length - 2]);
    }

    /**
     * @author yunshuaiwei
     * @description 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * 问总共有多少条不同的路径？
     * @date 15:50 2022/3/8
     * @Param [m, n]
     * @Return int
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;

        for (int j = 0; j < n; j++) dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * @author yunshuaiwei
     * @description 一个机器人位于一个m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     * @date 16:23 2022/3/8
     * @Param [obstacleGrid]
     * @Return int
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) dp[i][0] = 1;

        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {//障碍物
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * @author yunshuaiwei
     * @description 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
     * 返回 你可以获得的最大乘积 。
     * @date 16:35 2022/3/8
     * @Param [n]
     * @Return int
     */
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[i - j] * j));
            }
        }
        return dp[n];
    }

    /**
     * @author yunshuaiwei
     * @description 01背包问题测试
     * @date 22:13 2022/3/10
     * @Param [weight：物品重量]
     * @Param [value：物品价值]
     * @Param [bagSize：背包大小]
     * @Return void
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int wLen = weight.length;
        //背包容量为j时，前i个物品获取的最大价值
        int[][] dp = new int[wLen][bagSize + 1];
        //初始化数组
        for (int j = weight[0]; j <= bagSize; j++) {
            //背包大小大于第1个物品的重量时，该背包只能放物品0的价值
            dp[0][j] = value[0];
        }
        for (int i = 1; i < wLen; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //weight[i-1]]和value[i-1]分别表示第i个物品的重量和价值，因为i是从1开始的
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        //打印数组
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * @author yunshuaiwei
     * @description 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * @date 15:08 2022/3/16
     * @Param [nums]
     * @Return boolean
     */
    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {//奇数
            return false;
        }
        int num = sum / 2;
        int[] dp = new int[num + 1];
        for (int val : nums) {
            for (int j = num; j >= val; j--) {
                dp[j] = Math.max(dp[j], dp[j - val] + val);
            }
        }
        return dp[num] == num;
    }

    /**
     * @author yunshuaiwei
     * @description 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
     * @date 15:34 2022/3/16
     * @Param [stones]
     * @Return int
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[][] dp = new int[stones.length][target + 1];
        for (int j = stones[0]; j <= target; j++) {
            dp[0][j] = stones[0];
        }
        for (int i = 1; i < stones.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= stones[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return (sum - dp[stones.length - 1][target]) - dp[stones.length - 1][target];
    }

    /**
     * @author yunshuaiwei
     * @description 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
     * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
     * 假设每一种面额的硬币有无限个。
     * 题目数据保证结果符合 32 位带符号整数。
     * @date 15:32 2022/3/18
     * @Param [nums, target]
     * @Return int
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }

    /**
     * @author yunshuaiwei
     * @description 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     * @date 16:01 2022/3/18
     * @Param [nums, target]
     * @Return int
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int j : dp) {
            res = Math.max(res, j);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
}
