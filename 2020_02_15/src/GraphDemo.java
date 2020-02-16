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
        System.out.println("深度优先遍历：");
        graph.dfs();
    }
}

class Graph {
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    private boolean[] isVisited;

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    /**
     * 判断它的邻接节点
     *
     * @param index 需要查找的下标
     * @return
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接节点的下标获取下一个邻接节点
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历
     *
     * @param isVisited 标记是否被访问过的数组
     * @param i         开始访问的下标
     */
    private void dfs(boolean[] isVisited, int i) {
        //首先访问该节点
        System.out.print(getValueByIndex(i) + "->");
        //将节点标记为已访问
        isVisited[i] = true;
        //查找节点i的跪一个邻接节点
        int w = getFirstNeighbor(i);
        while (w != -1) {//说明有邻接节点
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w节点被访问过
            w = getNextNeighbor(i, w);
        }
    }

    /**
     * 对dfs进行重载
     */
    public void dfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
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