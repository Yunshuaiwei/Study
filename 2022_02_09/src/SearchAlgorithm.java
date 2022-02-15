import java.util.Arrays;

/**
 * @author yunshuaiwei
 * @className SearchAlgorithm
 * @description: TODO
 * @date 2022/2/12 20:17
 */
public class SearchAlgorithm {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 5, 3, 9, 8, 6, 7, 2, 4};
        int i = BinarySearch(arr, 9);
        System.out.println(i);
    }

    /**
     * @author yunshuaiwei
     * @description 二分查找
     * @date 20:24 2022/2/12
     * @Param [arr, key]
     * @Return int
     */
    public static int BinarySearch(int[] arr, int key) {
        //排序
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (arr[mid] == key) {
                return key;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        throw new RuntimeException("查找失败");
    }
}
