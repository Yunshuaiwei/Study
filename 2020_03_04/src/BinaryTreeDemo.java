import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 * @Date 2020/3/4 14:04
 **/
public class BinaryTreeDemo {
    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        Node root = tree.getTree();
        Node tree1 = tree.getTree();
        System.out.println("前序遍历：");
        tree.preOrder();
        System.out.println("中序遍历：");
        tree.inOrder();
        System.out.println("后序遍历：");
        tree.postOrder();
        int nodeNum = tree.getNodeNum(root);
        System.out.println("二叉树中节点的个数：" + nodeNum);
        int leafNum = tree.getLeafNum(root);
        System.out.println("二叉树中叶子节点的个数为：" + leafNum);
        int height = tree.getHeight(root);
        System.out.println("二叉树的高度为：" + height);
        boolean b = tree.find(root, 5);
        System.out.println(b);
    }


}

class MyBinaryTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    /**
     *
     * @return
     */
    public Node getTree(){
        root = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(5);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(6);
        root.setLeftNode(node1);
        root.setRightNode(node2);
        node1.setLeftNode(node3);
        node2.setLeftNode(node4);
        node2.setRightNode(node5);
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }
    /**
     * 查找节点
     *
     * @param root 根节点
     * @param val  查找的节点值为val
     * @return 找到返回true，否则返回false
     */
    public boolean find(Node root, int val) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            return true;
        }
        if (find(root.leftNode, val)) {
            return true;
        }
        if (find(root.rightNode, val)) {
            return true;
        }
        return false;
    }

    /**
     * 求树的高度
     *
     * @param root 根节点
     * @return 返回树的高度
     */
    public int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return getHeight(root.leftNode) > getHeight(root.rightNode) ?
                getHeight(root.leftNode) + 1 : getHeight(root.rightNode) + 1;
    }

    /**
     * 求叶子节点的个数
     *
     * @param root 根节点
     * @return 返回叶子节点的个数
     */
    public int getLeafNum(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.leftNode == null && root.rightNode == null) {
            return 1;
        }
        return getLeafNum(root.leftNode) + getLeafNum(root.rightNode);
    }

    /**
     * 求节点的个数
     *
     * @param root 根节点
     * @return 返回节点个数
     */
    public int getNodeNum(Node root) {
        if (root == null) {
            return 0;
        }
        return getNodeNum(root.leftNode) + getNodeNum(root.rightNode) + 1;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (root == null) {
            System.out.println("二叉树为空！");
        } else {
            List<Integer> arr = root.preOrder(root);
            System.out.println(arr);
        }
        System.out.println();
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        if (this.root == null) {
            System.out.println("此二叉树为空！");
        } else {
            this.root.inOrder(this.root);
        }
        System.out.println();
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (this.root == null) {
            System.out.println("此二叉树为空！");
        } else {
            this.root.postOrder(this.root);
        }
        System.out.println();
    }
}

class Node {
    Node leftNode;
    Node rightNode;
    int val;

    public Node(int val) {
        this.val = val;
        leftNode = null;
        rightNode = null;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    /**
     * 前序遍历
     *
     * @param root 根节点
     */
    static ArrayList<Integer> arr = new ArrayList<>();

    public List<Integer> preOrder(Node root) {
        if (root == null) {
            return arr;
        }
        arr.add(root.val);
        preOrder(root.leftNode);
        preOrder(root.rightNode);
        return arr;
    }

    /**
     * 中序遍历
     *
     * @param root 根节点
     */
    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.leftNode);
        System.out.print(root.val + " ");
        inOrder(root.rightNode);
    }

    /**
     * 后序遍历
     *
     * @param root 根节点
     */
    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.leftNode);
        postOrder(root.rightNode);
        System.out.print(root.val + " ");
    }

    public boolean isSameTree(Node p, Node q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null){
            return false;
        }
        if(q==null){
            return false;
        }
        if(p.val==q.val){
            return true;
        }
        boolean a = isSameTree(p.leftNode, q.leftNode);
        boolean b = isSameTree(p.rightNode, q.rightNode);
        if(a&&b){
            return true;
        }
        return false;
    }
}