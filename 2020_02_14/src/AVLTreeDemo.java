/**
 * @author DELL
 * @Date 2020/2/14 11:22
 **/
public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 5, 7, 8};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        System.out.println("左旋转后：");
        System.out.println("树的高度:" + avlTree.getRoot().height());
        System.out.println("右子树高度：" + avlTree.getRoot().rightHeight());
        System.out.println("左子树高度：" + avlTree.getRoot().leftHeight());
    }
}
