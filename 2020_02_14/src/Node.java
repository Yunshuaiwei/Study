class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

    /**
     * @return 返回左子树高度
     */
    public int leftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.height();
        }
    }

    /**
     * @return 返回右子树高度
     */
    public int rightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.height();
        }
    }

    /**
     * @return 返回以该节点为根节点的树的高度
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(),
                right == null ? 0 : right.height()) + 1;
    }

    /**
     * 左旋转
     */
    private void leftRotate(){
        //创建新的节点
        Node newNode = new Node(this.val);
        //新节点的左子树设置为当前节点的左子树
        newNode.left=this.left;
        //右子树设置为当前节点右子树的左子树
        newNode.right=this.right.left;
        //当前节点的值换为右子节点的值
        this.val=this.right.val;
        //当前节点的右子树设置为当前节点右子树的右子树
        this.right=this.right.right;
        //当前节点的左子节点设置为新的节点
        this.left=newNode;
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
        //当添加完节点后，如果(左子树的高度-右子树的高度)>1，左旋转
        if(rightHeight()-leftHeight()>1){
            //左旋转
            leftRotate();
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