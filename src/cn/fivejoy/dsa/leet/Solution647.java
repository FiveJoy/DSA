package cn.fivejoy.dsa.leet;

/**
 * @description: https://leetcode-cn.com/problems/palindromic-substrings/
 * @author: liulu
 * @create: 2019/11/09 13:40
 */
public class Solution647 {
    public static void main(String[] args) {
        String s="abcba";
        Solution647 solution647=new Solution647();
        System.out.println(solution647.countSubstrings(s));
    }

    /**
     * 这种做法的思路和无重复子串其实有异曲同工
     * 之前是滑动窗口不断扩张。
     * 现在也是对当前回文的字符，不断向两侧扩张。
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int[] num=new int[1];
        for (int i=0; i < s.length(); i++){
            System.out.printf("=======\n");
            count(s, i, i,num);//回文串长度为奇数
            count(s, i, i+1,num);//回文串长度为偶数
        }
        return num[0];
    }

    public void count(String s, int start, int end,int[] num){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            System.out.printf("num[0]=%d,start=%d,end=%d,substring:%s\n",num[0],start,end,s.substring(start,end+1));
            num[0]++;
            start--;
            end++;

        }
    }

    /**
     * 暴力解法
     * for for 拿到所有子串，挨个判断是否回文
     * 时间复杂度O(n^2) 空间复杂度O(n)--stack
     *
     * @param s
     * @return
     */
    public int SLOW_countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (palindromic(s.substring(i, j + 1))) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 判断字符串是否回文
     * 1.用栈。
     * 2.分别从两侧开始对比
     *
     * @param s
     * @return
     */
    public boolean palindromic(String s) {
        for (int index = 0; index < s.length(); index++) {
            Character left = s.charAt(index);
            Character right = s.charAt(s.length() - index - 1);
            if (!left.equals(right)) {
                return false;
            }
        }
        return true;
    }
}

