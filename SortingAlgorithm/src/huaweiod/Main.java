package huaweiod;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Integer.parseInt(scanner.nextLine().substring(2), 16));
    }
}
