import java.util.Arrays;

/**
 * @author yunshuaiwei
 * @version 1.0
 */
public class SortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 3, 1, 0, 9, 8, 4, 2, 7};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     *
     * @author yunshuaiwei
     * @date 2023/2/7 8:57
     **/
    public static void insertSort(int[] arr) {
        int length = arr.length;
        int j;
        for (int i = 1; i < length; i++) {
            int temp = arr[i];
            if (arr[i] < arr[i - 1]) {
                for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
            }
        }
    }

    /**
     * 冒泡
     *
     * @author yunshuaiwei
     * @date 2023/2/7 9:10
     **/
    public static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 快排
     *
     * @author yunshuaiwei
     * @date 2023/2/7 9:33
     **/
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }
    }

    /**
     * 对数组进行划分
     *
     * @author yunshuaiwei
     * @date 2023/2/7 9:26
     **/
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] > pivot) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] < pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}