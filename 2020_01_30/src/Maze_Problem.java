
/**
 * @author DELL
 * @Date 2020/1/30 18:42
 **/
public class Maze_Problem {
    public static void main(String[] args) {
        //使用数组代替迷宫
        int[][] map = new int[8][7];
        //初始化map
        for (int i = 0; i < 7; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
        //调用小球探路的方法
        setWay(map,1,1);
        //打印地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * @param map
     * @param i
     * @param j
     * @return 如果找到通路则返回true，否则返回false
     */
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5]==2){
            return true;
        }else{
            if(map[i][j]==0){
                map[i][j]=2;//假设该点可以走通
                if(setWay(map,i+1,j)){//向下走
                    return true;
                }else if(setWay(map,i,j+1)){//向右走
                    return true;
                }else if(setWay(map,i-1,j)){//向上走
                    return true;
                }else if(setWay(map,i,j-1)){//向左走
                    return true;
                }else{
                    //该点走不通，为死路
                    map[i][j]=3;
                    return false;
                }
            }else{//map[i][j]!=0
                return false;
            }
        }
    }
}
