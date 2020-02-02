import java.util.Arrays;
import java.util.Date;

/**
 * @author DELL
 * @Date 2020/2/1 14:02
 **/
public class SelectSort {
    public static void main(String[] args) {
        int [] arr=new int [80000];
        for (int i = 0; i < 80000; i++) {
            int num = (int)(Math.random()*80000);
            arr[i]=num;
        }
        Date date = new Date();
        String s1 = date.toString();
        System.out.println("排序前的时间："+s1);
        selectSort(arr);
        Date date1 = new Date();
        String s2 = date1.toString();
        System.out.println("排序后的时间："+s2);

//        int[] arr = {47, 24, 10, 9};
//        System.out.println("排序前：" + Arrays.toString(arr));
//        selectSort(arr);
//        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
