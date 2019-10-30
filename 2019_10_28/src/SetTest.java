import org.junit.jupiter.api.Test;

import java.awt.print.PrinterGraphics;
import java.util.*;

/**
 * @ProjectName 2019_10_28
 * @ClassName SetTest
 * Description
 * @Auther YunSW
 * @Date 2019/10/29 13:54
 * @Version 1.0
 **/
public class SetTest {
    @Test
    public void test(){
        HashSet set=new HashSet();
        set.add(123);
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("BB");
        set.add("CCCCC");
        set.add(new Person("haha",18));
        set.add(new Person("haha",18));
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        //LinkedHashSet（）作为HashSet的子类，在添加数据时，每个数据还
        // 维护了两个引用，构建了一个链表，便于频繁的遍历操作
        HashSet set=new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("BB");
        set.add("CCCCC");
        set.add(new Person("haha",18));
        set.add(new Person("haha",18));
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test3(){
        /**
         * 1、向TreeSet中添加数据要添加相同类的对象
         * 2、两种排序方式：自然排序   定制排序
         */
        TreeSet set=new TreeSet();
//        set.add(123);
//        set.add(123);
//        set.add(3);
//        set.add(4);
//        set.add(7);

        set.add(new Person("Tom",18));
        set.add(new Person("Jack",16));
        set.add(new Person("Jim",20));
        set.add(new Person("Tom",19));
        set.add(new Person("Jerry",30));
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test4(){
        Comparator com=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person&& o2 instanceof Person){
                    Person p1=(Person)o1;
                    Person p2=(Person)o2;
                    return Integer.compare(p1.getAge(),p2.getAge());
                }else{
                    throw new RuntimeException("输入的数据类型不匹配！");
                }
            }
        };
        TreeSet set=new TreeSet(com);
        set.add(new Person("Tom",18));
        set.add(new Person("Jack",16));
        set.add(new Person("Jim",20));
        set.add(new Person("Tom",19));
        set.add(new Person("Jerry",30));
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
