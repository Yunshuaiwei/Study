
/**
 * @author DELL
 * @Date 2020/1/31 12:44
 **/
public class EightQueensProblemRecursive {
    int queens=8;
    //定义数组用于保存皇后摆放位置的结果
    int[] array=new int[queens];
    static int count=0;
    public static void main(String[] args) {
        EightQueensProblemRecursive e = new EightQueensProblemRecursive();
        e.check(0);
        System.out.printf("一共有%d中解法！",count);
    }

    /**
     * 摆放皇后
     * @param n
     */
    private void check(int n){
        if(n==queens){//当n等于8时说明8个皇后已经放好
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < queens; i++) {
            //将当前这个皇后n放到该行的第i列
            array[n]=i;
            //判断当前位置是否冲突
            if(judge(n)){//不冲突
                //接着放n+1个皇后
                check(n+1);
            }
        }
    }
    /**
     * 判断是否冲突
     * @param n
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                    return false;
            }
        }
        return true;
    }
    /**
     * 打印皇后的摆放结果
     */
    public void print(){
        count ++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
