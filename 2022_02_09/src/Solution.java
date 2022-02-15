import common.ListNode;
import common.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yunshuaiwei
 * @className Solution
 * @description: TODO
 * @date 2022/2/10 18:55
 */
public class Solution {
    public int[] reversePrint1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] ints = new int[stack.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = stack.pop();

        }
        return ints;
    }

    public int[] reversePrint(ListNode head) {
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        int[] ints = new int[len];
        tmp = head;
        for (int i = len - 1; i >= 0; i--) {
            ints[i] = tmp.val;
            tmp = tmp.next;
        }
        return ints;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        HashMap<Node, Integer> oldMap = new HashMap<>();
        HashMap<Integer, Node> newNodeMap = new HashMap<>();
        HashMap<Integer, Integer> randomMap = new HashMap<>();
        int num = 0;
        while (cur != null) {
            oldMap.put(cur, num++);
            cur = cur.next;
        }
        cur = head;
        Node newNode = null;
        Node newCur = null;
        num = 0;
        int num1 = 0;
        while (cur != null) {
            if (newNode == null) {
                newNode = new Node(cur.val);
                newNodeMap.put(num++, newNode);
                newCur = newNode;
            } else {
                newCur.next = new Node(cur.val);
                newNodeMap.put(num++, newCur.next);
                newCur = newCur.next;
            }

            randomMap.put(num1++, oldMap.get(cur.random));
            cur = cur.next;
        }
        newCur = newNode;
        num = 0;
        while (newCur != null) {
            newCur.random = newNodeMap.get(randomMap.get(num++));
            newCur = newCur.next;
        }
        return newNode;
    }

    public String replaceSpace(String s) {
        StringBuilder stringBuffer = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == ' ') {
                stringBuffer.append("%20");
                continue;
            }
            stringBuffer.append(aChar);
        }
        return stringBuffer.toString();
    }

    public String reverseLeftWords1(String s, int n) {
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            builder.append(builder.charAt(i));
        }
        return builder.substring(n);
    }

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    /**
     * @author yunshuaiwei
     * @description 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
     * @date 20:32 2022/2/12
     * @Param [nums]
     * @Return int
     */
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
            } else if (nums[i] == nums[nums[i]]) {
                return nums[i];
            } else {
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }

    /**
     * @author yunshuaiwei
     * @description 统计一个数字在排序数组中出现的次数。
     * @date 20:49 2022/2/12
     * @Param [nums, target]
     * @Return int
     */
    public int search(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, Integer.sum(map.get(num), 1));
            } else {
                map.put(num, 1);
            }
        }
        if (!map.containsKey(target)) {
            return 0;
        }
        return map.get(target);
    }

    /**
     * @author yunshuaiwei
     * @description 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     * @date 21:01 2022/2/12
     * @Param [nums]
     * @Return int
     */
    public int missingNumber(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int m;
        while (i <= j) {
            m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    /**
     * @author yunshuaiwei
     * @description 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @date 20:24 2022/2/13
     * @Param [matrix, target]
     * @Return boolean
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            int num = matrix[i][j];
            if (num == target) {
                return true;
            } else if (num > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }


    /**
     * @author yunshuaiwei
     * @description 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * @date 21:15 2022/2/13
     * @Param [numbers]
     * @Return int
     */
    public int minArray(int[] numbers) {
        int num = numbers[0];
        for (int number : numbers) {
            if (number < num) {
                return number;
            }
        }
        return num;
    }


    /**
     * @author yunshuaiwei
     * @description 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     * @date 21:32 2022/2/13
     * @Param [s]
     * @Return char
     */
    public static char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? Integer.sum(map.get(c), 1) : 1);
            queue.add(c);
        }
        for (Character character : queue) {
            if (map.get(character) == 1) {
                return character;
            }
        }
        return ' ';
    }


    public static void main(String[] args) {
        char z = firstUniqChar("z");
        System.out.println(z);
    }
}
