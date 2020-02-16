package Algorithm;

/**
 * @author DELL
 * @Date 2020/2/16 17:05
 **/
public class DivideAndConquer {
    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第" + num + "个盘从" + a + "->" + c);
        } else {
            //如果大于两个盘，将上面的所有盘看成一个盘，最下面的为一个盘
            //将上面的所有盘从A->B,移动过程使用C
            hanoiTower(num - 1, a, c, b);
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            //B所有盘从B->C,移动过程使用a
            hanoiTower(num - 1, b, a, c);
        }
    }
}
