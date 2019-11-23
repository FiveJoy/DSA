package cn.fivejoy.dsa.now.chapter7;

/**
 * @description:
 * 给定两个数组w和v，两个数组长度相等，
 * w[i]表示第i件商品的 重量，v[i]表示第i件商品的价值。
 *
 * 再给定一个整数bag，要求你挑选商品的重量加起来一定不能超 过bag，返回满足这个条件下，你能获得的最大价值
 * @author: liulu
 * @create: 2019/11/23 11:44
 */
public class Nno9 {

    public int getMaxValue(int[] w,int[] v,int bag){
        return process(w,v,0,0,bag);
    }
    public int process(int[] w,int[] v,int i,int curWeight,int bag){

        if(curWeight>bag){
            //任意时刻，只要超了，这条路就走不通了，直接置为系统最小——中途可以直接减支 也可以到末尾
            // 之前做的选择影响了curweight
            return Integer.MIN_VALUE;
        }
        if(i==w.length){
            return 0;//当i到末尾的时候已经没有商品了 收益自然为0
        }
        return Math.max(
                v[i]+process(w,v,i+1,curWeight+w[i],bag),
                process(w,v,i+1,curWeight,bag)
        );
    }

    public int getMaxValue_DP(int[] w,int[] v,int bag){
        int[][] dp=new int[w.length+1][bag+1];
        for(int i=0;i<bag;i++){
            dp[w.length][i]=0;
        }
        for(int i=w.length-1;i>=0;i--){
            for(int j=bag;j>=0;j--){
              if((j+w[i])<=bag){
                  dp[i][j]=Math.max(v[i]+dp[i+1][j+w[i]],dp[i+1][j]);
              }else{
                  //这里相当于 dp[i][j]=Math.max(Integer.MIN_VALUE,dp[i+1][j]);
                  dp[i][j]=dp[i+1][j];
              }
            }
        }
        return dp[0][0];// process(w,v,0,0,bag)
    }

    public static void main(String[] args) {
        Nno9 nno9=new Nno9();

        int[] c = { 3, 2, 4, 7 };
        int[] p = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(nno9.getMaxValue(c, p, bag));
        System.out.println(nno9.getMaxValue_DP(c, p, bag));
     //   System.out.println(maxValue2(c, p, bag));
    }
}


/// 是无后向性的问题
// 前面做的选择，不管是怎么到达当前的状态的，只要到了这个状态，这个状态下的返回值就是一定的，不变的。
// 只有无后向性的递归才能改DP。