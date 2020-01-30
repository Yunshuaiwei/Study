/**
 * @author DELL
 * @Date 2020/1/30 15:34
 **/
public class RecursionTest {
    public static void main(String[] args) {
        test(5);
        int res = factorial(3);
        System.out.println("res="+res);
    }
    public static void test(int n){
        if(n>2){
            test(n-1);
        }
        System.out.println("n="+n);
    }

    /**
     * 阶乘问题
     * @param n
     * @return
     */
    public static int factorial(int n){
        if(n==1){
            return 1;
        }else{
            return factorial(n-1)*n;
        }
    }
}
