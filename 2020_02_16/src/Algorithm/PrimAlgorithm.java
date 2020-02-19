package Algorithm;

import java.util.Arrays;

/**
 * @author DELL
 * @Date 2020/2/19 19:29
 **/
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertex = data.length;
        //10000表示两个点不连通
        int[][] weight = {
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};
        Graph graph = new Graph(vertex);
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, vertex, data, weight);
        minTree.prim(graph, 0);
    }
}

class MinTree {
    /**
     * 创建图的邻接矩阵
     *
     * @param graph  图对象
     * @param vertex 图对应的顶点个数
     * @param data   图的各个顶点的值
     * @param weight 图的邻接矩阵的权值
     */
    public void createGraph(Graph graph, int vertex, char[] data, int[][] weight) {
        for (int i = 0; i < vertex; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < vertex; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    /**
     * 打印图的邻接矩阵
     *
     * @param graph 图对象
     */
    public void displayGraph(Graph graph) {
        for (int[] ints : graph.weight) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * 生成最小生成树
     *
     * @param graph 图对象
     * @param v     表示从第v个节点开始
     */
    public void prim(Graph graph, int v) {
        //表示节点是否被访问过，访问过用1表示
        int[] visited = new int[graph.vertex];
        //把当前节点表示为已访问
        visited[v] = 1;
        //h1和h2用来标记加入最小生成树中的节点坐标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;
        for (int i = 1; i < graph.vertex; i++) {//有graph.vertex个顶点，需要生成graph.vertex-1条边，所以i从1开始
            for (int j = 0; j < graph.vertex; j++) {
                for (int k = 0; k < graph.vertex; k++) {
                    if (visited[j] == 1 && visited[k] == 0 && graph.weight[j][k] < minWeight) {
                        minWeight = graph.weight[j][k];
                        h1 = j;
                        h2 = k;
                    }
                }
            }
            //找到一条最小边
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + ">权值：" + minWeight);
            //将节点标记为已经访问过
            visited[h2] = 1;
            //重置minWeight
            minWeight = 10000;
        }
    }

}

class Graph {
    int vertex;//表示图的节点个数
    char[] data;
    int[][] weight;

    public Graph(int vertex) {
        this.vertex = vertex;
        this.data = new char[vertex];
        this.weight = new int[vertex][vertex];
    }
}
