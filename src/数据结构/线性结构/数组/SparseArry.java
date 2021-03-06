package 数据结构.线性结构.数组;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SparseArry {
    public static void main(String[] args) throws IOException {
        //先创建一个原始的二维数组
        //0.表示没有棋子，1表示黑子，2表示白子
        //准备原始二维数组
        int chessArr[][]=new int[11][11];
        chessArr[1][2]=1;
        chessArr[2][3]=2;
        for (int[] row: chessArr) {
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        System.out.println("************************************");
        //将二维数组转为稀疏数组
        //1.先遍历二维数组，得到非0数的个数
        int sum=0;
        for (int i=0;i<chessArr.length;i++){
            for (int j=0;j<chessArr.length;j++){
                if(chessArr[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println(sum);
        //创建对应的稀疏数组
        int sparseArr[][]=new int[sum+1][3];
        //给稀疏数组赋值
        sparseArr[0][0]=chessArr.length;
        sparseArr[0][1]=chessArr.length;
        sparseArr[0][2]=sum;
        //遍历二维数组，将非0的值存放到稀疏数组中
        int count=0;//用于记录是第几个非零数据
        for (int i=0;i<chessArr.length;i++){
            for (int j=0;j<chessArr.length;j++){
                if(chessArr[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr[i][j];
                }
            }
        }
        //将稀疏数组的值保存到文件中
        File file=new File("sparseArr.txt");
        FileWriter out=new FileWriter(file);
        //稀疏数组的输出
        for (int i=0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
            out.write(sparseArr[i][0]+"\t"+sparseArr[i][1]+"\t"+sparseArr[i][2]);
            System.out.println();
        }



        System.out.println("********************");
        //将稀疏数组转换为二维数组
        //1.读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int row=sparseArr[0][0];
        int col=sparseArr[0][1];
        int[][] chess=new int[row][col];
        for(int i=1;i<sparseArr.length;i++){
            chess[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        //打印数组的结果
        for (int[] row2: chess) {
            for(int data:row2){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }

}
