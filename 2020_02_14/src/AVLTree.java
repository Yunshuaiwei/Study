/**
 * @author DELL
 * @Date 2020/2/14 11:37
 **/
class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

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
                    if (parent != null) {
                        //如果targetNode是parent的左子节点
                        if (parent.left.val == val) {
                            parent.left = targetNode.left;
                        } else {//targetNode是parent的左子节点
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {//删除的节点有右子节点
                    if (parent != null) {
                        if (parent.left.val == val) {//targetNode是parent的左子节点
                            parent.left = targetNode.right;
                        } else {//targetNode是parent的右子节点
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
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
