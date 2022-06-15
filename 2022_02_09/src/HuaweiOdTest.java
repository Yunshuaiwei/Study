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


    /**
     * @author yunshuaiwei
     * @description HJ23：实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。
     * 输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
     * @date 16:48 2022/6/10
     * @Param []
     * @Return void
     */
    public static void deleteString() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int min = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            map.put(s.charAt(i), map.getOrDefault(key, 0) + 1);
        }
        for (Character key : map.keySet()) {
            Integer val = map.get(key);
            if (val < min) {
                min = val;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == min) {
                continue;
            }
            res.append(c);
        }
        System.out.println(res.toString());
    }


    /**
     * @author yunshuaiwei
     * @description HJ27 查找兄弟单词
     * @date 20:11 2022/6/13
     * @Param []
     * @Return void
     */
    public static void method08() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(strings).subList(1, strings.length - 2));
        s = strings[strings.length - 2];
        int key = Integer.parseInt(strings[strings.length - 1]);
        ArrayList<String> res = new ArrayList<>();
        for (String str : list) {
            if (judgeIsBrotherWords(s, str)) {
                res.add(str);
            }
        }
        Collections.sort(res);
        System.out.println(res.size());
        if (key > 0 && key <= res.size()) {
            System.out.println(res.get(key - 1));
        }
    }

    /**
     * @author yunshuaiwei
     * @description 判断两个字符串是否为兄弟字符串，例ab的兄弟串是ba
     * @date 21:12 2022/6/13
     * @Param [str, target]
     * @Return java.lang.Boolean
     */
    private static Boolean judgeIsBrotherWords(String str, String target) {
        if (str.equals(target) || str.length() != target.length()) {
            return false;
        }
        char[] chars1 = str.toCharArray();
        char[] chars2 = target.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.toString(chars1).equals(Arrays.toString(chars2));
    }

    /**
     * @author yunshuaiwei
     * @description HJ28 素数伴侣
     * @date 21:14 2022/6/13
     * @Param []
     * @Return void
     */
    public static void primeMate() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] ints = new int[num];
        for (int i = 0; i < num; i++) {
            ints[i] = scanner.nextInt();
        }
    }

    /**
     * @author yunshuaiwei
     * @description 判断该数字是否为素数
     * @date 21:13 2022/6/13
     * @Param [num]
     * @Return boolean
     */
    private static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * @author yunshuaiwei
     * @description HJ29 字符串加解密
     * @date 21:39 2022/6/13
     * @Param []
     * @Return void
     */
    public static void stringEnAndDecode() {
        Scanner scanner = new Scanner(System.in);
        String ciphertext = scanner.nextLine();
        String plaintext = scanner.nextLine();
        System.out.println(stringEncrypt(ciphertext));
        System.out.println(stringDecode(plaintext));
    }


    /**
     * @author yunshuaiwei
     * @description 字符串加密
     * @date 21:24 2022/6/13
     * @Param [str]
     * @Return java.lang.String
     */
    private static String stringEncrypt(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                if (c == '9') {
                    res.append(0);
                } else {
                    c += 1;
                    res.append((char) c);
                }
            } else if (c >= 'A' && c <= 'z') {
                if (c == 'Z') {
                    res.append('a');
                } else if (c == 'z') {
                    res.append('A');
                } else {
                    c += 1;
                    if (c < 97) {
                        res.append((char) (c + 32));
                    } else {
                        res.append((char) (c - 32));
                    }
                }
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    /**
     * @author yunshuaiwei
     * @description 字符串解密
     * @date 21:41 2022/6/13
     * @Param [str]
     * @Return java.lang.String
     */
    private static String stringDecode(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                if (c == '0') {
                    res.append(9);
                } else {
                    c -= 1;
                    res.append((char) c);
                }
            } else if (c >= 'A' && c <= 'z') {
                if (c == 'a') {
                    res.append('Z');
                } else if (c == 'A') {
                    res.append('z');
                } else {
                    c -= 1;
                    if (c >= 97) {
                        res.append((char) (c - 32));
                    } else {
                        res.append((char) (c + 32));
                    }
                }
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    /**
     * @author yunshuaiwei
     * @description HJ30 字符串合并处理
     * @date 10:51 2022/6/14
     * @Param []
     * @Return void
     */
    public static void stringMerge() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder str1 = new StringBuilder(scanner.next());
        StringBuilder str2 = new StringBuilder(scanner.next());
        String str = str1.toString() + str2;
        str1 = new StringBuilder();
        str2 = new StringBuilder();
        //取字符串的奇偶位
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {//偶数位
                str1.append(str.charAt(i));
            } else {
                str2.append(str.charAt(i));
            }
        }
        //排序
        char[] chars1 = str1.toString().toCharArray();
        char[] chars2 = str2.toString().toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        //组合
        int j = 0;
        str1 = new StringBuilder();
        for (char c : chars1) {
            str1.append(c);
            if (j < chars2.length) {
                str1.append(chars2[j++]);
            }
        }
        str = str1.toString();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c > 'F' && c <= 'Z') || (c > 'f' && c <= 'z')) {
                System.out.print(String.valueOf(c));
            } else {
                //转十六进制
                int num = Integer.parseInt(String.valueOf(c), 16);
                //以二进制打印
                String s = Integer.toString(num, 2);
                //格式化
                StringBuilder builder = new StringBuilder(String.format("%04d", Integer.valueOf(s)));
                //反转二进制
                s = builder.reverse().toString();
                //十进制
                num = Integer.parseInt(s, 2);
                //转16进制
                s = Integer.toString(num, 16).toUpperCase();
                System.out.print(s);
            }
        }
    }

    /**
     * @author yunshuaiwei
     * @description HJ31 单词倒排
     * @date 11:06 2022/6/14
     * @Param []
     * @Return void
     */
    public static void wordsReverse() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Stack<String> stack = new Stack<>();
        String[] strings = str.split(" ");
        for (String s : strings) {
            StringBuilder tmp = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c >= 'A' && c <= 'z') {
                    tmp.append(c);
                } else {
                    if (tmp.length() != 0) {
                        stack.push(tmp.toString());
                        tmp = new StringBuilder();
                    }
                }
            }
            if (tmp.length() != 0) {
                stack.push(tmp.toString());
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }


    /**
     * @author yunshuaiwei
     * @description HJ32 密码截取
     * @date 11:47 2022/6/14
     * @Param []
     * @Return void
     */
    public static void interceptPassword() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int len = s.length();
        if (len < 2) {
            System.out.println(s);
        }
        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        System.out.println(s.substring(begin, begin + maxLen));
    }

    /**
     * @author yunshuaiwei
     * @description HJ33 整数与IP地址间的转换
     * @date 9:41 2022/6/15
     * @Param []
     * @Return void
     */
    public static void integerToIp() {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();
        String num = scanner.nextLine();
        //转十进制
        String[] split = ip.split("\\.");
        StringBuilder tmp = new StringBuilder();
        for (String s : split) {
            int i = Integer.parseInt(s);
            String string = Integer.toString(i, 2);
            tmp.append(String.format("%08d", Integer.valueOf(string)));
        }
        System.out.println(Long.valueOf(tmp.toString(), 2));
        //十进制型转IP
        long ipv4 = Long.parseLong(num);
        //二进制
        String s = Long.toBinaryString(ipv4);
        //补0,凑成32位
        while (s.length() < 32) {
            s = "0" + s;
        }
        String[] res = new String[4];
        for (int i = 0; i < 4; i++) {
            //每8位进行截取并将二进制转为10进制
            res[i] = String.valueOf(Integer.parseInt(s.substring(i * 8, i * 8 + 8), 2));
        }
        System.out.println(String.join(".", res));
//        String result = "";
//        for (int i = 0; i < 4; i++) {
//            result = ipv4 % 256 + "." + result;
//            ipv4 /= 256;
//        }
//        System.out.println(result.substring(0, result.length() - 1));
    }

    /**
     * @author yunshuaiwei
     * @description HJ34 图片整理
     * @date 10:35 2022/6/15
     * @Param []
     * @Return void
     */
    public static void method10() {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        Arrays.sort(chars);
        System.out.println(String.valueOf(chars));
    }

    /**
     * @author yunshuaiwei
     * @description HJ35 蛇形矩阵
     * @date 10:39 2022/6/15
     * @Param []
     * @Return void
     */
    public static void serpentineMatrix() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int tmp = 1;
        int[] row = new int[num];
        row[0] = 1;
        //每一行的首元素
        for (int i = 1; i < num; i++) {
            row[i] = row[i - 1] + tmp;
            tmp++;
        }
        tmp = 2;
        for (int i = 0; i <= num - 1; i++) {
            if (i == num - 1) {
                System.out.println(row[i]);
                break;
            }
            //每一行的首元素
            int n = row[i];
            System.out.print(n + " ");
            for (int j = tmp; j <= num; j++) {
                n = n + j;
                System.out.print(n + " ");
            }
            System.out.println();
            tmp++;
        }
    }

    /**
     * @author yunshuaiwei
     * @description HJ36 字符串加密
     * @date 11:16 2022/6/15
     * @Param []
     * @Return void
     */
    public static void stringEncrypt() {
        Scanner scanner = new Scanner(System.in);
        String cipherText = scanner.nextLine();
        String string = scanner.nextLine();
        String dict = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //处理字符串，去除重复元素
        StringBuilder str = new StringBuilder();
        for (char c : cipherText.toCharArray()) {
            if (!str.toString().contains(c + "")) {
                str.append(c);
            }
        }
        str = new StringBuilder(str.toString().toUpperCase());
        for (char c = 'A'; c <= 'Z'; c = (char) (c + 1)) {
            if (!str.toString().contains(c + "")) {
                str.append(c);
            }
        }
        //解密
        StringBuilder builder = new StringBuilder(dict);
        for (char c : string.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (c > 'Z') {
                c = (char) (c - 32);
                int i = builder.indexOf(c + "");
                System.out.print((char) (str.charAt(i) + 32));
            } else {
                int i = builder.indexOf(c + "");
                System.out.print(str.charAt(i));
            }
        }
    }

    /**
     * @author yunshuaiwei
     * @description HJ37 统计每个月兔子的总数
     * @date 16:13 2022/6/15
     * @Param []
     * @Return int
     */
    public static int getTotalCount(int num){
        if (num<3){
            return 1;
        }
        return getTotalCount(num-2)+getTotalCount(num-1);
    }

    public static void main(String[] args) {
        stringEncrypt();
    }

}
