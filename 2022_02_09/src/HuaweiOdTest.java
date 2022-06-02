import java.util.*;

/**
 * @author yunshuaiwei
 * @className HuaweiOdTest
 * @description: TODO
 * @date 2022/6/2 15:50
 */
public class HuaweiOdTest {

    /**
     * @author yunshuaiwei
     * @description 计算最后一个字符串的长度
     * @date 15:56 2022/6/2
     * @Param []
     * @Return void
     */
    public void stringLastOfSize() {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String[] s = str.split(" ");
        int i = s[s.length - 1].length();
        System.out.println(i);
    }

    /**
     * @author yunshuaiwei
     * @description 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
     * @date 15:57 2022/6/2
     * @Param []
     * @Return void
     */
    public static void outPutCharNumber() {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine().toUpperCase();
        String s = input.nextLine().toUpperCase();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                Integer integer = map.get(c) + 1;
                map.put(c, integer);
            }
        }
        if (!map.containsKey(s.charAt(0))) {
            System.out.println(0);
            return;
        }
        System.out.println(map.get(s.charAt(0)));
    }

    /**
     * @author yunshuaiwei
     * @description 明明生成了NN个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
     * @date 16:12 2022/6/2
     * @Param []
     * @Return void
     */
    public static void randomNumRemoveDuplication() {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < number; i++) {
            int num = input.nextInt();
            set.add(num);
        }
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }

    /**
     * @author yunshuaiwei
     * @description 输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
     * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
     * @date 16:20 2022/6/2
     * @Param []
     * @Return void
     */
    public static void inputStringLengthEqual8() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.length() == 0 || line.equals(" ")) {
                continue;
            }
            StringBuilder str = new StringBuilder(line);
            StringBuilder s = new StringBuilder();
            int len = str.length();
            if (len % 8 != 0) {
                int i = 8 - len % 8;
                for (int j = 0; j < i; j++) {
                    str.append("0");
                }
            }
            String s1 = str.toString();
            while (s1.length() > 0) {
                System.out.println(s1.substring(0, 8));
                s1 = s1.substring(8);
            }
        }
    }

    /**
     * @author yunshuaiwei
     * @description 十六进制转十进制
     * @date 17:01 2022/6/2
     * @Param []
     * @Return void
     */
    public static void hexDec() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String hex = sc.nextLine();
            System.out.println(Integer.parseInt(hex.substring(2), 16));
        }
    }


    /**
     * @author yunshuaiwei
     * @description 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
     * @date 17:04 2022/6/2
     * @Param []
     * @Return void
     */
    public static void inputPrimeFactor() {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int y = 2;
        while (target != 1) {
            if (target % y == 0) {
                System.out.print(y + " ");
                target /= y;
            } else {
                if (y > target / y) {
                    y = target;
                } else {
                    y++;
                }
            }
        }
    }

    /**
     * @author yunshuaiwei
     * @description 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整。
     * @date 17:28 2022/6/2
     * @Param []
     * @Return void
     */
    public static void method01() {
        Scanner scanner = new Scanner(System.in);
        float f = scanner.nextFloat();
        int i = (int) f;
        if ((f - i) >= 0.5) {
            System.out.println((int) f + 1);
        } else {
            System.out.println((int) f);
        }
    }

    /**
     * @author yunshuaiwei
     * @description 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，
     * 即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
     * @date 17:37 2022/6/2
     * @Param []
     * @Return void
     */
    public static void indexOfValueSum() {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        scanner.nextLine();
        String[] strs = new String[i];
        for (int j = 0; j < i; j++) {
            strs[j] = scanner.nextLine();
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (String str : strs) {
            String[] s = str.split(" ");
            int key = Integer.parseInt(s[0]);
            int val = Integer.parseInt(s[1]);
            if (!map.containsKey(key)) {
                map.put(key, val);
            } else {
                Integer integer = map.get(key);
                map.put(key, integer + val);
            }
        }
        for (Integer integer : map.keySet()) {
            System.out.println(integer + " " + map.get(integer));
        }
    }

    /**
     * @author yunshuaiwei
     * @description 输入一个数，从右往左打印去重后的数据
     * @date 18:10 2022/6/2
     * @Param []
     * @Return void
     */
    public static void reverseInt() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (!list.contains(str.charAt(i))) {
                list.add(str.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        for (Character character : list) {
            res.append(character);
        }
        System.out.println(res.toString());
    }

    public static void main(String[] args) {
        reverseInt();
    }

}
