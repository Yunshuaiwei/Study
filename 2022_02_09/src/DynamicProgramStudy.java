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

    public static void main(String[] args) {
        System.out.println(fib(6));
    }
}
