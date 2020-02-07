package ThreadBinaryTree;

import com.sun.media.sound.SoftTuning;

class ThreadedBinaryTree {
    private Node root;
    private Node pre=null;
    public void setRoot(Node root) {
        this.root = root;
    }
    public void threadNodes(){
        this.threadNodes(root);
    }
    /**
     * 线索化
     * @param node
     */
    public void threadNodes(Node node){
        if(node==null){
            return;
        }
        //线索化左子树
        threadNodes(node.getLeft());
        //线索化当前节点
        if(node.getLeft()==null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //处理后继节点
        if(pre!=null&&pre.getRight()==null){
            //让前驱节点的有指针指向当前节点
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre=node;
        //线索化右子树
        threadNodes(node.getRight());
    }

    /**
     * 遍历线索化二叉树
     */
    public void threadedList(){
        Node node=root;
        while(node!=null){
            //循环找到leftType==1的节点，当leftType==1说明
            // 该节点是按照线索化处理后的有效节点
            while(node.getLeftType()==0){
                node=node.getLeft();
            }
            System.out.println(node.toString());
            //如果当前节点的右指针指向后继节点就一直输出
            while(node.getRightType()==1){
                //获取当前节点的后继节点
                node=node.getRight();
                System.out.println(node.toString());
            }
            //替换节点
            node=node.getRight();
        }
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

