import java.util.Date;

/**
 * @author DELL
 * @Date 2020/2/1 12:19
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int [] arr=new int[80000];
        for (int i = 0; i < 80000; i++) {
            int num = (int)(Math.random()*80000);
            arr[i]=num;
        }
        Date date = new Date();
        String s = date.toString();
        System.out.println("开始时间："+s);
        bubbleSort(arr);
        Date date2 = new Date();
        String s1 = date2.toString();
        System.out.println("结束时间："+s1);
    }

    public static void bubbleSort(int[] arr) {
        boolean flag = true;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }
}
