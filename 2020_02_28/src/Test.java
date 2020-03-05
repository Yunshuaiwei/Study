import java.util.Scanner;

/**
 * @author DELL
 * @Date 2020/2/28 16:10
 **/
public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        int n;
        int m;
        while(i>0){
            n=scan.nextInt();
            m=scan.nextInt();
            System.out.println((n%(m+1))==0?"Win":"Lose");
            i--;
        }
    }
}
class Node{
    Node left;
    Node right;
    Node root;
    public int countNode(Node root){
        if(root==null){
            return 0;
        }
        return countNode(root.left)+countNode(root.right)+1;

    }

    /**
     * 获取叶子节点个数
     * @param root
     * @return
     */
    public int getLeafNode(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return getLeafNode(root.left)+getLeafNode(root.right);
    }
}
