import utils.ListNode;
import utils.Node;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Stack;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/2/7 16:45
 */
public class Solution {

    /**
     * 倒序打印链表
     *
     * @author yunshuaiwei
     * @date 2023/2/7 16:53
     **/
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int size = stack.size();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = stack.pop();
        }
        return ints;
    }

    /**
     * 反转链表
     *
     * @author yunshuaiwei
     * @date 2023/2/7 17:01
     **/
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 复杂链表的复制
     *
     * @author yunshuaiwei
     * @date 2023/2/13 16:15
     **/
    public Node copyRandomList(Node head) {
        //存储旧链表节点和索引的对应关系
        HashMap<Node, Integer> hashMap = new HashMap<>();
        Node cur = head;
        Node node = null;
        Node newHead = null;
        int index = 0;
        while (cur != null) {
            hashMap.put(cur, index++);
            cur = cur.next;
        }
        cur = head;
        //存储索引和随机节点的索引对应关系
        HashMap<Integer, Integer> map = new HashMap<>();
        //存储新链表节点和索引的对应关系
        HashMap<Integer, Node> indexMap = new HashMap<>();
        index = 0;
        int num = 0;
        //链表的复制
        while (cur != null) {
            map.put(index++, hashMap.get(cur.random));
            if (node == null) {
                node = new Node(cur.val);
                newHead = node;
            } else {
                node.next = new Node(cur.val);
                node = node.next;
            }
            indexMap.put(num++, node);
            cur = cur.next;
        }
        cur = newHead;
        index = 0;
        //给新链表的random指针赋值
        while (cur != null) {
            cur.random = indexMap.get(map.get(index++));
            cur = cur.next;
        }
        return newHead;
    }

    /**
     * 替换空格
     *
     * @author yunshuaiwei
     * @date 2023/2/13 16:48
     **/
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ' ') {
                str.append("%20");
            } else {
                str.append(aChar);
            }
        }
        return str.toString();
    }

    /**
     * 坐旋转字符串
     *
     * @author yunshuaiwei
     * @date 2023/2/13 16:53
     **/
    public String reverseLeftWords(String s, int n) {
        StringBuilder builder = new StringBuilder(s);
        String s1 = builder.substring(n);
        String s2 = builder.substring(0, n);
        System.out.println(s1 + s2);
        return s1 + s2;
    }

    /**
     * 数组中重复的数字
     *
     * @author yunshuaiwei
     * @date 2023/2/13 17:01
     **/
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
     * 剑指 Offer 53 - I. 在排序数组中查找数字 I
     *
     * @author yunshuaiwei
     * @date 2023/2/13 17:38
     **/
    public int search(int[] nums, int target) {
        int num = 0;
        for (int i : nums) {
            if (i == target) {
                num++;
            }
            if (i > target) {
                break;
            }
        }
        return num;
    }

    /**
     * 剑指 Offer 53 - II. 0～n-1中缺失的数字
     *
     * @author yunshuaiwei
     * @date 2023/2/13 17:40
     **/
    public int missingNumber(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != index) {
                break;
            }
            index++;
        }
        return index;
    }

    /**
     * 二维数组中的查找
     *
     * @author yunshuaiwei
     * @date 2023/2/13 17:54
     **/
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] ints : matrix) {//行
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 剑指 Offer 11. 旋转数组的最小数字
     *
     * @author yunshuaiwei
     * @date 2023/2/13 17:59
     **/
    public int minArray(int[] numbers) {
        int min = numbers[0];
        for (int number : numbers) {
            if (number <= min) {
                return number;
            }
        }
        return min;
    }

    /**
     * 剑指 Offer 50. 第一个只出现一次的字符
     *
     * @author yunshuaiwei
     * @date 2023/2/13 18:04
     **/
    public static char firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer orDefault = hashMap.getOrDefault(c, 0);
            hashMap.put(c, ++orDefault);
        }
        for (Character character : hashMap.keySet()) {
            if (hashMap.get(character).equals(1)) {
                return character;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff"));
    }
}
