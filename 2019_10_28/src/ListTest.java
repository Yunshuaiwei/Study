import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ProjectName 2019_10_28
 * @ClassName ListTest
 * Description
 * @Auther YunSW
 * @Date 2019/10/28 20:45
 * @Version 1.0
 **/
public class ListTest {

    @Test
    public void test(){
        ArrayList list =new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("wang",18));
        list.add(456);
        System.out.println(list.size());
        System.out.println(list.remove(1));
        System.out.println(list.size());
        System.out.println(list);
        list.add(1,"YSW");
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println("-----------------------------------------------------");
        list.add(1,456);
        System.out.println(list.indexOf(456));
        System.out.println(list.lastIndexOf(456));
        System.out.println(list);
        Object set = list.set(0, 1);
        System.out.println(set);
        System.out.println(list);
        List list1 = list.subList(3, 6);
        System.out.println(list1);
        System.out.println("-----------------------------------------------------");
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
