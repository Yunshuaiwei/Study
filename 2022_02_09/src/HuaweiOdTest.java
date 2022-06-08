import java.util.*;
import java.util.regex.Pattern;

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

    /**
     * @author yunshuaiwei
     * @description 编写一个函数，计算字符串中含有的不同字符的个数。
     * 字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
     * @date 0:51 2022/6/3
     * @Param []
     * @Return void
     */
    public static void charsNum() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        System.out.println(set.size());
    }


    /**
     * @author yunshuaiwei
     * @description 输入一个整数，将这个整数以字符串的形式逆序输出
     * @date 21:47 2022/6/3
     * @Param []
     * @Return void
     */
    public static void intToStringReverse() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        StringBuilder builder = new StringBuilder(String.valueOf(num));
        System.out.println(builder.reverse().toString());
    }

    /**
     * @author yunshuaiwei
     * @description 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
     * @date 21:50 2022/6/3
     * @Param []
     * @Return void
     */
    public static void reverseString() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder builder = new StringBuilder(s);
        System.out.println(builder.reverse().toString());
    }

    /**
     * @author yunshuaiwei
     * @description 输入一个字符串以空格隔开，反转之后并输出
     * @date 22:12 2022/6/3
     * @Param []
     * @Return void
     */
    public static void reverseWord() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Stack<String> stack = new Stack<>();
        String[] strs = str.split(" ");
        for (String s : strs) {
            stack.push(s);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }


    /**
     * @author yunshuaiwei
     * @description 给定 n 个字符串，请对 n 个字符串按照字典序排列。
     * @date 22:12 2022/6/3
     * @Param []
     * @Return void
     */
    public static void stringSort() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < num; i++) {
            String s = scanner.nextLine();
            list.add(s);
        }
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }


    /**
     * @author yunshuaiwei
     * @description 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
     * @date 22:19 2022/6/3
     * @Param []
     * @Return void
     */
    public static void method02() {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int num = 0;
        while (i != 0) {
            if ((i & 1) == 1) {
                num++;
            }
            i = i >> 1;
        }
        System.out.println(num);
    }

    /**
     * @author yunshuaiwei
     * @description HJ16 购物单
     * @date 22:31 2022/6/3
     * @Param []
     * @Return void
     */
    public static void method03() {
        Scanner scanner = new Scanner(System.in);
        //总钱数
        int N = scanner.nextInt();

        int m = scanner.nextInt();
        int[][] dp = new int[m][3];
        for (int i = 0; i < m; i++) {
            dp[i][0] = scanner.nextInt();
            dp[i][1] = scanner.nextInt();
            dp[i][2] = scanner.nextInt();
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * @author yunshuaiwei
     * @description HJ17 坐标移动
     * @date 11:56 2022/6/8
     * @Param []
     * @Return void
     */
    public static void method04() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] split = str.split(";");
        int x = 0;
        int y = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        String pattern = "[ADWS]\\d{1}\\d?";
        for (String s : split) {
            if (s.matches(pattern)) {
                map.put(s.charAt(0), map.getOrDefault(s.charAt(0), 0) + Integer.parseInt(s.substring(1)));
            }
        }
        x = x - map.get('A') + map.get('D');
        y = y - map.get('S') + map.get('W');
        System.out.println(x + "," + y);
    }


    /**
     * @author yunshuaiwei
     * @description HJ18：识别有效的IP地址和掩码并进行分类统计
     * @date 12:27 2022/6/8
     * @Param []
     * @Return void
     */
    public static void method05() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if (s.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            if (getMatch(s)) {
                System.out.println("NG");
                continue;
            }
            if (getString(s, 0, 3)) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }

    /**
     * @author yunshuaiwei
     * @description 校验是否有重复子串
     * @date 12:46 2022/6/8
     * @Param [str, l, r]
     * @Return boolean
     */
    private static boolean getString(String str, int l, int r) {
        if (r >= str.length()) {
            return false;
        }
        if (str.substring(r).contains(str.substring(l, r))) {
            return true;
        } else {
            return getString(str, l + 1, r + 1);
        }
    }

    /**
     * @author yunshuaiwei
     * @description 正则匹配
     * @date 12:42 2022/6/8
     * @Param [str]
     * @Return boolean
     */
    private static boolean getMatch(String str) {
        int count = 0;
        Pattern p1 = Pattern.compile("[A-Z]");
        if (p1.matcher(str).find()) {
            count++;
        }
        Pattern p2 = Pattern.compile("[a-z]");
        if (p2.matcher(str).find()) {
            count++;
        }
        Pattern p3 = Pattern.compile("[0-9]");
        if (p3.matcher(str).find()) {
            count++;
        }
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
        if (p4.matcher(str).find()) {
            count++;
        }
        return count < 3;
    }

    /**
     * @author yunshuaiwei
     * @description HJ21：简单密码
     * @date 15:27 2022/6/8
     * @Param []
     * @Return void
     */
    public static void method06() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("abc", 2);
        map.put("def", 3);
        map.put("ghi", 4);
        map.put("jkl", 5);
        map.put("mno", 6);
        map.put("pqrs", 7);
        map.put("tuv", 8);
        map.put("wxyz", 9);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c < 'Z') {
                System.out.print((char) (c + 33));
            } else if (c == 'Z') {
                System.out.print((char) (c + 7));
            } else if (c >= 'a' && c < 'z') {
                String key = map.keySet().stream().filter(o -> o.contains(Character.toString(c))).findAny().get();
                System.out.print(map.get(key));
            } else {
                System.out.print(c);
            }
        }
    }

    /**
     * @author yunshuaiwei
     * @description HJ22 汽水瓶
     * @date 15:49 2022/6/8
     * @Param []
     * @Return void
     */
    public static void method07() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            int res = 0;
            while (num > 2) {
                int i = num / 3;
                res += i;
                num = num % 3 + i;
            }
            if (num == 2) {
                System.out.println(res + 1);
            } else {
                System.out.println(res);
            }
        }
    }

    public static void main(String[] args) {
        method07();
    }

}
