package ysw;

import java.util.ArrayList;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/31 9:24
 * @Version
 **/
public class GenericTest {
    public static void main(String[] args) {
        //用于表示学生成绩
        ArrayList<Integer> list = new ArrayList();
        list.add(80);
        list.add(90);
        list.add(86);
        for (Integer score : list) {
            System.out.println(score);
        }
    }
}
