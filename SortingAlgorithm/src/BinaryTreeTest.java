import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
}
