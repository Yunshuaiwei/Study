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
 *
 *
 * 1、 Set接口当中没有额外定义新的方法，使用的都是Collection中声明的方法
 * 2、要求：向Set中添数据，其所在的类一定要重写hashCode（）和equals（）
 *          重写的hashCode（）和equals（）尽可能保持一致性：相等的对象必须具有相等的散列码。
 * 一、Set ：存储无序的、不可重复的数据
 *     1、无序性：不等于随机性,
 *        以HashSet为例：存储数据在底层数组中并非按照索引的顺序添加，而是根据数据的哈希值
 *     2、不可重复：保证添加的元素按照equals（）判断时，不能返回true。即：相同元素只能添加一个
 *二、添加元素的过程：以HashSet为例：
 *     >  我们向HashSet中添加元素a，首先调用它所在类的hashCode（）方法，计算a的哈希值，此哈希值接
 *       着通过计算出在HashSet层次数组中存放的位置（即：数组索引），判断数组此位置是否已经有元素，
 *       如果此位置上没有元素，则a添加成功；如果此位置有其他元素b（或以链表形式存在的多个元素），则
 *       比较元素a与元素b的哈希值：如果哈希值不相同则元素a添加成功，如果哈希值相同则调用a所在类的
 *       equals方法，若方法返回true，则元素添加失败，若返回false则添加成功。
 *     >  HashSet底层是数组加链表存储
 *
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
