package cn.fivejoy.dsa.now.chapter7;

/**
 * @description:
 * 二维数组的最短路径问题
 *
 * 给你一个二维数组，二维数组中的每个数都是正数，要求从左上
 * 角走到右下角，每一步只能向右或者向下。沿途经过的数字要累
 * 加起来。返回最小的路径和
 * @author: liulu
 * @create: 2019/11/23 10:36
 */
public class Nno7 {

    public int getMinPath(int[][]matrix){
        return process(matrix,0,0);
    }
    public int process(int[][]matrix,int i,int j){
        int cur=matrix[i][j];
        if(i==matrix.length-1&&j==matrix[0].length-1){
            return cur;
        }
        if(i==matrix.length-1){
            return cur+process(matrix, i,j+1);
        }
        if(j==matrix[0].length-1){
            return cur+process(matrix, i+1, j);
        }
        return cur+ Math.min(process(matrix, i+1,j),process(matrix, i,j+1));
    }
    public int getMinPath_DP(int[][] matrix){
        int[][] dp=new int[matrix.length][matrix[0].length];
        int row=matrix.length-1;
        int col=matrix[0].length-1;
        dp[row][col]=matrix[row][col];

        for(int i=row-1;i>=0;i--){
            dp[i][col]=dp[i+1][col]+matrix[i][col];
        }
        for(int j=col-1;j>=0;j--){
            dp[row][j]=dp[row][j+1]+matrix[row][j];
        }
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                dp[i][j]=matrix[i][j]+Math.min(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        Nno7 nno7=new Nno7();
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(nno7.getMinPath(m));
    System.out.println(nno7.getMinPath_DP(m));
//
//        m = generateRandomMatrix(6, 7);
//        System.out.println(minPath1(m));
//        System.out.println(minPath2(m));
    }

}
