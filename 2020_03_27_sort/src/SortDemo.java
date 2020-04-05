import java.util.Arrays;

/**
 * @author DELL
 * @Date 2020/3/27 10:49
 **/
public class SortDemo {
    public static void main(String[] args) {
        int[] arr = {3, 8, 2, 6, 5, 7, 1, 4, 0, 9};
//        insertSort(arr);
//        shellSort(arr);
//        selectSort(arr);
        quickSort(arr,0,arr.length);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 插入排序
     *
     * @param array 需要排序的数组
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int end = i - 1;
            //找插入的位置
            while (end >= 0 && key < array[end]) {
                //向后搬移元素
                array[end + 1] = array[end];
                end--;
            }
            //插入元素
            array[end + 1] = key;
        }
    }

    /**
     * 希尔排序
     *
     * @param array 需要排序的数组
     */
    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            gap = gap / 3 + 1;
            for (int i = gap; i < array.length; i++) {
                int key = array[i];
                int end = i - gap;
                while (end >= 0 && key < array[end]) {
                    array[end + gap] = array[end];
                    end -= gap;
                }
                array[end + gap] = key;
            }
        }
    }

    /**
     * 选择排序
     * @param arr 需要排序的数组
     */
    public static void selectSort(int [] arr){
        //arr.length - 1的原因是最后一个元素不需要找位置
        for (int i = 0; i < arr.length - 1; i++) {
            //标记最大元素的位置
            int maxPos=0;
            for (int j = 1; j < arr.length-i; j++) {
                //如果该位置的元素比maxPos标记处的元素大，则重新标记maxPos
                if(arr[j]>arr[maxPos]){
                    maxPos=j;
                }
            }
            //交换，将最大的元素放到他应该在的位置
            if(arr.length-1-i!=maxPos){
                arr[arr.length-1-i]^=arr[maxPos];
                arr[maxPos]^=arr[arr.length-1-i];
                arr[arr.length-1-i]^=arr[maxPos];
            }
        }
    }

    /**
     * 选择排序优化，一趟循环既可以找最大元素也可以找最小元素
     * @param arr 需要排序的数组
     */
    public static void selectSortOP(int [] arr){
        int begin=0,end=arr.length-1;
        while(begin<end){



        }
    }
    /**
     * 快排
     * @Param [arr, left, right]
     * @return void
     **/
    public static void quickSort(int []arr,int left,int right){
        if(right-left>1){
            //找划分的基准值
            int div=position(arr,left,right);
            //递归排基准值的左半部分
            quickSort(arr,left,div);
            //递归排基准值的右半部分
            quickSort(arr,div+1,right);
        }
    }
    /**
     * 找划分区间的基准值
     * @Param [arr, left, right]
     * @return int：表示基准值的下标
     **/
    private static int position(int [] arr,int left,int right){
        int l=left;
        int r=right-1;
        int div=arr[r];
        while(l<r){
            while(l<r&&arr[l]<=div){
                l++;
            }
            while(l<r&&arr[r]>=div){
                r--;
            }
            if(l<r){
                arr[l]^=arr[r];
                arr[r]^=arr[l];
                arr[l]^=arr[r];
            }
        }
        if(l!=right-1){
            arr[right-1]^=arr[l];
            arr[l]^=arr[right-1];
            arr[right-1]^=arr[l];
        }
        return l;
    }

}
