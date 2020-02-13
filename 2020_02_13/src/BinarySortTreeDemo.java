/**
 * @author DELL
 * @Date 2020/2/13 11:23
 **/
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree sortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            sortTree.add(new Node(arr[i]));
        }
        sortTree.infixOrder();
    }
}

class BinarySortTree {
    private Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("当前二叉树为空！");
        }
    }
}

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

    /**
     * 查找需要删除的节点
     * @param value 需要删除的节点
     * @return 找到返回此节点，否则返回null
     */
    public Node search(int value){
        if(value==this.val){//要查找的值等于当前节点的值
            return this;
        }else if(value<this.val){//查找的值小于当前节点的值
            if(this.left==null){//左子节点为空，说明没有该节点
                return null;
            }else{//向左递归查找
                return this.left.search(value);
            }
        }else{//查找的值大于等于当前节点的值
            if(this.right==null){//右子节点为空，说明没有该值
                return null;
            }else{//向右递归
                return this.right.search(value);
            }
        }
    }

    /**
     *
     * @param val 要找到的节点值
     * @return 返回父节点
     */
    public Node searchParent(int val){
        return null;
    }
    /**
     * 添加元素
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.val < this.val) {
            if (this.left == null) {
                this.left = node;
            } else {
                //向左递归
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                //向右递归
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this.val);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}