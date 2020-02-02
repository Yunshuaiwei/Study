import java.util.Date;

/**
 * @author DELL
 * @Date 2020/2/1 16:27
 **/
public class InsertSort {
    public static void main(String[] args) {
        int [] arr=new int [80000];
        for (int i = 0; i < 80000; i++) {
            int num = (int)(Math.random()*80000);
            arr[i]=num;
        }
        Date date = new Date();
        String s1 = date.toString();
        System.out.println("排序前的时间："+s1);
        insertSort(arr);
        Date date1 = new Date();
        String s2 = date1.toString();
        System.out.println("排序后的时间："+s2);
    }
    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            //要找的位置
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex+1!=i){
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
}
