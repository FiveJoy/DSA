package cn.fivejoy.dsa.now.chapter7;

/**
 * @description: 给你一个数组arr，和一个整数aim。如果可以任意选择arr中的 数字，能不能累加得到aim，返回true或者false
 * @author: liulu
 * @create: 2019/11/23 09:54
 */
public class Nno8 {
    public boolean canAim(int[] arr, int aim) {
        // 对于目前已经经过选择的结果 当前sum=curSum
        //对于数组中的任意一个元素，都有两种选择，要加上，和不要加上。
        // 如果要加上，则当前sum=curSum+arr[i],不加上则当前sum=curSum
        //向后继续对数组元素进行选择
        //return canAim()
        return process(arr, 0, 0, aim);
    }

    public boolean process(int[] arr, int i, int curSum, int aim) {
        //basecase
//        if(curSum==aim){
//            return true;
//        }
//        if (i == arr.length ) {
//            return false;
//        }
        if (i == arr.length) {
            return curSum == aim;
        }
        //子问题-缩小数据规模的过程，
        return process(arr, i + 1, curSum, aim) || process(arr, i + 1, curSum + arr[i], aim);
    }

    /**
     * 记录子问题的解
     * 关心依赖状态
     *
     * @param arr
     * @param aim
     * @return
     */
    public boolean canAim_DP(int[] arr, int aim) {
        boolean dp[][] = new boolean[arr.length + 1][aim + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            dp[i][aim] = true;
        }
        for (int i = arr.length - 1; i >=0; i--) {
          for(int j=aim-1;j>=0;j--){

              dp[i][j]=dp[i+1][j];
              if((j+arr[i])<=aim){
                  dp[i][j]=dp[i][j]|| dp[i+1][j+arr[i]];
              }
          }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 7, 2, 9};
        Nno8 nno8 = new Nno8();
        System.out.println(nno8.canAim(arr, 11));
        System.out.println(nno8.canAim_DP(arr, 11));
    }
}
