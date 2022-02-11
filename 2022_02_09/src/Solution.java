import common.ListNode;
import common.Node;

import java.util.HashMap;
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
        return s.substring(n)+s.substring(0,n);
    }
}
