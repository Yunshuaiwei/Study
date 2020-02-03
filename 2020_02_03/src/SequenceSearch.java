/**
 * @author DELL
 * @Date 2020/2/3 17:53
 **/
public class SequenceSearch {
    public static void main(String[] args) {
        int[] arr = {3, 67, 2, 0, 9, 56, 35};
        int index = seqSearch(arr, 0);
        if (index == -1) {
            System.out.println("没有此元素！");
        } else {
            System.out.println("该元素下标为：" + index);
        }
    }
    /**
     * 找到一个满足要求的就返回下标，否则返回-1
     *
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
