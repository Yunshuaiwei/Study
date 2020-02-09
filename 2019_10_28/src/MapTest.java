import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.Set;

/**
 * @ProjectName 2019_10_28
 * @ClassName MapTest
 * Description
 * @Auther YunSW
 * @Date 2019/10/29 16:22
 * @Version 1.0
 * 集合Map实现类
 *     |----Map：双列数据，存储key---value对的数据
 *          |----HashMap：作为Map的主要实现类；线程不安全，效率高；可以存储null的key或value
 *               |----LinkedHashMap：能够保证遍历Map元素时，可以按照添加的顺序实现遍历。
 *                                 原因：在原来的hHashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素
 *                                       对于频繁的遍历操作，此类执行效率比较高。
 *          |----TreeMap：保证按照添加的 key--value 对进行排序，实现排序遍历。（此时考虑key的自然排序和定制排序）
 *                        底层使用红黑树
 *          |----Hashtable：作为古老实现类；线程安全，效率高低
 *               |----Properties：常用来处理配置文件。key 和 value都是String类型
 *
 *        HashMap的底层：数组+链表   （jdk7及之前）
 *                       数组+链表+红黑树（jdk 8）
 *二、Map结构的理解：
 *    Map中的key：无序的、不可重复的，使用Set进行存储key     --->key所在的类要
 *                重写equals（）和hashCode（）方法（以HashMap为例）
 *    Map中的value：无序的、可重复的，使用Collection存储所有的value
 *    一个键值对：key-value构成了一个Entry对象。
 *    Map中的entry：无序的、不可重复的，使用Set存储所有entry。
 *三、HashMap的底层实现原理：以jdk 7为例说明：
 *          HashMap map = new HashMap（）：
 *          在实例化以后，底层创建了长度是16的一维数组Entry[] table
 *          ...已经执行过多次put...
 *          map.put(key1,value1)：
 *                  > 首先，调用key1所在类的hashCode（）计算key1哈希值，此时哈希值经过某
 *                    种算法计算以后，得到在Entry数组中的存放位置。
 *                    如果此位置上位置为空，则key1和value1添加成功。----->情况一
 *                    如果此位置不为空，即此位置上有一个或多个（以链表形式存在）数据，比
 *                        较key1和已经存在的一个或多个数据的哈希值：
 *                            如果key1的哈希值与已经存在的哈希值都不相同，此时key1--value1添加成功。---->情况二
 *                            如果key1的哈希值和已经存在的某一个元素的哈希值相同，继续比较：调用key1
 *                                  所在类的equals（）方法，比较：
 *                                           如果equals（）方法返回false：此时key1--value1添加成功 ---->情况三
 *                                           如果equals（）返回true：使用value替换相同key的value值。
 *            补充：关于情况二和情况三：此时key1-value1和原来的数以链表的方式存储。
 *
 *            在不断添加过程中，会涉及到扩容，默认的扩容方式为：扩容为原来的2倍，并将原来的数据复制过来
 *
 *            jdk 8 相较于jdk 7在底层实现方面的不同：
 *            1、new HashMap （）：底层没有创建一个长度为16的数组
 *            2、jdk 8底层的数组是：Node[]，而不是Entry[]
 *            3、首次调用put()方法时，底层创建长度为16 的数组
 *            4、jdk 7底层结构只有：数组+链表，jdk 8中底层结构是 数组+链表+红黑树
 *               > 当数组的某一个索引的位置上的元素以链表形式存在的数据个数>8且当前
 *                 数组的长度超过>64时，此时索引位置上的所有数据改为红黑树存储。
 * 四、Map中定义的方法：（HashMap为例）
 *
 **/
public class MapTest {
    @Test
    public void MapTest(){
//        Map map=new Hashtable();
        Map map=new HashMap();
        //添加
        map.put("AA",123);
        map.put("BB",456);
        map.put("CC",789);
        //修改
        map.put("AA",23);
        System.out.println(map);
        Map map1=new HashMap();
        map1.put("DD",123);
        map1.put("EE",456);
        map.putAll(map1);
        System.out.println(map);
        //remove(Object key)
        Object value = map.remove("AA");
        System.out.println(value);
        System.out.println(map);
    }
    @Test
    public void test1(){
        Map map=new HashMap();
        map.put("AA",123);
        map.put("BB",456);
        map.put("CC",789);
        //get(Object key);
        System.out.println(map.get("AA"));
        //containsKey(Object key):
        boolean key = map.containsKey("AA");
        System.out.println(key);
        //
        boolean value = map.containsValue(123);
        System.out.println(value);
    }
    @Test
    public void test2(){
        Map map=new HashMap();
        map.put("AA",123);
        map.put("BB",456);
        map.put("CC",789);
        //遍历所有的key集：keySet（）
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("------------------------------------------");
        //遍历所有的value集：values()
        Collection values = map.values();
        for (Object obj:values) {
            System.out.println(obj);
    }
        //遍历所有key-values  entrySet();
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while(iterator1.hasNext()){
            Object obj=iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry= (Map.Entry) obj;
            System.out.println(entry.getKey()+"---->"+entry.getValue());
        }
//        System.out.println(map);
    }
}
