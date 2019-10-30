import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * @ProjectName 2019_10_28
 * @ClassName Set
 * Description
 * @Auther YunSW
 * @Date 2019/10/28 14:51
 * @Version 1.0
 **/
public class Set {
    @Test
    public void test(){
        Collection coll =new ArrayList();
        //add():
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add("Tom");
        coll.add(new Date());
        coll.add(new Person("Ysw",18));
        //size():
        //获取元素个数
//        System.out.println(coll.size());
        Collection coll1=new ArrayList();
        coll1.add("EE");
        coll1.add(345);
        //addAll(coll1):将coll1集合中的元素添加到当前的集合中
        coll.addAll(coll1);
//        System.out.println(coll.size());
//        System.out.println(coll);

        //isEmpty():判断当前集合是否为空
//        System.out.println(coll.isEmpty());
//        //clear():清空集合元素
//        coll.clear();
//        System.out.println(coll.isEmpty());
        boolean contains=coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains("Tom"));
        //Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals（）。
        System.out.println(coll.contains(new Person("Ysw",18)));
        System.out.println("--------------------------------------------");
        //containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合当中
        System.out.println(coll.containsAll(coll1));
        Collection coll2=Arrays.asList(123,3456);
        System.out.println(coll.containsAll(coll2));
    }
    @Test
    public void test2(){
        Collection coll =new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add(456);
        coll.add("Tom");
        coll.add(new Date());
        coll.add(new Person("Ysw",18));
        //remove(Object obj):
        System.out.println(coll);
        coll.remove("AA");
        coll.remove(new Person("Ysw",18));
        System.out.println(coll);
        Collection coll2=Arrays.asList(123,456,78);
        //removeAll(Collection coll2):从前集合当中移除college中所有元素
//        System.out.println(coll);
//        coll.removeAll(coll2);
//        System.out.println(coll);
        //retainAll(Collection coll2):交集：获取当前集合和coll集合的交集，并且返回给当前集合
        coll.retainAll(coll2);
        System.out.println(coll);
        System.out.println("----------------------------------------");
        //equals(Object obj):判断当前集合和形参集合元素是否相同；
        Collection coll3=Arrays.asList(123,456,78);
        System.out.println(coll2.equals(coll3));
        //hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());
        System.out.println("----------------------------------------");
        //集合转换为数组   toArray()
        Object[] arr = coll3.toArray();
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
        //iterator():返回Iterator接口的实例，用于遍历集合元素。
    }
}
