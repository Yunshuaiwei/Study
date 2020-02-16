package Algorithm;

/**
 * @author DELL
 * @Date 2020/2/16 16:30
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        int i = binarySearch(arr, 10);
        System.out.println(i);
    }

    /**
     * @param arr    需要查找的数组
     * @param target 查找的值
     * @return 找到返回下标，否则返回-1
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
