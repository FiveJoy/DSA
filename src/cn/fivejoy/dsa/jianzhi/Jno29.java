package cn.fivejoy.dsa.jianzhi;

import java.util.Collections;

/**
 * @description: 数组中出现次数超过一半的数字
 * [1,2,3,2,2,2,2,5,3,4,2] 数字2
 * <p>
 * <p>
 * 中位数@！就是基于排序的！ 排好序以后中间位置的数，才是中位数！！——中位数就是长度为n的有序数组中第n/2的数！！！
 *
 *
 * 两个方法：
 * 1.基于partition和修改数组
 * 2.遍历统计，利用 出现次数超过一半
 *
 * @author: liulu
 * @create: 2019/11/10 17:45
 */
public class Jno29 {
    public static void main(String[] args) {
        Jno29 jno29=new Jno29();
        int[] nums=new int[]{1,2,3,2,2,2,2,5,3,4,2 };
        System.out.println(jno29.moreThanHalfNum_2(nums));

    }

    public int moreThanHalfNum_2(int[] nums){
        int times=1;
        int result=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==result){
                times++;
            }else{
                times--;
                if(times<=0){
                    times=0;
                    result=nums[i];
                }

            }
        }
        return result;
    }
    /**
     * 暴力：统计每一个数字出现的次数
     * 如果有范围。可以做个桶，时间复杂度O(n)：遍历O(n)放到桶里+O(n)判断桶哪个数最大 空间复杂度O(n)
     */
    /**
     * 如果出现次数超过一半，那排好序以后中位数肯定是这个数
     * 【中位数@！就是基于排序的！ 排好序以后中间位置的数，才是中位数！！——中位数就是长度为n的有序数组中第n/2的数！！！
     * 基于partition的O(n)算法
     * 快排：随机选择一个数字，调整数组中数字的顺序，使比其大的放右面，小的放左面
     * <p>
     * 如果随机选的这个数字index是mid/2 那说明它就是有序数组的第n/2的数了
     * 如果index>mid/2说明有序数组的第n/2的数在index右侧
     */
    public int moreThanHalfNum(int[] nums) {
        //参数检查略
        if (nums == null || nums.length == 0) {
            return 0;//>>>???
        }
        int mid = nums.length >> 1;
        int start = 0;
        int end = nums.length-1;
        int index = Partition(nums, start, end);
        while (index != mid) {
            if (index < mid) {
                start = index + 1;
                index = Partition(nums, start, end);
            } else {
                end = index - 1;
                index = Partition(nums, start, end);

            }
        }
        return nums[index];
    }

    /**
     * 挖坑填数
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static int Partition(int[] nums, int left, int right) {

        int i=left;
        int j=right;
        int temp=nums[left];
        while(i<j) {  //注意没有=
            while(i<j&&nums[j]>temp)
                j--;
            if(i<j);  //注意这里要继续判断，防止上一步while的j--使得j<=i
            nums[i]=nums[j];
            while(i<j&&nums[i]<=temp)
                i++;
            if(i<j)
                nums[j]=nums[i];
        }
        nums[i]=temp;
        return i;
    }

    /**
     * 哨兵法
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {

        int i = left;
        int j = right;
        int key = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= key) {
                j--;
            }
            while (i < j && nums[i] < key) {
                i++;
            }
            if (i < j)
                swap(nums, i, j);
        }

        nums[left] = nums[i];
        nums[i] = key;
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

