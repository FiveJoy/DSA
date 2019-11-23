package cn.fivejoy.dsa.leet;

/**
 * @description: https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode/#comment
 * @author: liulu
 * @create: 2019/11/20 13:26
 */
public class Solution198 {
    /**
     * 看了题解，
     *  定义f(n)和Ai的值。然后n=1,2,3,找规律
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums==null||nums.length<=0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int[] sumMoney=new int[nums.length];
        sumMoney[0]=nums[0];
        sumMoney[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            sumMoney[i]=Math.max(sumMoney[i-2]+nums[i],sumMoney[i-1]);
        }
        int max=0;
        for (int i : sumMoney) {
            if(i>max){
                max=i;
            }
        }
        return max;
    }
}
