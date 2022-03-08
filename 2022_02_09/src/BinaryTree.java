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
        invertTree2(root);
        levelOrderTraversal(root);
    }
}
