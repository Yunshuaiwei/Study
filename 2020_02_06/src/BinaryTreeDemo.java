
/**
 * @author DELL
 * @Date 2020/2/6 10:42
 **/
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(1, "Tom");
        Node node1 = new Node(2, "Jack");
        Node node2 = new Node(3, "Mary");
        Node node3 = new Node(4, "Smith");
        Node node4 = new Node(5, "Job");
        binaryTree.setRoot(root);
        root.setLeft(node1);
        root.setRight(node2);
        node2.setRight(node3);
        node2.setLeft(node4);

        System.out.println("前序：");
        binaryTree.preOrder();
        binaryTree.delNode(3);
        System.out.println("删除后：");
        binaryTree.preOrder();
//        System.out.println("中序");
//        binaryTree.infixOrder();
//        System.out.println("后序");
//        binaryTree.postOrder();
//        Node node = binaryTree.preOrderSearch(3);
//        if(node!=null){
//            System.out.println(node.toString());
//        }else{
//            System.out.println("没有该节点！");
//        }

    }
}

class BinaryTree {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空！");
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空！");
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空！");
        }
    }

    /**
     * 前序遍历查找
     *
     * @param no
     * @return
     */
    public Node preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    /**
     * 中序遍历查找
     *
     * @param no
     * @return
     */
    public Node infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    /**
     * 后序遍历查找
     *
     * @param no
     * @return
     */
    public Node postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    public void delNode(int no) {
        if (this.root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("该二叉树为空！");
        }
    }
}

class Node {
    private int no;
    private String name;
    private Node left;
    private Node right;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
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

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 前序遍历查找
     *
     * @param no 需要查找的节点编号
     * @return 找到则返回该节点，否则返回NULL
     */
    public Node preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        Node node = null;
        if (this.left != null) {
            node = this.left.preOrderSearch(no);
        }
        if (node != null) {
            return node;
        }
        if (this.right != null) {
            node = this.right.preOrderSearch(no);
        }
        return node;
    }

    /**
     * 中序遍历查找
     *
     * @param no 查找的节点号
     * @return 找到返回该节点，否则返回NULL
     */
    public Node infixOrderSearch(int no) {
        Node node = null;
        if (this.left != null) {
            node = this.left.infixOrderSearch(no);
        }
        if (node != null) {
            return node;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            node = this.right.infixOrderSearch(no);
        }
        return node;
    }

    /**
     * 后序遍历
     *
     * @param no 查找的号码
     * @return 找到返回该节点，否则返回NULL
     */
    public Node postOrderSearch(int no) {
        Node node = null;
        if (this.left != null) {
            node = this.left.postOrderSearch(no);
        }
        if (node != null) {
            return node;
        }
        if (this.right != null) {
            node = this.right.postOrderSearch(no);
        }
        if (node != null) {
            return node;
        }
        if (this.no == no) {
            return this;
        } else {
            return null;
        }
    }

    /**
     * 删除节点
     *
     * @param no 节点编号
     */
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }
}
