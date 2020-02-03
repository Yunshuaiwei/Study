import java.util.Arrays;

/**
 * @author DELL
 * @Date 2020/2/3 16:24
 **/
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 基数排序
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {
        //得到数组中的最大位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //最大数的位数
        int maxLength = (max + "").length();
        for (int k = 0, n = 1; k < maxLength; k++, n *= 10) {
            //定义二维数组，每个一维数组表示一个桶
            int[][] bucket = new int[10][arr.length];
            //记录每个桶中实际放入的元素个数
            int[] bucketElementCounts = new int[10];
            for (int i = 0; i < arr.length; i++) {
                int digitOfElement = arr[i] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
                bucketElementCounts[digitOfElement]++;
            }
            //遍历每一个桶，将数据放入原数组
            int index = 0;
            for (int i = 0; i < bucket.length; i++) {
                //若桶中有数据我们才放入原数组
                if (bucketElementCounts[i] != 0) {
                    for (int j = 0; j < bucketElementCounts[i]; j++) {
                        arr[index++] = bucket[i][j];
                    }
                }
                bucketElementCounts[i] = 0;
            }
        }
    }
}
