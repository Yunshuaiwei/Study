import java.util.ArrayList;

/**
 * @author DELL
 * @Date 2020/2/3 18:07
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 89, 89, 1000, 1234};
        ArrayList<Integer> index = binarySearch(arr, 0, arr.length - 1, 89);
        System.out.println(index);
    }

    /**
     * 二分查找
     *
     * @param arr   需要查找的数组
     * @param left  左边的索引
     * @param right 右边的索引
     * @param val   需要查找的值
     * @return 找到返回集合，没有找到则返回空
     */
    public static ArrayList<Integer> binarySearch(int[] arr, int left, int right, int val) {
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (midVal > val) {//向左递归
            return binarySearch(arr, left, mid - 1, val);
        } else if (midVal < val) {//向右递归
            return binarySearch(arr, mid + 1, right, val);
        } else {
            ArrayList<Integer> resultIndex = new ArrayList<>();
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == val) {
                resultIndex.add(temp);
                temp--;
            }
            resultIndex.add(mid);
            temp = mid + 1;
            while (temp < arr.length && arr[temp] == val) {
                resultIndex.add(temp);
                temp++;
            }
            return resultIndex;
        }
    }
}
