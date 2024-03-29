import common.ListNode;
import common.Node;
import common.TreeNode;

import java.util.*;

/**
 * @author yunshuaiwei
 * @className Solution
 * @description: TODO
 * @date 2022/2/10 18:55
 */
public class Solution {
    public int[] reversePrint1(ListNode<Integer> head) {
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

    public int[] reversePrint(ListNode<Integer> head) {
        int len = 0;
        ListNode<Integer> tmp = head;
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

    public ListNode<Integer> reverseList(ListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode<Integer> cur = head;
        ListNode<Integer> pre = null;
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

    /**
     * @author yunshuaiwei
     * @description 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     * @date 22:33 2022/2/15
     * @Param [A, B]
     * @Return boolean
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    /**
     * @author yunshuaiwei
     * @description 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * @date 22:42 2022/2/15
     * @Param [root]
     * @Return common.TreeNode
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            mirrorTree(root.left);
            mirrorTree(root.right);
        }
        return root;
    }

    /**
     * @author yunshuaiwei
     * @description 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     * @date 22:58 2022/2/15
     * @Param [root]
     * @Return boolean
     */
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
     * @author yunshuaiwei
     * @description 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）
     * @date 15:42 2022/2/18
     * @Param [n]
     * @Return int
     */
    public int fib(int n) {
        int a = 0, b = 1, sum = 0;
        if (n < 2) {
            return n;
        }
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    /**
     * @author yunshuaiwei
     * @description 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
     * @date 15:54 2022/2/18
     * @Param [n]
     * @Return int
     */
    public static int numWays(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     * @author yunshuaiwei
     * @description 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     * @date 16:08 2022/2/18
     * @Param [prices]
     * @Return int
     */
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

    /**
     * @author yunshuaiwei
     * @description 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
     * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
     * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     * @date 16:40 2022/2/18
     * @Param [grid]
     * @Return int
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ints = new int[m][n];
        ints[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    ints[i][j] = grid[i][j] + ints[i][j - 1];
                } else if (j == 0) {
                    ints[i][j] = grid[i][j] + ints[i - 1][j];
                } else {
                    ints[i][j] = grid[i][j] + Math.max(ints[i - 1][j], ints[i][j - 1]);
                }
            }
        }
        return ints[m - 1][n - 1];
    }

    /**
     * @author yunshuaiwei
     * @description 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * @date 16:17 2022/2/18
     * @Param [nums]
     * @Return int
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    /**
     * @author yunshuaiwei
     * @description 给定一个数字，我们按照如下规则把它翻译为字符串：
     * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * @date 10:27 2022/2/22
     * @Param [num]
     * @Return int
     */
    public int translateNum(int num) {
        return 0;
    }

    /**
     * @author yunshuaiwei
     * @description 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     * @date 10:32 2022/2/22
     * @Param [s]
     * @Return int
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer j = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);
            tmp = tmp < i - j ? tmp + 1 : i - j;
            res = Math.max(res, tmp);
        }
        return res;
    }

    /**
     * @author yunshuaiwei
     * @description 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     * @date 10:54 2022/2/22
     * @Param [head, val]
     * @Return common.ListNode
     */
    public ListNode<Integer> deleteNode(ListNode<Integer> head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode<Integer> cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * @author yunshuaiwei
     * @description 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * @date 11:00 2022/2/22
     * @Param [head, k]
     * @Return common.ListNode
     */
    public ListNode<Integer> getKthFromEnd(ListNode<Integer> head, int k) {
        ListNode<Integer> letter = head;
        ListNode<Integer> former = head;
        while (k-- > 0) {
            former = former.next;
        }
        while (former != null) {
            letter = letter.next;
            former = former.next;
        }
        return letter;
    }

    /**
     * @author yunshuaiwei
     * @description 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * @date 11:07 2022/2/22
     * @Param [l1, l2]
     * @Return common.ListNode
     */
    public ListNode<Integer> mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> newHead = null;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode<Integer> cur = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (newHead == null) {
                    newHead = new ListNode<Integer>(l1.val);
                    cur = newHead;
                } else {
                    cur.next = new ListNode<Integer>(l1.val);
                    cur = cur.next;
                }
                l1 = l1.next;
            } else {
                if (newHead == null) {
                    newHead = new ListNode<Integer>(l2.val);
                    cur = newHead;
                } else {
                    cur.next = new ListNode<Integer>(l2.val);
                    cur = cur.next;
                }
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return newHead;
    }

    /**
     * @author yunshuaiwei
     * @description 输入两个链表，找出它们的第一个公共节点
     * @date 11:19 2022/2/22
     * @Param [headA, headB]
     * @Return common.ListNode
     */
    public ListNode<Integer> getIntersectionNode(ListNode<Integer> headA, ListNode<Integer> headB) {
        ListNode<Integer> cur1 = headA;
        ListNode<Integer> cur2 = headB;
        while (cur1 != cur2) {
            cur1 = cur1 == null ? headB : cur1.next;
            cur2 = cur2 == null ? headA : cur2.next;
        }
        return cur2;
    }

    /**
     * @author yunshuaiwei
     * @description 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
     * @date 11:29 2022/2/22
     * @Param [nums]
     * @Return int[]
     */
    public static int[] exchange(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            while (low < high && nums[low] % 2 != 0) {
                low++;
            }
            while (low < high && nums[high] % 2 == 0) {
                high--;
            }
            int tmp = nums[low];
            nums[low] = nums[high];
            nums[high] = tmp;
        }
        return nums;
    }

    /**
     * @author yunshuaiwei
     * @description 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
     * 如果有多对数字的和等于s，则输出任意一对即可
     * @date 11:39 2022/2/22
     * @Param [nums, target]
     * @Return int[]
     */
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int num = nums[i] + nums[j];
            if (num > target) {
                j--;
            } else if (num < target) {
                i++;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[0];
    }


    /**
     * @author yunshuaiwei
     * @description 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，
     * 标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
     * @date 11:50 2022/2/22
     * @Param [s]
     * @Return java.lang.String
     */
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (!"".equals(builder.toString())) {
                    stack.push(builder.toString());
                }
                builder = new StringBuilder();
            } else {
                builder.append(c);
            }
        }
        stack.push(builder.toString());
        builder = new StringBuilder();
        while (!stack.empty()) {
            builder.append(stack.pop()).append(" ");
        }
        return builder.toString().trim();
    }


    /**
     * @author yunshuaiwei
     * @description 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * @date 12:33 2022/2/23
     * @Param [board, word]
     * @Return boolean
     */
    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (int j = 0; j < board.length; j++) {
                for (int k = 0; k < board[0].length; k++) {


                }
            }


        }

        return false;
    }

    int res, k;

    /**
     * @author yunshuaiwei
     * @description 给定一棵二叉搜索树，请找出其中第 k 大的节点的值
     * @date 9:28 2022/2/24
     * @Param [root, k]
     * @Return int
     */
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    /**
     * @description 中序遍历的倒序
     */
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }

    /**
     * @author yunshuaiwei
     * @description 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
     * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     * @date 9:31 2022/2/24
     * @Param [nums]
     * @Return boolean
     */
    public static boolean isStraight(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        int min = 14;
        for (int num : nums) {
            if (set.contains(num)) {
                return false;
            }
            if (num == 0) {
                continue;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            set.add(num);
        }
        return max - min < 5;
    }

    /**
     * @author yunshuaiwei
     * @description 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * @date 12:26 2022/3/1
     * @Param [arr, k]
     * @Return int[]
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
            if (i == k) {
                return res;
            }
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * @author yunshuaiwei
     * @description 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
     * @date 12:45 2022/3/1
     * @Param
     * @Return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * @author yunshuaiwei
     * @description 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数
     * @date 12:48 2022/3/1
     * @Param [n]
     * @Return int
     */
    public static int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            //右移一位
            n >>= 1;
        }
        return res;
    }

    public int add(int a, int b) {
        return Integer.sum(a, b);
    }

    /**
     * @author yunshuaiwei
     * @description 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     * @date 13:07 2022/3/1
     * @Param [root]
     * @Return boolean
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * @author yunshuaiwei
     * @description 计算树的深度
     * @date 13:15 2022/3/1
     * @Param [node]
     * @Return int
     */
    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }


    /**
     * @author yunshuaiwei
     * @description TODO
     * @date 15:38 2022/3/5
     * @Param [N, sequence]
     * @Return int
     */
    public static int LSubSequence(int N, ArrayList<Integer> sequence) {
        // write code here
        if (sequence.size() < 2) {
            return sequence.size();
        }
        List<Integer> dp = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            dp.add(1);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence.get(i) > sequence.get(j)) {
                    dp.set(i, Math.max(dp.get(i), dp.get(j) + 1));
                }
            }
        }
        return Collections.max(dp);
    }

    public static int count(ArrayList<String> arr) {
        // write code here
        int res = 0;
        for (String s : arr) {
            if (s.equals("")) {
                continue;
            }
            if (matching(s.toCharArray())) {
                res++;
            }
        }
        return res;
    }

    /**
     * @author yunshuaiwei
     * @description 括号匹配
     * @date 15:56 2022/3/5
     * @Param [chars]
     * @Return boolean
     */
    private static boolean matching(char[] chars) {
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(' || stack.isEmpty()) {
                stack.push(c);
            } else {
                Character pop = stack.pop();
                if (pop == ')') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static void matching2() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        System.out.println(res);
    }

    /**
     * @author yunshuaiwei
     * @description 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * @date 9:52 2022/4/7
     * @Param [nums, val]
     * @Return int
     */
    public static int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length;
        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[j - 1];
                j--;
            } else {
                i++;
            }
        }
        return i;
    }

    /**
     * @author yunshuaiwei
     * @description 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * @date 19:42 2022/4/27
     * @Param [nums]
     * @Return int[]
     */
    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int l = 0, r = nums.length - 1;
        int index = nums.length - 1;
        while (l < r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                result[index--] = nums[l] * nums[l];
                l++;
            } else {
                result[index--] = nums[r] * nums[r];
                r--;
            }
        }
        return result;
    }

    /**
     * @author yunshuaiwei
     * @description 给定一个含有n个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0。
     * @date 15:27 2022/5/5
     * @Param [target, nums]
     * @Return int
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                result = Math.min(result, i - left + 1);
                //左指针右移
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    /**
     * @author yunshuaiwei
     * @description 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     * @date 15:37 2022/5/5
     * @Param [head, val]
     * @Return common.ListNode
     */
    public ListNode<Integer> removeElements(ListNode<Integer> head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode<Integer> pre = head;
        ListNode<Integer> cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * @author yunshuaiwei
     * @description 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
     * @date 14:48 2022/5/6
     * @Param [head]
     * @Return common.ListNode
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode curNext;
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
     * @description 给你一个链表，两两交换其中相邻的节点，
     * 并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     * @date 14:53 2022/5/6
     * @Param [head]
     * @Return common.ListNode
     */
    public ListNode<Integer> swapPairs(ListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode<Integer> cur = head;
        while (cur != null && cur.next != null) {
            int val = cur.val;
            cur.val = cur.next.val;
            cur.next.val = val;
            cur = cur.next.next;
        }
        return head;
    }

    /**
     * @author yunshuaiwei
     * @description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * @date 15:58 2022/6/6
     * @Param [n]
     * @Return int
     */
    public int climbStairs(int n) {
        int a = 1, b = 2, sum = 0;
        if (n < 3) {
            return n;
        }
        for (int i = 3; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }


    /**
     * @author yunshuaiwei
     * @description 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
     * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
     * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
     * 请你计算并返回达到楼梯顶部的最低花费。
     * @date 16:00 2022/6/6
     * @Param [cost]
     * @Return int
     */
    public static int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }

    /**
     * @author yunshuaiwei
     * @description 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * 问总共有多少条不同的路径？
     * @date 17:06 2022/6/7
     * @Param [m, n]
     * @Return int
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * @author yunshuaiwei
     * @description 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     * @date 17:16 2022/6/7
     * @Param [obstacleGrid]
     * @Return int
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < obstacleGrid[0].length && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    /**
     * @author yunshuaiwei
     * @description 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
     * @date 17:26 2022/6/7
     * @Param [n]
     * @Return int
     */
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    /**
     * @author yunshuaiwei
     * @description 动态规划 01背包问题 测试
     * @date 11:20 2022/6/8
     * @Param [weight, value, bagSize]
     * @Return void
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int wLen = weight.length;
        int[][] dp = new int[wLen + 1][bagSize + 1];

        //初始化：当背包容量为0时，前i个物品获得的最大价值为0
        for (int i = 0; i <= wLen; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= wLen; i++) {//遍历物品
            for (int j = 1; j <= bagSize; j++) {//遍历背包
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
    }

    /**
     * @author yunshuaiwei
     * @description 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * @date 11:34 2022/6/8
     * @Param [nums]
     * @Return boolean
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int target = 0;
        for (int num : nums) {
            target += num;
        }
        if (target % 2 != 0) {//奇数
            return false;
        }
        target = target / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }


    public static void main(String[] args) {
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(uniquePaths(3, 7));
    }

    /**
     * @author yunshuaiwei
     * @description 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，
     * 写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
     * @date 11:34 2022/4/24
     * @Param [nums, target]
     * @Return int
     */
    public int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }
        return -1;
    }

}
