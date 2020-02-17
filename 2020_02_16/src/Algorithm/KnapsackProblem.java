package Algorithm;

import java.util.Arrays;

/**
 * @author DELL
 * @Date 2020/2/17 11:33
 **/
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};//物品的重量
        int[] val = {1500, 3000, 2000};//物品的价值
        int m = 4;//背包的容量
        int n = val.length;//物品的数量
        //表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];
        //记录商品的情况
        int[][] path = new int[n + 1][m + 1];
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;//将第一列置0
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;//将第一行置0
        }
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                //公式
                if (w[i - 1] > j) {//商品的重量大于背包的重量
                    v[i][j] = v[i - 1][j];
                } else {
//                    v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }
        //打印出数组
        for (int[] ints : v) {
            System.out.println(Arrays.toString(ints));
        }

        int i = path.length - 1;//行最大下标
        int j = path[0].length - 1;//列的最大下标
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i - 1];
            }
            i--;
        }
    }
}
