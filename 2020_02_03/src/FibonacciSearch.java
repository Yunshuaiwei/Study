import java.util.Arrays;

/**
 * @author DELL
 * @Date 2020/2/4 16:35
 **/
public class FibonacciSearch {
    private static int MAXSIZE = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int i = fibonacciSearch(arr, 1234);
        System.out.println(i);
    }

    /**
     * 得到一个斐波那契数列
     *
     * @return
     */
    public static int[] fibonacci() {
        int[] f = new int[MAXSIZE];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < MAXSIZE; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 斐波那契查找
     *
     * @param arr 查找的数组
     * @param val 查找的值
     * @return 找到则返回下标，否则返回-1
     */
    public static int fibonacciSearch(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;//表示斐波那契分割数值的下标
        int mid = 0;
        int[] fib = fibonacci();
        //获得斐波那契分割值的下标
        while (high > fib[k] - 1) {
            k++;
        }
        int[] temp = Arrays.copyOf(arr, fib[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = temp[high];
        }
        //使用while循环查找val
        while (low <= high) {
            mid = low + fib[k - 1] - 1;
            if (val < temp[mid]) {//左边查找
                high = mid - 1;
                k--;
            } else if (val > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }

        }
        return -1;
    }
}
