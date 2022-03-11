import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yunshuaiwei
 * @className Main
 * @description: 笔试题
 * @date 2022/2/9 15:52
 */
public class Main {

    /**
     * @author yunshuaiwei
     * @description 极米科技笔试
     * @date 19:43 2022/3/11
     * @Param
     * @Return
     */
    public static double[] averageOfLevels(TreeNode root) {
        // write code here
        if (root == null) {
            return new double[0];
        }
        ArrayList<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int length = size;
            double res = 0;
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                res += poll.val;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            list.add(res / length);
        }
        double[] res = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * @author yunshuaiwei
     * @description 极米科技笔试
     * @date 19:44 2022/3/11
     * @Param [s, indices]
     * @Return java.lang.String
     */
    public static String shuffle(String s, int[] indices) {
        // write code here
        char[] chars = s.toCharArray();
        char[] res = new char[chars.length];
        for (int i = 0; i < indices.length; i++) {
            res[indices[i]] = chars[i];
        }
        return String.valueOf(res);
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

        int[] res = new int[]{1, 3, 4, 2, 0};


        System.out.println(shuffle("gmiix", res));
    }
}
