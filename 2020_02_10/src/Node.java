/**
 * @author DELL
 * @Date 2020/2/10 13:48
 **/
class Node implements Comparable<Node>{
    public Byte data;
    public int weight;
    public Node left;
    public Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node [data="+data+" weight="+weight+"]";
    }

    @Override
    public int compareTo(Node o) {
        //从小到大
        return this.weight-o.weight;
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
}
