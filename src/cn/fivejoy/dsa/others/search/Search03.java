package cn.fivejoy.dsa.others.search;

/**
 * @description: 给定一个有序的数组，查找最接近value且大于value的数的下标（如果该数存在多个，返回第一个下标），不存在返回-1
 * @author: liulu
 * @create: 2019/11/11 17:22
 *
 * 不一定对...
 */
public class Search03 {
    public int findIndex(int[] nums,int key){
        int left=0;
        int right=nums.length-1;
        int result=-1;

        while (left<=right) {
            int mid=left+(right-left)>>1;
            if(nums[mid]==key){
                left=mid+1;
            }else if(nums[mid]<key){
                left=mid+1;
            }else {
                result=mid;
                right=mid-1;
            }

        }
        return result;

    }
}
