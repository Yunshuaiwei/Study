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

    public static void main(String[] args) {

    }
}
