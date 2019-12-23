import com.sun.media.sound.SoftTuning;

/**
 * @author DELL
 * @Date 2019/12/23 15:45
 **/
public class SparseArrTest {
    public static void main(String[] args) {
        //0.创建原始二维数组
        //赋值：1表示黑色棋子，2表示蓝色棋子
        int [][]chessArr=new int[11][11];
        chessArr[1][2]=1;
        chessArr[2][3]=2;
        chessArr[4][5]=2;
        System.out.println("原始二维数组");
        for (int i = 0; i <chessArr.length ; i++) {
            for (int j = 0; j <chessArr[i].length ; j++) {
                System.out.printf("%d  ",chessArr[i][j]);
            }
            System.out.println();
        }
        //1.遍历二维数组，得到非0数据的个数
        int sum=0;
        for (int i = 0; i <chessArr.length ; i++) {
            for (int j = 0; j <chessArr[i].length ; j++) {
                if(chessArr[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println(sum);
        //2.创建稀疏数组
        int [][]sparseArr=new int [sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        //3.遍历二维数组，对稀疏数组赋值
        //用于记录是第几个非0数据
        int count=0;
        for (int i = 0; i <chessArr.length ; i++) {
            for (int j = 0; j <chessArr[i].length ; j++) {
                if(chessArr[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr[i][j];
                }
            }
        }
        //4.打印稀疏数组
        System.out.println("稀疏数组");
        for (int i = 0; i <sparseArr.length ; i++) {
            for (int j = 0; j <sparseArr[i].length ; j++) {
                System.out.printf("%d  ",sparseArr[i][j]);
            }
            System.out.println();
        }

        /**
         * 将稀疏数组转为二维数组
         */
        System.out.println("恢复后：");
        //1.创建二维数组
        int [][]chessArr2=new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int [] row:chessArr2) {
            for (int data:row) {
                System.out.printf("%d  ",data);
            }
            System.out.println();
        }
        //2.遍历稀疏数组，给二维数组赋值
        for (int i = 1; i <sparseArr.length ; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        //赋值后
        System.out.println("赋值后：");
        for (int [] row:chessArr2) {
            for (int data:row) {
                System.out.printf("%d  ",data);
            }
            System.out.println();
        }
    }
}
