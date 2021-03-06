import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author DELL
 * @Date 2020/2/8 16:32
 **/
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        preOrder(root);
    }

    /**
     * 创建赫夫曼树
     *
     * @param arr 原始数组
     * @return 返回赫夫曼树的根节点
     */
    public static Node createHuffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        while (nodes.size() > 1) {
            //从小到大排序
            Collections.sort(nodes);
            //取出权值最小的节点
            Node leftNode = nodes.get(0);
            //取出权值次小的节点
            Node rightNode = nodes.get(1);
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //将最小的两个节点移除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的父节点加入集合中
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("该树为空！");
        }
    }
}

class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大
        return this.value - o.value;
    }
}
