/**
 * @author yunshuaiwei
 * @className ArithmeticStudy
 * @description: TODO
 * @date 2022/6/14 11:59
 */
public class ArithmeticStudy {


    /**
     * @author yunshuaiwei
     * @description 数组某个区间内的数据累加和
     * @date 22:04 2022/6/14
     * @Param [arr, left, right]
     * @Return int
     */
    private static int rangeSum(int[] arr, int left, int right) {
        int len = arr.length;
        int[] ints = new int[len];
        ints[0] = arr[0];
        for (int i = 1; i < len; i++) {
            ints[i] = ints[i - 1] + arr[i];
        }
        return left == 0 ? ints[0] : ints[right] - ints[left - 1];
    }

    /**
     * @author yunshuaiwei
     * @description 基础随机函数，随机等概率返回1-5
     * @date 22:36 2022/6/14
     * @Param []
     * @Return int
     */
    private static int baseRandom() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * @author yunshuaiwei
     * @description 随机机制，只能适用baseRandom()函数，等概率返回0和1
     * @date 22:38 2022/6/14
     * @Param []
     * @Return int
     */
    private static int randomReturn0Or1() {
        int res = 0;
        do {
            res = baseRandom();
        } while (res == 3);
        return res < 3 ? 0 : 1;
    }

    /**
     * @author yunshuaiwei
     * @description 得到000~111做到等概率，即0~7等概率返回
     * @date 22:46 2022/6/14
     * @Param []
     * @Return int
     */
    private static int randomReturn0To7() {
        return (randomReturn0Or1() << 2) + (randomReturn0Or1() << 1) + (randomReturn0Or1());
    }


    /**
     * @author yunshuaiwei
     * @description 随机等概率返回0~6
     * @date 22:50 2022/6/14
     * @Param []
     * @Return int
     */
    private static int randomReturn0To6() {
        int res = 0;
        do {
            res = randomReturn0To7();
        } while (res == 7);
        return res;
    }

    /**
     * @author yunshuaiwei
     * @description 等概率得到1~7
     * @date 22:53 2022/6/14
     * @Param []
     * @Return int
     */
    private static int randomReturn1To7() {
        return randomReturn0To6() + 1;
    }

    /**
     * @author yunshuaiwei
     * @description 只知道x函数会以固定概率返回0和1，但是x里面具体的概率不知道
     * @date 22:59 2022/6/14
     * @Param []
     * @Return int
     */
    private static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    /**
     * @author yunshuaiwei
     * @description 等概率返回0和1
     * @date 23:01 2022/6/14
     * @Param []
     * @Return int
     */
    private static int y(){
        int res=0;
        do {
            res=x();
        }while (res==x());
        //res= 0 1
        //res= 1 0
        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 8, 1, 2, 7, 9, 0, 3, 6};
//        System.out.println(rangeSum(arr, 1, 2));

        for (int i = 0; i < 10; i++) {
            System.out.println(Math.random());
        }
    }


}
