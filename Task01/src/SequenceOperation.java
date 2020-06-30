/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/30 19:05
 * @Version
 **/
public class SequenceOperation {
    public static void main(String[] args) {
        SequenceOperation s = new SequenceOperation();
        int[] arr = {5, 3, 9, 7, 6, 1, 2, 4, 8};
        int i = s.closeToAverage(arr);
        System.out.println(i);
    }

    /**
     * 读取数字序列
     *
     * @return java.lang.String：返回值为以逗号隔开的字符串
     * @Param [arr]
     **/
    public String readSequence(int[] arr) {
        if (arr == null || arr.length < 1) {
            return null;
        }
        String result = "";
        for (int i = 0; i < arr.length - 1; i++) {
            result += arr[i] + ",";
        }
        return result + arr[arr.length - 1];
    }

    /**
     * 反转序列
     *
     * @return void
     * @Param [arr]
     **/
    public void reverseArray(int[] arr) {
        int j = arr.length - 1;
        for (int i = 0; i < arr.length / 2; i++, j--) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }
    }

    /**
     * @return void
     * @Param arr：需要排列的数组
     * @Param left：左索引
     * @Param right：右索引
     **/
    public void sortSequence(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(l + r) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
            if (arr[l] == pivot) {
                r -= 1;
            }
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            sortSequence(arr, left, r);
        }//向右递归
        if (right > l) {
            sortSequence(arr, l, right);
        }
    }

    /**
     * 均值计算
     *
     * @return float
     * @Param [arr]
     **/
    public float average(int[] arr) {
        if (arr.length < 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (float) sum / arr.length;
    }

    /**
     * 查找最接近平均数的下标
     *
     * @return int
     * @Param [arr]
     **/
    public int closeToAverage(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        float v = average(arr);
        float flag = Math.abs(v - arr[0]);
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            float abs = Math.abs(v - arr[i]);
            if (abs <= flag) {
                result = i;
            }
        }
        return result;
    }
}
