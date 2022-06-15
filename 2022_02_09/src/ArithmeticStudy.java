import java.util.Arrays;

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
    private static int y() {
        int res = 0;
        do {
            res = x();
        } while (res == x());
        //res= 0 1
        //res= 1 0
        return res;
    }

    /**
     * @author yunshuaiwei
     * @description 查找>=num，在数组arr中最左侧的位置下标
     * @date 16:36 2022/6/15
     * @Param []
     * @Return int
     */
    public static int searchFarLeftOfNumForIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int t = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {
                t = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return t;
    }

    /**
     * @author yunshuaiwei
     * @description 返回一个局部最小值的下标index
     * @date 16:52 2022/6/15
     * @Param [arr]
     * @Return int
     */
    public static int returnLocalMinimumOfIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int len = arr.length;
        if (len == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[len - 1] < arr[len - 2]) {
            return len - 1;
        }
        int l = 0;
        int r = len - 1;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return arr[l] < arr[r] ? l : r;
    }

    /**
     * @author yunshuaiwei
     * @description 生成一个随机数组，相邻元素不相等
     * @date 17:18 2022/6/15
     * @Param [mexLen, maxValue]
     * @Return int[]
     */
    private static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    /**
     * @author yunshuaiwei
     * @description 验证数组arr，下标minIndex处是否为局部最小处
     * @date 17:25 2022/6/15
     * @Param [arr, minIndex]
     * @Return boolean
     */
    private static boolean check(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left <= 0 || arr[left] > arr[minIndex];
        boolean rightBigger = right >= arr.length || arr[right] > arr[minIndex];
        return leftBigger && rightBigger;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 8, 1, 2, 7, 9, 0, 3, 6};
        int[] ints = new int[]{71, 62, 56, 95};

        //测试1W次
        for (int i = 0; i < 10000; i++) {
            ints = randomArray(10, 100);
            int num = returnLocalMinimumOfIndex(ints);
            if (!check(ints, num)) {
                System.out.println(Arrays.toString(ints));
                System.out.println("failed" + ": " + num);
            }
        }
        System.out.println("success");


    }
}
