package jvm;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/20 16:18
 * @Version
 **/
public class JVMStackLook {
    public static void main(String[] args) {
        int [] array=new int[]{4,5,6,3,2};

    }

    public static void test(int [] array,int index){
        System.out.println(index);
        if(index<=2){
            return;
        }
        test(array,index-1);
    }
}
