import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author DELL
 * @Date 2020/2/15 17:12
 **/
public class GraphDemo {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        String[] vertex = {"A", "B", "C", "D", "E"};
        for (String s : vertex) {
            graph.insertVertex(s);
        }
        //添加边
        graph.insertEdges(0, 1, 1);//A-B
        graph.insertEdges(0, 2, 1);
        graph.insertEdges(1, 2, 1);
        graph.insertEdges(1, 3, 1);
        graph.insertEdges(1, 4, 1);

        graph.showGraph();
    }
}

class Graph {
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //打印出邻接矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 插入节点
     *
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 插入边
     *
     * @param v1     第一个顶点
     * @param v2     第二个顶点
     * @param weight 权值
     */
    public void insertEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}