package Algorithm;

import java.util.Arrays;

/**
 * @author DELL
 * @Date 2020/2/20 17:11
 **/
public class KruskalCrAlgorithm {
    private int edgeNum;//边的个数
    private char[] vertex;//顶点个数
    private int[][] matrix;//邻接矩阵
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}};
        KruskalCrAlgorithm kruskal = new KruskalCrAlgorithm(vertex, matrix);
        kruskal.kruskal();
    }

    public KruskalCrAlgorithm(char[] vertex, int[][] matrix) {
        int len = vertex.length;
        this.vertex = new char[len];
        //使用赋值拷贝方式初始化
        for (int i = 0; i < len; i++) {
            this.vertex[i] = vertex[i];
        }
        this.matrix = new int[len][len];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        //统计边的个数
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    /**
     * 克鲁斯卡尔算法核心
     */
    public void kruskal() {
        int index = 0;//表示最后结果数组的索引
        int[] ends = new int[edgeNum];//保存最小生成树中顶点对应的终点的下标
        EdgeData[] result = new EdgeData[edgeNum];//用于保存最小生成树的结果
        EdgeData[] edges = getEdges();//获取图中所有的边
        sortEdges(edges);//对边从小到大排序
        //遍历edges，将边添加到最小生成树中
        for (int i = 0; i < edgeNum; i++) {
            //获取边的起点
            int p1 = getPosition(edges[i].start);//p1=4
            //获取边的终点
            int p2 = getPosition(edges[i].end);//p2=5
            //获取p1在最小生成树中的终点
            int m = getEnd(ends, p1);//m=4
            //获取p2在最小生成树中的终点
            int n = getEnd(ends, p2);//n=5
            //判断p1和p2是否构成回路
            if (m != n) {//没有构成回路
                ends[m] = n;//设置m在最小生成树中的终点为n，例如<E,F>[0,0,0,0,5,0,0,0,0,0,0,0]即4的终点为5
                result[index++] = edges[i];//将一条边加入数组中
            }
        }
        //打印最小生成树
        for (int i = 0; i < index; i++) {
            System.out.println(result[i]);
        }
    }

    /**
     * 打印邻接矩阵
     */
    public void showMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 对边进行排序
     *
     * @param edges
     */
    public void sortEdges(EdgeData[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EdgeData temp = edges[j + 1];
                    edges[j + 1] = edges[j];
                    edges[j] = temp;
                }
            }
        }
    }

    /**
     * 返回顶点对应的下标
     *
     * @param ch
     * @return 找到则返回对应下标，否则返回-1
     */
    private int getPosition(char ch) {
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == ch) {//找到
                return i;
            }
        }
        //没找到
        return -1;
    }

    /**
     * 获取图中的边，存放在数组中
     *
     * @return 返回对应的数组
     */
    private EdgeData[] getEdges() {
        int index = 0;
        EdgeData[] edges = new EdgeData[edgeNum];
        for (int i = 0; i < vertex.length; i++) {
            for (int j = i + 1; j < vertex.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EdgeData(vertex[i], vertex[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取下标为i的顶点的终点
     *
     * @param ends 数组记录各个顶点对应的终点是哪一个
     * @param i    传入顶点对应的下标
     * @return 返回下标为i的这个顶点对应的终点的下标
     */
    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }
}

//边的信息
class EdgeData {
    char start;//边的起点
    char end;//边的终点
    int weight;//边的权值

    public EdgeData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EdgeData <" + start + "," + end + ">=" + weight;
    }
}