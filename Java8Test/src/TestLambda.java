import org.junit.Test;

import java.io.PrintStream;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2021/7/26 22:01
 * @Version
 **/
public class TestLambda {

    /**
     * @return void
     * @Param
     * @Date 22:04 2021/7/26
     * @Description: 匿名内部类
     **/
    @Test
    public void test1() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }

    /**
     * @return void
     * @Param
     * @Date 22:06 2021/7/26
     * @Description: Lambda表达式
     **/
    @Test
    public void test2() {
        Comparator<Integer> com = (a, b) -> Integer.compare(a, b);
        TreeSet<Integer> treeSet = new TreeSet<>(com);
    }

    @Test
    public void test3() {
        Runnable r = () -> System.out.println("run()");
        r.run();

        Consumer<String> con = x -> System.out.println(x);
        con.accept("Hello!");

        Comparator<Integer> com = (x, y) -> {
            System.out.println("Lambda！");
            return Integer.compare(x, y);
        };
    }

    @Test
    public void test4() {
        happy(100, a -> System.out.println("消费" + a + "元"));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test5() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer integer : numList) {
            System.out.println(integer);
        }
    }

    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            //get方法
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }

    @Test
    public void test6() {
        String str = strHandler("   Hello   ", String::trim);
        System.out.println(str);
    }

    private String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    @Test
    public void test7() {
        List<String> list = Arrays.asList("hello", "Lambda", "ok", "word");
        List<String> o = filterStr(list, s -> s.contains("o"));
        for (String s : o) {
            System.out.println(s);
        }
    }

    private List<String> filterStr(List<String> list, Predicate<String> pre) {
        ArrayList<String> strings = new ArrayList<>();
        for (String s : list) {
            //test方法
            if (pre.test(s)) {
                strings.add(s);
            }
        }
        return strings;
    }

    @Test
    public void test8(){
        PrintStream print = System.out;
        Consumer<String> con=x->print.println(x);

        Consumer<String> cons= print::println;

        Consumer<String> consu= System.out::println;

        consu.accept("Hello");
    }

    @Test
    public void test9(){
        Comparator<Integer> com=(x,y)->Integer.compare(x,y);

        Comparator<Integer> com1=Integer::compare;

        int compare = com1.compare(2, 1);

        System.out.println(compare);
    }

    public static void main(String[] args) {
        int i=9;
        switch (i){
            default:
                System.out.println("de");
            case 0:
                System.out.println("0");
                break;
            case 1:
                System.out.println("1");
                break;
        }

    }


}


