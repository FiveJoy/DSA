package cn.fivejoy.dsa.others.search;

/**
 * @description:
 * 二分查找的时间复杂度
 * 考虑的是
 *总共有n个元素
 * 每次要查找的区间为 n/2, n/4 , 第K次循环 n/(2^k)找到key时，区间大小为1
 * 所以1=n/(2^k)
 * 所以k=logn
 * 时间复杂度O(logn)
 * @author: liulu
 * @create: 2019/11/11 16:15
 */
public class Search01 {
    public static void main(String[] args) {
        Search01 search01 = new Search01();
        int[] nums = {1, 2, 4, 5, 6, 7, 8, 9, 13, 15};
        System.out.println( search01.binarySearch(nums,5,0,nums.length-1));
    }

    public int binarySearch(int[] nums, int key, int left, int right) {
        if (left >= right) {
            return -1;
        }

        while (left<=right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > key) {
               right=mid-1;
            }else if(nums[mid]==key){
                return mid;
            }else {
               left=mid+1;
            }

        }
        return -1;
    }
}
