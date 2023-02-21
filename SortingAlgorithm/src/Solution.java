import utils.ListNode;
import utils.Node;
import utils.TreeNode;

import java.util.*;

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

    /**
     * 剑指 Offer 32 - I. 从上到下打印二叉树
     * 用数组顺序存储
     *
     * @author yunshuaiwei
     * @date 2023/2/14 14:43
     **/
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                size--;
            }
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }


    /**
     * 剑指 Offer 32 - II. 从上到下打印二叉树 II
     * 每一层数据用List存储
     *
     * @author yunshuaiwei
     * @date 2023/2/14 16:22
     **/
    public List<List<Integer>> levelOrder2(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                size--;
            }
            lists.add(list);
        }
        return lists;
    }

    /**
     * 剑指 Offer 32 - III. 从上到下打印二叉树 III
     * “之”字型打印
     *
     * @author yunshuaiwei
     * @date 2023/2/14 16:33
     **/
    public List<List<Integer>> levelOrder3(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                size--;
            }
            if (lists.size() % 2 != 0) {
                Collections.reverse(list);
            }
            lists.add(list);
        }
        return lists;
    }

    /**
     * 剑指 Offer 26. 树的子结构
     *
     * @author yunshuaiwei
     * @date 2023/2/14 22:31
     **/
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private Boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    /**
     * 二叉树的镜像
     *
     * @author yunshuaiwei
     * @date 2023/2/14 22:43
     **/
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    /**
     * 剑指 Offer 28. 对称的二叉树
     *
     * @author yunshuaiwei
     * @date 2023/2/14 22:48
     **/
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    public boolean check(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return check(A.left, B.right) && check(A.right, B.left);
    }

    /**
     * 剑指 Offer 10- I. 斐波那契数列
     *
     * @author yunshuaiwei
     * @date 2023/2/14 22:56
     **/
    public int fib(int n) {
        int a = 0, b = 1, c = 0;
        for (int i = 0; i < n; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return a;
    }

    /**
     * 剑指 Offer 10- II. 青蛙跳台阶问题
     *
     * @author yunshuaiwei
     * @date 2023/2/20 15:16
     **/
    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     * 剑指 Offer 63. 股票的最大利润
     *
     * @author yunshuaiwei
     * @date 2023/2/20 15:23
     **/
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

    /**
     * 剑指 Offer 42. 连续子数组的最大和
     *
     * @author yunshuaiwei
     * @date 2023/2/21 16:09
     **/
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    /**
     * 剑指 Offer 47. 礼物的最大价值
     *
     * @author yunshuaiwei
     * @date 2023/2/21 16:24
     **/
    public int maxValue(int[][] grid) {

        return 0;
    }

    /**
     * 剑指 Offer 46. 把数字翻译成字符串
     *
     * @author yunshuaiwei
     * @date 2023/2/21 21:04
     **/
    public int translateNum(int num) {

        return 0;
    }

    /**
     * 剑指 Offer 18. 删除链表的节点
     *
     * @author yunshuaiwei
     * @date 2023/2/21 21:06
     **/
    public ListNode deleteNode(ListNode head, int val) {
        ListNode cur = head;
        ListNode next = cur.next;
        if (cur.val == val) {
            return next;
        }
        while (next != null) {
            if (next.val == val) {
                cur.next = next.next;
            }
            cur = cur.next;
            next = next.next;
        }
        return head;
    }

    /**
     * 剑指 Offer 22. 链表中倒数第k个节点
     *
     * @author yunshuaiwei
     * @date 2023/2/21 21:14
     **/
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode quick = head;
        while (k > 0) {
            quick = quick.next;
            k--;
        }
        while (quick != null) {
            slow = slow.next;
            quick = quick.next;
        }
        return slow;
    }

    /**
     * 剑指 Offer 25. 合并两个排序的链表
     *
     * @author yunshuaiwei
     * @date 2023/2/21 21:35
     **/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newNode = null;
        ListNode next = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                if (newNode == null) {
                    newNode = new ListNode(cur1.val);
                    next = newNode;
                } else {
                    next.next = new ListNode(cur1.val);
                    next = next.next;
                }
                cur1 = cur1.next;
            } else {
                if (newNode == null) {
                    newNode = new ListNode(cur2.val);
                    next = newNode;
                } else {
                    next.next = new ListNode(cur2.val);
                    next = next.next;
                }
                cur2 = cur2.next;
            }
        }
        if (cur1 == null) {
            next.next = cur2;
        }
        if (cur2 == null) {
            next.next = cur1;
        }
        return newNode;
    }

    /**
     * 剑指 Offer 52. 两个链表的第一个公共节点
     *
     * @author yunshuaiwei
     * @date 2023/2/21 21:45
     **/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (cur1 != cur2) {
            cur1 = cur1 == null ? headB : cur1.next;
            cur2 = cur2 == null ? headA : cur2.next;
        }
        return cur2;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff"));
    }
}
