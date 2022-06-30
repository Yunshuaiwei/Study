import common.DoubleListNode;
import common.ListNode;
import common.TreeNode;

import java.util.*;

/**
 * @author yunshuaiwei
 * @className ArithmeticStudy
 * @description: TODO
 * @date 2022/6/14 11:59
 */
public class ArithmeticStudy {


    /**
     * @author yunshuaiwei
     * @description 数组某个区间内的数据累加和
     * @date 22:04 2022/6/14
     * @Param [arr, left, right]
     * @Return int
     */
    private static int rangeSum(int[] arr, int left, int right) {
        int len = arr.length;
        int[] ints = new int[len];
        ints[0] = arr[0];
        for (int i = 1; i < len; i++) {
            ints[i] = ints[i - 1] + arr[i];
        }
        return left == 0 ? ints[0] : ints[right] - ints[left - 1];
    }

    /**
     * @author yunshuaiwei
     * @description 基础随机函数，随机等概率返回1-5
     * @date 22:36 2022/6/14
     * @Param []
     * @Return int
     */
    private static int baseRandom() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * @author yunshuaiwei
     * @description 随机机制，只能适用baseRandom()函数，等概率返回0和1
     * @date 22:38 2022/6/14
     * @Param []
     * @Return int
     */
    private static int randomReturn0Or1() {
        int res = 0;
        do {
            res = baseRandom();
        } while (res == 3);
        return res < 3 ? 0 : 1;
    }

    /**
     * @author yunshuaiwei
     * @description 得到000~111做到等概率，即0~7等概率返回
     * @date 22:46 2022/6/14
     * @Param []
     * @Return int
     */
    private static int randomReturn0To7() {
        return (randomReturn0Or1() << 2) + (randomReturn0Or1() << 1) + (randomReturn0Or1());
    }


    /**
     * @author yunshuaiwei
     * @description 随机等概率返回0~6
     * @date 22:50 2022/6/14
     * @Param []
     * @Return int
     */
    private static int randomReturn0To6() {
        int res = 0;
        do {
            res = randomReturn0To7();
        } while (res == 7);
        return res;
    }

    /**
     * @author yunshuaiwei
     * @description 等概率得到1~7
     * @date 22:53 2022/6/14
     * @Param []
     * @Return int
     */
    private static int randomReturn1To7() {
        return randomReturn0To6() + 1;
    }

    /**
     * @author yunshuaiwei
     * @description 只知道x函数会以固定概率返回0和1，但是x里面具体的概率不知道
     * @date 22:59 2022/6/14
     * @Param []
     * @Return int
     */
    private static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    /**
     * @author yunshuaiwei
     * @description 等概率返回0和1
     * @date 23:01 2022/6/14
     * @Param []
     * @Return int
     */
    private static int y() {
        int res = 0;
        do {
            res = x();
        } while (res == x());
        //res= 0 1
        //res= 1 0
        return res;
    }

    //-----------------------查找-----------------------

    /**
     * @author yunshuaiwei
     * @description 查找>=num，在数组arr中最左侧的位置下标
     * @date 16:36 2022/6/15
     * @Param []
     * @Return int
     */
    public static int searchFarLeftOfNumForIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int t = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {
                t = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return t;
    }

    /**
     * @author yunshuaiwei
     * @description 返回一个局部最小值的下标index
     * @date 16:52 2022/6/15
     * @Param [arr]
     * @Return int
     */
    public static int returnLocalMinimumOfIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int len = arr.length;
        if (len == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[len - 1] < arr[len - 2]) {
            return len - 1;
        }
        int l = 0;
        int r = len - 1;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return arr[l] < arr[r] ? l : r;
    }

    /**
     * @author yunshuaiwei
     * @description 生成一个随机数组，相邻元素不相等
     * @date 17:18 2022/6/15
     * @Param [mexLen, maxValue]
     * @Return int[]
     */
    private static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    /**
     * @author yunshuaiwei
     * @description 验证数组arr，下标minIndex处是否为局部最小处
     * @date 17:25 2022/6/15
     * @Param [arr, minIndex]
     * @Return boolean
     */
    private static boolean check(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left <= 0 || arr[left] > arr[minIndex];
        boolean rightBigger = right >= arr.length || arr[right] > arr[minIndex];
        return leftBigger && rightBigger;
    }

    //-----------------------链表-----------------------

    /**
     * @author yunshuaiwei
     * @description 单链表反转
     * @date 22:35 2022/6/15
     * @Param []
     * @Return void
     */
    private static ListNode<Integer> singleLinkedReverse(ListNode<Integer> head) {
        if (head == null) {
            return head;
        }
        ListNode<Integer> pre = null;
        ListNode<Integer> cur = head;
        ListNode<Integer> curNext = null;
        while (cur != null) {
            curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }

    /**
     * @author yunshuaiwei
     * @description 双向链表反转
     * @date 22:53 2022/6/15
     * @Param [head]
     * @Return common.DoubleListNode
     */
    private static DoubleListNode doubleLinkedReverse(DoubleListNode head) {
        if (head == null) {
            return head;
        }
        DoubleListNode cur = head;
        DoubleListNode pre = null;
        DoubleListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            cur.last = next;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * @author yunshuaiwei
     * @description 打印单链表
     * @date 22:40 2022/6/15
     * @Param []
     * @Return void
     */
    private static void printSingleLinked(ListNode<Integer> head) {
        if (head == null) {
            return;
        }
        ListNode<Integer> cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * @author yunshuaiwei
     * @description 打印双向链表
     * @date 23:04 2022/6/15
     * @Param [head]
     * @Return void
     */
    private static void printDoubleLinked(DoubleListNode head) {
        DoubleListNode cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * @author yunshuaiwei
     * @description 单链表实现队列
     * @date 15:32 2022/6/16
     * @Param
     * @Return
     */
    public static class MyQueue<V> {
        private ListNode<V> head;
        private ListNode<V> tail;
        private int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void offer(V value) {
            ListNode<V> node = new ListNode<>(value);
            if (tail == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
            size++;
        }

        public V poll() {
            V res = null;
            if (head != null) {
                res = head.val;
                head = head.next;
                size--;
            }
            if (head == null) {
                tail = null;
            }
            return res;
        }

        public V peek() {
            V res = null;
            if (head != null) {
                res = head.val;
            }
            return res;
        }
    }

    /**
     * @author yunshuaiwei
     * @description 单链表实现栈
     * @date 15:46 2022/6/16
     * @Param
     * @Return
     */
    public static class MyStack<V> {
        private ListNode<V> head;
        private int size;

        public MyStack() {
            head = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void push(V value) {
            ListNode<V> node = new ListNode<>(value);
            if (head != null) {
                node.next = head;
            }
            head = node;
            size++;
        }

        public V poll() {
            V res = null;
            if (head != null) {
                res = head.val;
                head = head.next;
                size--;
            }
            return res;
        }

        public V peek() {
            V res = null;
            if (head != null) {
                res = head.val;
            }
            return res;
        }
    }


    /**
     * @author yunshuaiwei
     * @description 以k大小对链表进行分组，返回每一组的第一个节点
     * @date 16:05 2022/6/16
     * @Param [head, k]
     * @Return common.ListNode
     */
    private static ListNode getKGroupEnd(ListNode head, int k) {
        while (--k != 0 && head != null) {
            head = head.next;
        }
        return head;
    }

    /**
     * @author yunshuaiwei
     * @description 反转从节点start到end之间的链表
     * @date 16:08 2022/6/16
     * @Param [start, end]
     * @Return void
     */
    private static void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode cur = start;
        ListNode pre = null;
        ListNode next;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    /**
     * @author yunshuaiwei
     * @description 反转以k为长度的每一组链表节点进行反转
     * @date 16:15 2022/6/16
     * @Param [head, k]
     * @Return common.ListNode
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroupEnd(start, k);
        if (end == null) {//不够k个节点，则直接返回
            return head;
        }
        //第一组数据
        head = end;
        //反转
        reverse(start, end);
        //上一组的结尾节点
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    /**
     * @author yunshuaiwei
     * @description 链表求和
     * @date 16:59 2022/6/16
     * @Param [l1, l2]
     * @Return common.ListNode
     */
    public static ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        int len1 = getListSize(l1);
        int len2 = getListSize(l2);
        //长链表
        ListNode<Integer> l = len1 >= len2 ? l1 : l2;
        //短链表
        ListNode<Integer> s = l == l1 ? l2 : l1;
        ListNode<Integer> curL = l;
        ListNode<Integer> curS = s;
        ListNode<Integer> last = curL;
        int carry = 0;
        while (curS != null) {
            int sum = curL.val + curS.val + carry;
            curL.val = sum % 10;
            carry = sum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        while (curL != null) {
            int sum = curL.val + carry;
            curL.val = sum % 10;
            carry = sum / 10;
            last = curL;
            curL = curL.next;
        }
        if (carry != 0) {
            last.next = new ListNode<Integer>(1);
        }
        return l;
    }

    /**
     * @author yunshuaiwei
     * @description 求链表长度
     * @date 16:36 2022/6/16
     * @Param [head]
     * @Return int
     */
    private static int getListSize(ListNode<Integer> head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    /**
     * @author yunshuaiwei
     * @description 合并两个有序链表
     * @date 17:17 2022/6/16
     * @Param [l1, l2]
     * @Return common.ListNode
     */
    public ListNode<Integer> mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode<Integer> head = l1.val <= l2.val ? l1 : l2;
        ListNode<Integer> cur1 = head.next;
        ListNode<Integer> cur2 = l1 == head ? l2 : l1;
        ListNode<Integer> cur = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        cur.next = cur1 != null ? cur1 : cur2;
        return head;
    }

    /**
     * @author yunshuaiwei
     * @description 160. 相交链表
     * @date 14:30 2022/6/24
     * @Param [headA, headB]
     * @Return common.ListNode<java.lang.Integer>
     */
    public ListNode<Integer> getIntersectionNode(ListNode<Integer> headA, ListNode<Integer> headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode<Integer> cur1 = headA;
        ListNode<Integer> cur2 = headB;
        //两个链表的长度差
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        //长链表
        cur1 = n > 0 ? headA : headB;
        //短链表
        cur2 = cur1 == headA ? headB : headA;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    //-----------------------KMP算法-----------------------

    /**
     * @author yunshuaiwei
     * @description 796. 旋转字符串
     * @date 11:25 2022/6/20
     * @Param [s, goal]
     * @Return boolean
     */
    public boolean rotateString(String s, String goal) {
        if (goal.length() < s.length()) {
            return false;
        }
        int len = goal.length();
        s += s;
        for (int i = 0; i < s.length(); i++) {
            int j = i + len;
            if (j >= s.length()) {
                return false;
            }
            if (s.substring(i, j).equals(goal)) {
                return true;
            }
        }
        return false;
    }

    //-----------------------二叉树-----------------------

    /**
     * @author yunshuaiwei
     * @description 二叉树先序遍历
     * @date 14:56 2022/6/24
     * @Param [root]
     * @Return void
     */
    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    /**
     * @author yunshuaiwei
     * @description 中序遍历
     * @date 15:00 2022/6/24
     * @Param [root]
     * @Return void
     */
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

    /**
     * @author yunshuaiwei
     * @description 层序遍历
     * @date 15:24 2022/6/24
     * @Param [root]
     * @Return void
     */
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }

    /**
     * @author yunshuaiwei
     * @description 后续遍历
     * @date 15:01 2022/6/24
     * @Param [root]
     * @Return void
     */
    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> res = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.push(pop);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        while (!res.isEmpty()) {
            System.out.print(res.pop().val + " ");
        }
        System.out.println();
    }

    /**
     * @author yunshuaiwei
     * @description 树的最大宽度
     * @date 15:45 2022/6/24
     * @Param [root]
     * @Return void
     */
    public static void theMaximumWidthOfTheTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        queue.add(root);
        int curLevel = 1;
        //当前层节点个数
        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //当前节点所在的层
            Integer curNodeLevel = map.get(node);
            if (curLevel == curNodeLevel) {
                curLevelNodes++;
            } else {
                curLevel++;
                max = Math.max(max, curLevelNodes);
                //初始化当前层的节点数
                curLevelNodes = 1;
            }
            if (node.left != null) {
                map.put(node.left, curNodeLevel + 1);
                queue.add(node.left);
            }
            if (node.right != null) {
                map.put(node.right, curNodeLevel + 1);
                queue.add(node.right);
            }
        }
    }

    /**
     * @author yunshuaiwei
     * @description 汉诺塔问题
     * @date 11:09 2022/6/27
     * @Param [n]
     * @Return void
     */
    public static void hanota(int n) {
        if (n > 0) {
            func(n, "左", "右", "中");
        }
    }

    /**
     * @author yunshuaiwei
     * @description 1~i是圆盘，目标是from->end，other是另外一个
     * @date 11:10 2022/6/27
     * @Param [i, from, end, other]
     * @Return void
     */
    private static void func(int i, String from, String end, String other) {
        if (i == 1) {
            System.out.println("Move 1 from " + from + " to " + end);
        } else {
            func(i - 1, from, other, end);
            System.out.println("Move " + i + " from " + from + " to " + end);
            func(i - 1, other, end, from);
        }
    }

    /**
     * @author yunshuaiwei
     * @description 一个字符串的全部子序列
     * @date 11:28 2022/6/27
     * @Param []
     * @Return void
     */
    public static void theEntireSubsequenceOfString(String str) {
        process(str.toCharArray(), 0, new ArrayList<>());
    }

    /**
     * @author yunshuaiwei
     * @description 当前来到 i 位置，要和不要走两条路
     * @date 11:39 2022/6/27
     * @Param [chars, i, res]
     * @Return void
     */
    private static void process(char[] chars, int i, List<Character> res) {
        if (i == chars.length) {
            printList(res);
            return;
        }
        List<Character> resKeep = copyList(res);
        resKeep.add(chars[i]);
        process(chars, i + 1, resKeep);//要当前字符
        List<Character> noInclude = copyList(res);
        process(chars, i + 1, noInclude);//不要当前字符
    }

    /**
     * @author yunshuaiwei
     * @description 打印链表
     * @date 11:32 2022/6/27
     * @Param [res]
     * @Return void
     */
    private static void printList(List<Character> res) {
        System.out.println(res.toString());
    }

    /**
     * @author yunshuaiwei
     * @description 拷贝函数
     * @date 11:34 2022/6/27
     * @Param [list]
     * @Return java.util.List<java.lang.Character>
     */
    private static List<Character> copyList(List<Character> list) {
        return new ArrayList<>(list);
    }


    /**
     * @author yunshuaiwei
     * @description 一个字符串的全排列
     * @date 14:25 2022/6/27
     * @Param [str]
     * @Return void
     */
    public static void stringOfFullPermutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        stringOfFullPermutationForFunc(str.toCharArray(), 0, list);
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void stringOfFullPermutationForFunc(char[] str, int i, ArrayList<String> res) {
        if (str.length == i) {
            res.add(String.valueOf(str));
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                swap(str, i, j);
                stringOfFullPermutationForFunc(str, i + 1, res);
                swap(str, i, j);
            }
        }
    }

    private static void swap(char[] str, int i, int j) {
        char c = str[i];
        str[i] = str[j];
        str[j] = c;
    }

    public static int win(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    /**
     * @author yunshuaiwei
     * @description 先手函数
     * @date 14:51 2022/6/27
     * @Param [arr, i, j]
     * @Return int
     */
    private static int f(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }

    /**
     * @author yunshuaiwei
     * @description 后手函数
     * @date 14:53 2022/6/27
     * @Param [arr, i, j]
     * @Return int
     */
    private static int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }

    /**
     * @author yunshuaiwei
     * @description 递归返回栈底元素
     * @date 10:07 2022/6/28
     * @Param [stack]
     * @Return int
     */
    public static int stackBottomOfValue(Stack<Integer> stack) {
        Integer res = stack.pop();
        if (stack.isEmpty()) {
            return res;
        } else {
            int last = stackBottomOfValue(stack);
            stack.push(res);
            return last;
        }
    }

    /**
     * @author yunshuaiwei
     * @description 递归逆序栈
     * @date 10:13 2022/6/28
     * @Param [stack]
     * @Return void
     */
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = stackBottomOfValue(stack);
        reverseStack(stack);
        stack.push(i);
    }

    /**
     * @author yunshuaiwei
     * @description 剑指 Offer 46. 把数字翻译成字符串
     * @date 10:18 2022/6/28
     * @Param [num]
     * @Return int
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }

    public static void main(String[] args) {
        stringOfFullPermutation("hello");
    }
}
