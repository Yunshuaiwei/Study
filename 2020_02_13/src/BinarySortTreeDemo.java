
/**
 * @author DELL
 * @Date 2020/2/13 11:23
 **/
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree sortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            sortTree.add(new Node(arr[i]));
        }
        sortTree.delNode(10);
        System.out.println("删除后：");
        sortTree.infixOrder();
    }
}

class BinarySortTree {
    private Node root;

    public Node search(int val) {
        if (root == null) {
            return null;
        } else {
            return root.search(val);
        }
    }

    public Node searchParent(int val) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(val);
        }
    }

    /**
     * 返回以node为根节点的二叉排序树的最小值
     * 删除node为根节点的二叉排序树的最小节点
     *
     * @param node 传入的节点(当成根节点)
     * @return 返回以node为根节点的二叉排序树的最小值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环左子节点
        while (target.left != null) {
            target = target.left;
        }
        //删除该节点
        delNode(target.val);
        return target.val;
    }

    /**
     * 删除节点
     *
     * @param val 需要删除的节点
     */
    public void delNode(int val) {
        if (root == null) {//如果根节点为空则直接返回
            return;
        } else {
            //需要删除的节点
            Node targetNode = search(val);
            if (targetNode == null) {//如果此节点为空则说明没有此节点
                return;
            }
            if (root.left == null && root.right == null) {//需要删除的节点为根节点
                root = null;
                return;
            }
            //需要删除节点的父节点
            Node parent = searchParent(val);
            if (targetNode.left == null && targetNode.right == null) {//删除的节点为叶子节点
                if (parent.left != null && parent.left.val == val) {//左子节点
                    parent.left = null;
                } else if (parent.right != null && parent.right.val == val) {//右子节点
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {//删除只两棵子树的节点
                targetNode.val = delRightTreeMin(targetNode.right);
            } else {//删除有一棵子树的节点
                //删除的节点有左子节点
                if (targetNode.left != null) {
                    //如果targetNode是parent的左子节点
                    if (parent.left.val == val) {
                        parent.left = targetNode.left;
                    } else {//targetNode是parent的左子节点
                        parent.right = targetNode.left;
                    }
                } else {//删除的节点有右子节点
                    if (parent.left.val == val) {//targetNode是parent的左子节点
                        parent.left = targetNode.right;
                    } else {//targetNode是parent的右子节点
                        parent.right = targetNode.right;
                    }
                }
            }
        }
    }

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
     *
     * @param value 需要删除的节点
     * @return 找到返回此节点，否则返回null
     */
    public Node search(int value) {
        if (value == this.val) {//要查找的值等于当前节点的值
            return this;
        } else if (value < this.val) {//查找的值小于当前节点的值
            if (this.left == null) {//左子节点为空，说明没有该节点
                return null;
            } else {//向左递归查找
                return this.left.search(value);
            }
        } else {//查找的值大于等于当前节点的值
            if (this.right == null) {//右子节点为空，说明没有该值
                return null;
            } else {//向右递归
                return this.right.search(value);
            }
        }
    }

    /**
     * 查找需要删除节点的父节点
     *
     * @param val 要找到的节点值
     * @return 返回父节点
     */
    public Node searchParent(int val) {
        if ((this.left != null && this.left.val == val) ||
                (this.right != null && this.right.val == val)) {
            return this;
        } else {
            //如果查找的值小于当前节点的值且当前节点的左子节点不为空
            if (val < this.val && this.left != null) {
                return this.left.searchParent(val);
            } else if (val >= this.val && this.right != null) {
                return this.right.searchParent(val);
            } else {//没有父节点
                return null;
            }
        }
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
        System.out.println(this.toString());
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