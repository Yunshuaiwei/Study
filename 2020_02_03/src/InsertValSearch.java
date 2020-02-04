/**
 * @author DELL
 * @Date 2020/2/4 13:14
 **/
public class InsertValSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int index = insertValueSearch(arr, 0, arr.length - 1, 1);
        System.out.println(index);
    }

    /**
     * 插值查找
     *
     * @param arr     查找的数组
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 查找的值
     * @return 若找到则返回索引，否则返回-1；
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) {//向右递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {//向左递归
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
