package cn.fivejoy.dsa.others.search;

/**
 * @description:
 * @author: liulu
 * @create: 2019/11/11 16:41
 *
 *
 * 不一定对
 */
public class Search02 {
    public static void main(String[] args) {
        Search02 search01 = new Search02();
        int[] nums = {1, 2, 2, 5, 6, 7, 8, 9, 13, 15};
        System.out.println( search01.findFirstIndexofSortedArray(nums,2));
    }
    public int findFirstIndexofSortedArray(int[] nums,int key){
        int left=0;
        int right=nums.length-1;
       int result=-1;
        while(left<=right){
            int mid=left+(right-left)>>1;
            if(nums[mid]>=key){
                right=mid-1;
                if(nums[mid]==key){
                   result=mid;
                }
            }else {
                left=mid+1;
            }
        }
        return result;
    }

    int BinarySearch(int array[], int n, int value)
    {
        int left = 0;
        int right = n - 1;

        while (left <= right)
        {
            int middle = left + ((right - left) >> 1);
            if (array[middle] >= value)  //因为是找到最小的等值下标，所以等于号放在这里
                right = middle - 1;
            else
                left = middle + 1;
        }
        return array[right + 1] == value ? right + 1 : -1;
        // 当left<=right不满足的时候，一定是 要么left=mid+1了，要么是right=mid-1了。反正此时Midjius就是
    }
}
