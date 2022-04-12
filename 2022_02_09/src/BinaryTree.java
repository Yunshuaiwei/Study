import common.TreeNode;

import java.util.*;

/**
 * @author yunshuaiwei
 * @className BinaryTree
 * @description: TODO
 * @date 2022/2/14 10:03
 */
public class BinaryTree {

    /**
     * @author yunshuaiwei
     * @description 二叉树前序遍历
     * @date 11:11 2022/3/7
     * @Param [root]
     * @Return void
     */
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * @author yunshuaiwei
     * @description 中序遍历
     * @date 11:18 2022/3/7
     * @Param [root]
     * @Return void
     */
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    /**
     * @author yunshuaiwei
     * @description 后序遍历
     * @date 11:20 2022/3/7
     * @Param [root]
     * @Return void
     */
    public static void afterOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        afterOrder(root.left);
        afterOrder(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * @author yunshuaiwei
     * @description 迭代版前序遍历
     * @date 14:25 2022/3/7
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
            TreeNode pop = stack.pop();
            System.out.print(pop.val + " ");
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    /**
     * @author yunshuaiwei
     * @description 迭代版中序遍历
     * @date 14:37 2022/3/7
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
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }

    /**
     * @author yunshuaiwei
     * @description 迭代版后序遍历
     * @date 14:53 2022/3/7
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
            res.add(pop);
            if (pop.left != null) {
                stack.add(pop.left);
            }
            if (pop.right != null) {
                stack.add(pop.right);
            }
        }
        while (!res.isEmpty()) {
            System.out.print(res.pop().val + " ");
        }
    }

    /**
     * @author yunshuaiwei
     * @description 二叉树层序遍历
     * @date 15:10 2022/3/7
     * @Param [root]
     * @Return void
     */
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        //层序遍历结果集
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int len = queue.size();
            while (len-- > 0) {
                TreeNode poll = queue.poll();
                assert poll != null;
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            lists.add(list);
        }
        lists.forEach(e -> {
            System.out.println(e.toString());
        });
    }

    /**
     * @author yunshuaiwei
     * @description 递归反转二叉树
     * @date 16:01 2022/3/7
     * @Param [root]
     * @Return void
     */
    public static void invertTree1(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree1(root.left);
        invertTree1(root.right);
    }

    /**
     * @author yunshuaiwei
     * @description 迭代法反转二叉树
     * @date 16:05 2022/3/7
     * @Param [root]
     * @Return void
     */
    public static void invertTree2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * @author yunshuaiwei
     * @description 对称二叉树
     * @date 15:24 2022/3/9
     * @Param [root]
     * @Return boolean
     */
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    /**
     * @author yunshuaiwei
     * @description 比较左子树和右子树的节点
     * @date 15:25 2022/3/9
     * @Param [left, right]
     * @Return boolean
     */
    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null) {
            return false;
        }
        if (right == null) {
            return false;
        }
        if (left.val == right.val) {
            return true;
        }
        return compare(left.left, right.right) && compare(left.right, right.left);
    }

    /**
     * @author yunshuaiwei
     * @description 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * @date 15:42 2022/3/9
     * @Param [root]
     * @Return int
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * @author yunshuaiwei
     * @description 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * @date 15:50 2022/3/9
     * @Param [root]
     * @Return int
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }
        // 左右结点都不为null
        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     * @author yunshuaiwei
     * @description 递归：给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
     * @date 20:43 2022/3/9
     * @Param [root]
     * @Return int
     */
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    /**
     * @author yunshuaiwei
     * @description 迭代：给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
     * @date 20:46 2022/3/9
     * @Param [root]
     * @Return int
     */
    public static int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {//一层
                TreeNode poll = queue.poll();
                res++;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return res;
    }


    /**
     * @author yunshuaiwei
     * @description 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * @date 20:54 2022/3/9
     * @Param
     * @Return
     */
    public static boolean isBalanced(TreeNode root) {
        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;
    }

    /**
     * @author yunshuaiwei
     * @description 树的高度
     * @date 20:58 2022/3/9
     * @Param [root]
     * @Return int
     */
    private static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }


    /**
     * @author yunshuaiwei
     * @description 给你一个二叉树的根节点 root ，按任意顺序 ，返回所有从根节点到叶子节点的路径。
     * @date 21:05 2022/3/9
     * @Param [root]
     * @Return java.util.List<java.lang.String>
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<String> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }

    private static void traversal(TreeNode root, List<String> paths, List<String> res) {
        if (root == null) {
            return;
        }
        paths.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            //构造结果集
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1);//回溯
        }
        if (root.right != null) {
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1);//回溯
        }
    }

    /**
     * @author yunshuaiwei
     * @description 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     * @date 14:51 2022/3/10
     * @Param [n]
     * @Return int
     */
    public int numTrees(int n) {
        //初始化 dp 数组
        int[] dp = new int[n + 1];
        //初始化0个节点和1个节点的情况
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加
                //一共i个节点，对于根节点j时,左子树的节点个数为j-1，右子树的节点个数为i-j
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    /**
     * @author yunshuaiwei
     * @description 给定二叉树的根节点 root ，返回所有左叶子之和。
     * @date 15:00 2022/3/14
     * @Param [root]
     * @Return int
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int res = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                res += node.left.val;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    /**
     * @author yunshuaiwei
     * @description 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
     * @date 15:37 2022/3/14
     * @Param [root]
     * @Return int
     */
    public static int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            lists.add(list);
        }
        return lists.get(lists.size() - 1).get(0);
    }

    /**
     * @author yunshuaiwei
     * @description 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。
     * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。如果存在，返回 true ；否则，返回 false 。
     * @date 16:07 2022/3/14
     * @Param [root, targetSum]
     * @Return boolean
     */
    private static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        // 叶子结点
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        if (root.left != null) {
            boolean left = hasPathSum(root.left, targetSum);
            if (left) {// 已经找到
                return true;
            }
        }
        if (root.right != null) {
            boolean right = hasPathSum(root.right, targetSum);
            if (right) {// 已经找到
                return true;
            }
        }
        return false;
    }

    /**
     * @author yunshuaiwei
     * @description 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
     * 你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
     * @date 14:48 2022/3/17
     * @Param [root1, root2]
     * @Return common.TreeNode
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode newNode = new TreeNode(root1.val + root2.val);
        newNode.left = mergeTrees(root1.left, root2.left);
        newNode.right = mergeTrees(root1.right, root2.right);
        return newNode;
    }


    /**
     * @author yunshuaiwei
     * @description 给定二叉搜索树（BST）的根节点root和一个整数值val。
     * 你需要在 BST 中找到节点值等于val的节点。 返回以该节点为根的子树。 如果节点不存在，则返回null。
     * @date 15:00 2022/3/17
     * @Param [root, val]
     * @Return common.TreeNode
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }

    /**
     * @author yunshuaiwei
     * @description 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     * @date 15:06 2022/3/17
     * @Param [root]
     * @Return boolean
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pre != null && pre.val >= pop.val) {
                return false;
            }
            pre = pop;
            root = pop.right;
        }
        return true;
    }

    /**
     * @author yunshuaiwei
     * @description 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
     * 差值是一个正数，其数值等于两值之差的绝对值。
     * @date 15:27 2022/3/17
     * @Param [root]
     * @Return int
     */
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        int min = Integer.MAX_VALUE;
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (pre != null) {
                min = Math.min(min, Math.abs(pre.val - node.val));
            }
            pre = node;
            root = node.right;
        }
        return min;
    }

    /**
     * @author yunshuaiwei
     * @description 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
     * 如果树中有不止一个众数，可以按 任意顺序 返回。
     * @date 15:43 2022/3/17
     * @Param [root]
     * @Return int[]
     */
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        int count = 0;
        int maxValue = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (pre == null || pre.val != node.val) {
                count = 1;
            } else {
                count++;
            }
            //更新结果
            if (count > maxValue) {
                maxValue = count;
                list.clear();
                list.add(node.val);
            } else if (count == maxValue) {
                //多个众数
                list.add(node.val);
            }
            pre = node;
            root = node.right;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * @author yunshuaiwei
     * @description 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * @date 16:09 2022/3/17
     * @Param [root, p, q]
     * @Return common.TreeNode
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        } else if (left != null && right == null) {//找到一个节点
            return left;
        } else if (left == null) {
            return right;
        } else {//找到两个节点
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(6);
        //左子树
        root.left = right;
        //右子树
        root.right = right;
        //左子树的左子树
        left.left = node1;
        //左子树的右子树
        left.right = node2;
        //右子树的左子树
        right.left = node3;
        levelOrderTraversal(root);
    }
}
