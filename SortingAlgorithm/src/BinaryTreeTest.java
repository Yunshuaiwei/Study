import utils.TreeNode;

import java.util.*;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/2/14 15:56
 */
public class BinaryTreeTest {


    /**
     * 二叉树前序遍历
     *
     * @author yunshuaiwei
     * @date 2023/2/14 15:57
     **/
    public void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preorder(node.left);
        preorder(node.right);
    }

    /**
     * 二叉树中序遍历
     *
     * @author yunshuaiwei
     * @date 2023/2/14 15:58
     **/
    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.println(node.val);
        inorder(node.right);
    }

    /**
     * 二叉树后序遍历
     *
     * @author yunshuaiwei
     * @date 2023/2/14 15:59
     **/
    public void postorder(TreeNode node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.val);
    }

    /**
     * 二叉树层序遍历
     *
     * @author yunshuaiwei
     * @date 2023/2/14 16:20
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
                assert poll != null;
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
     * 二叉树的前序遍历
     *
     * @author yunshuaiwei
     * @date 2023/3/1 16:06
     **/
    public void preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历
     *
     * @author yunshuaiwei
     * @date 2023/3/1 16:22
     **/
    public void inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pop();
                System.out.println(node.val);
                cur = node.right;
            }
        }
    }

    /**
     * 后续遍历
     *
     * @author yunshuaiwei
     * @date 2023/3/1 16:26
     **/
    public void postorderTraversal(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        Stack<TreeNode> treeNodes = new Stack<>();
        if (root == null) {
            return;
        }
        treeNodes.push(root);
        while (!treeNodes.isEmpty()) {
            TreeNode pop = treeNodes.pop();
            integers.add(pop.val);
            if (pop.left != null) {
                treeNodes.push(pop.left);
            }
            if (pop.right != null) {
                treeNodes.push(pop.right);
            }
        }
        Collections.reverse(integers);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
