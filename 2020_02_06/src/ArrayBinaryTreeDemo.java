/**
 * @author DELL
 * @Date 2020/2/6 17:19
 **/
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder();
    }
}

class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 重载preOrder方法
     */
    public void preOrder() {
        this.preOrder(0);
    }

    /**
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.print("数组为空！");
        }
        System.out.println(arr[index]);
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}
