package ysw;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/31 7:53
 * @Version
 **/
public class ComparableTest {
    public static void main(String[] args) {
        Goods[] goods = new Goods[5];
        goods[0] = new Goods("Lenovo", 20);
        goods[1] = new Goods("Dell", 32);
        goods[2] = new Goods("MI", 30);
        goods[3] = new Goods("HUAWEI", 40);
        goods[4] = new Goods("Apple", 50);
        Arrays.sort(goods);
//        System.out.println(Arrays.toString(goods));


        String[] arr=new String[] {"B","F","E","A","M","C"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //从大到小
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(arr));//[M, F, E, C, B, A]
    }
}
