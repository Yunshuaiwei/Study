package huaweiod;

import java.util.*;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/7 21:53
 */
public class Main {

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        next.trim();
        String[] s = next.split(" ");
        System.out.println(s[s.length - 1].length());
    }

    /**
     * HJ2 计算某字符出现次数
     *
     * @author yunshuaiwei
     * @date 2023/3/7 22:08
     **/
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String target = scanner.next();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            String str = s.charAt(i) + "";
            if (str.equalsIgnoreCase(target)) {
                num++;
            }
        }
        System.out.println(num);
    }

    /**
     * HJ3 明明的随机数
     *
     * @author yunshuaiwei
     * @date 2023/3/7 22:09
     **/
    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeSet<Integer> integers = new TreeSet<Integer>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            integers.add(num);
        }
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    public static void main4(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine().trim();
        s = s.replace(" ", "");
        int num = (s.length() % 8 == 0) ? 0 : (8 - s.length() % 8);
        char[] chars = new char[num];
        Arrays.fill(chars, '0');
        StringBuilder builder = new StringBuilder(s);
        builder.append(chars);
        while (builder.length() != 0) {
            System.out.println(builder.substring(0, 8));
            builder.delete(0, 8);
        }
    }

    /**
     * HJ5 进制转换
     *
     * @author yunshuaiwei
     * @date 2023/3/7 22:28
     **/
    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Integer.parseInt(scanner.nextLine().substring(2), 16));
    }

    /**
     * 字符串排序
     *
     * @author yunshuaiwei
     * @date 2023/3/20 16:38
     **/
    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                list.add(c);
            }
        }
        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
            }
        });
        int index = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                builder.append(list.get(index++));
            } else {
                builder.append(c);
            }
        }
        System.out.println(builder.toString());
    }

    /**
     * 查找兄弟单词
     *
     * @author yunshuaiwei
     * @date 2023/3/20 17:04
     **/
    public static void main7(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            list.add(str);
        }
        String str = scanner.next();
        char[] array = str.toCharArray();
        Arrays.sort(array);
        String s1 = String.valueOf(array);
        List<String> arrayList = new ArrayList<>();
        int k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s = list.get(i);
            if (s.equals(str)) {
                continue;
            }
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            if (String.valueOf(chars).equals(s1)) {
                arrayList.add(s);
            }
        }
        Collections.sort(arrayList);
        System.out.println(arrayList.size());
        if (arrayList.size() >= k) {
            System.out.println(arrayList.get(k - 1));
        }
    }

    /**
     * 高精度整数加法
     *
     * @author yunshuaiwei
     * @date 2023/3/20 17:36
     **/
    public static void main8(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.nextLine();
        String num2 = scanner.nextLine();
        int flag = 0;
        StringBuilder builder = new StringBuilder();
        String str1 = num1.length() < num2.length() ? num2 : num1;
        String str2 = num1.length() < num2.length() ? num1 : num2;
        int index = str2.length() - 1;
        for (int i = str1.length() - 1; i >= 0; i--) {
            int i1 = str1.charAt(i) - '0';
            int i2 = 0;
            if (index >= 0) {
                i2 = str2.charAt(index--) - '0';
            }

            int num = i1 + i2 + flag;
            if (num > 9) {
                builder.insert(0, num % 10);
                flag = 1;
            } else {
                flag = 0;
                builder.insert(0, num);
            }
        }
        if (flag == 1) {
            builder.insert(0, flag);
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {

    }
}
