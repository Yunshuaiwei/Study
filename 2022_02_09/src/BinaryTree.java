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
     * @description 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(6);
        //左子树
        root.left = left;
        //右子树
        root.right = right;
        //左子树的左子树
        left.left = node1;
        //左子树的右子树
        left.right = node2;
        //右子树的左子树
        right.left = node3;
        levelOrderTraversal(root);
        System.out.println(binaryTreePaths(root).toString());
    }
}
