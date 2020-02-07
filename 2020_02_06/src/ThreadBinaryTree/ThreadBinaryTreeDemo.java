package ThreadBinaryTree;

/**
 * @author DELL
 * @Date 2020/2/7 11:35
 **/
public class ThreadBinaryTreeDemo {
    public static void main(String[] args) {
        Node root = new Node(1, "Tom");
        Node node2 = new Node(3, "Jack");
        Node node3 = new Node(6, "Smith");
        Node node4 = new Node(8, "Mary");
        Node node5 = new Node(10, "Job");
        Node node6 = new Node(14, "Back");
        ThreadedBinaryTree binaryTree = new ThreadedBinaryTree();
        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        binaryTree.threadNodes();
        Node left = node5.getLeft();
        System.out.println(left.toString());
    }
}
