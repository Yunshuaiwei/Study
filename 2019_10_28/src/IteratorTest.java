import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @ProjectName 2019_10_28
 * @ClassName IteratorTest
 * Description
 * @Auther YunSW
 * @Date 2019/10/28 16:37
 * @Version 1.0
 * <p>
 * 集合元素的遍历，使用迭代器 Iteraor接口
 **/
public class IteratorTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("abc");
        coll.add(456);
        coll.add(false);

        Iterator iterator = coll.iterator();
        //方法一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        //报异常：java.util.NoSuchElementException
//        System.out.println(iterator.next());
        //方法二：不推荐
//        for (int i = 0; i <coll.size() ; i++) {
//            System.out.println(iterator.next());
//        }
        //方法三：推荐
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("abc");
        coll.add(456);
        coll.add(false);
        coll.add("Tom");
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("------------------------------------");
        Iterator iterator1 = coll.iterator();
        while(iterator1.hasNext()){
            Object obj=iterator1.next();
            if("Tom".equals(obj)){
                //移除集合中的元素
                iterator1.remove();
                //iterator1.remove();   调用remove之后再调remove会报：java.lang.IllegalStateException
            }
        }
        Iterator iterator2 = coll.iterator();
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }
}
