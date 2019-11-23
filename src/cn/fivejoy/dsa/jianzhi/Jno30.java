package cn.fivejoy.dsa.jianzhi;

/**
 * @description: 获取数组中第K大的数maxKofNum
 *
 * https://fivejoy.github.io/2018/01/05/%E5%BF%AB%E6%8E%92-s-Partition-%E7%9B%B8%E5%85%B3%E9%97%AE%E9%A2%98/
 *
 * 原题是获取数组中最小的K个数。
 * 1.parition
 * 2.海量数据
 * @author: liulu
 * @create: 2019/11/10 20:24
 */
public class Jno30 {
    public static void main(String[] args) {
        Jno30 jno30=new Jno30();
        int[] nums=new int[]{1,2,3,2,2,2,2,5,3,4,2 };
        System.out.println(jno30.maxKofNum(nums,5));
    }
    public int maxKofNum(int[] nums,int k){
        int left=0;
        int right=nums.length-1;
        int index=Jno29.Partition(nums,left,right);
        while(index!=k){
            if(index>k){
                right=index-1;
                index=Jno29.Partition(nums,left,right);
            }else{
                left=index+1;
                index=Jno29.Partition(nums,left,right);
            }
        }
        return nums[index];
    }

    /**
     * 一个K 容量的容器
     * 不断读入数，
     * 如果容器未满，直接塞入
     * 如果满了，找容器中最大的那个，删掉，插入新元素
     *
     * 找到最大的数 O(1)
     * 删掉最大的数 O(logk)
     * 插入一个新的数 O(logk)
     * ——————容器：最大堆 每种操作都是
     */

    /**
     * 最大堆
     * 红黑树
     */

}
