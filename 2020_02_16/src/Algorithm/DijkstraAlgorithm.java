package Algorithm;

import java.util.Arrays;

/**
 * @author DELL
 * @Date 2020/2/21 16:44
 **/
public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //邻接矩阵
        final int N = 65535;
        int[][] matrix = {
                {N, 5, 7, N, N, N, 2},
                {5, N, N, 9, N, N, 3},
                {7, N, N, N, 8, N, N},
                {N, 9, N, N, N, 4, N},
                {N, N, 8, N, N, 5, 4},
                {N, N, N, 4, 5, N, 6},
                {2, 3, N, N, 4, 6, N},};
        Map map = new Map(vertex, matrix);
        map.dijkstra(6);
        map.show();
    }
}

class Map {
    private char[] vertex;//顶点
    private int[][] matrix;//邻接矩阵
    private VisitedVertex vis;

    public Map(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    /**
     * 显式最终结果
     */
    public void show() {
        vis.show();
    }

    /**
     * 打印邻接矩阵
     */
    public void showMap() {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * 迪杰斯特拉算法核心
     *
     * @param index 起始顶点的下标
     */
    public void dijkstra(int index) {
        vis = new VisitedVertex(vertex.length, 6);
        update(index);//更新index顶点到周围顶点的距离和前驱
        for (int i = 1; i < vertex.length; i++) {
            index = vis.updateArr();//选择并返回新的访问节点
            update(index);//更新index顶点到周围顶点的距离和前驱节点
        }
    }

    private void update(int index) {
        int len = 0;
        for (int j = 0; j < matrix[index].length; j++) {
            //len 表示出发顶点到index顶点的距离+从index顶点到j顶点的距离的和
            len = vis.getDis(index) + matrix[index][j];
            //如果顶点没有被访问过，并且len小于出发顶点到j顶点的距离，则更新
            if (!vis.visited(j) && len < vis.getDis(j)) {
                vis.updateDis(j, len);//更新出发顶点到j顶点的距离
                vis.updatePre(j, index);
            }
        }
    }
}

//被访问过的节点
class VisitedVertex {
    //记录节点是否被访问，访问过用1表示，未访问过用0表示
    public int[] already_arr;
    //每个下标对应的值为它前驱节点对应的下标
    public int[] pre_visited;
    //记录出发顶点到其他顶点的距离
    public int[] dis;

    /**
     * @param length 顶点的个数
     * @param index  出发顶点对应的下标
     */
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.dis = new int[length];
        this.pre_visited = new int[length];
        //初始化dis数组
        Arrays.fill(dis, 65535);
        this.already_arr[index] = 1;//将出发顶点设置为被访问
        dis[index] = 0;
    }

    /**
     * 判断此节点是否被访问过
     *
     * @param index 顶点下标
     * @return 访问过返回true，否则返回false
     */
    public boolean visited(int index) {
        return already_arr[index] == 1;
    }

    /**
     * 更新出发顶点到index顶点的距离
     *
     * @param index 顶点下标
     * @param len   距离
     */
    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    /**
     * 更新pre顶点的前驱顶点为index
     *
     * @param pre
     * @param index
     */
    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    /**
     * 返回出发顶点到index顶点的距离
     *
     * @param index
     * @return
     */
    public int getDis(int index) {
        return dis[index];
    }

    /**
     * 继续选择并返回新的访问节点，例如G访问完之后就将A作为新的访问节点
     *
     * @return
     */
    public int updateArr() {
        int min = 65535, index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        already_arr[index] = 1;
        return index;
    }

    /**
     * 显式最后结果
     */
    public void show() {
        for (int i : already_arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : pre_visited) {
            System.out.print(i + " ");
        }
        System.out.println();
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int count = 0;
        for (int i : dis) {
            if (i != 65535) {
                System.out.print(vertex[count] + "(" + i + ")");
            } else {
                System.out.println("N ");
            }
            count++;
        }
        System.out.println();
    }
}