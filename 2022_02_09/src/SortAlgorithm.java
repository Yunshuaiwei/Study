import java.util.Arrays;

/**
 * @author yunshuaiwei
 * @className SortAlgorithm
 * @description: TODO
 * @date 2022/2/19 14:16
 */
public class SortAlgorithm {


    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 8, 0, 1, 9, 7, 5, 3, 6};
//        insertSort(arr);
//        shellSort(arr);
//        bubbleSort(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @author yunshuaiwei
     * @description 插入排序
     * @date 14:16 2022/2/19
     * @Param [arr]
     * @Return void
     */
    public static void insertSort(int[] arr) {
        int tmp, j;
        for (int i = 1; i < arr.length; i++) {
            tmp = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > tmp; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
        }
    }

    /**
     * @author yunshuaiwei
     * @description shell排序
     * @date 14:52 2022/2/19
     * @Param [arr]
     * @Return void
     */
    public static void shellSort(int[] arr) {
        int d, i, j, tmp;
        for (d = arr.length / 2; d >= 1; d /= 2) {
            for (i = d; i < arr.length; i++) {
                tmp = arr[i];
                for (j = i - d; j >= 0 && arr[j] > tmp; j -= d) {
                    //移动元素
                    arr[j + d] = arr[j];
                }
                arr[j + d] = tmp;
            }
        }
    }

    /**
     * @author yunshuaiwei
     * @description 冒泡排序
     * @date 11:56 2022/2/21
     * @Param [arr]
     * @Return void
     */
    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            boolean flag = true;
            for (int j = length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }

    /**
     * @author yunshuaiwei
     * @description 快排
     * @date 12:14 2022/2/21
     * @Param [arr, low, high]
     * @Return void
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            //划分左子表
            quickSort(arr, low, partition - 1);
            //划分右子表
            quickSort(arr, partition + 1, high);
        }
    }

    /**
     * @author yunshuaiwei
     * @description 调整区间元素的位置
     * @date 12:20 2022/2/21
     * @Param [arr, low, high]
     * @Return int
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }


}
