package cn.fivejoy.dsa.leet;

import java.sql.SQLOutput;

/**
 * @description: https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @author: liulu
 * @create: 2019/11/09 14:15
 * 还可以用DP，不过我不会DP。。。  DP待做
 * 头痛，，不想做了。。。
 * ，是没有中午的感觉了还是累了。
 */
public class Solution5 {
    public static void main(String[] args) {
        String s = "babad";
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome(s));
    }


    public String longestPalindrome(String s) {
        boolean[][] result = new boolean[s.length()][s.length()];
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            result[i][i]=true;
            start=i;
            end=i;
        }
        for (int i = 1; i < s.length()-1; i++) {
            for (int j = i; j < s.length(); j++) {
                    result[i][j] = (result[i + 1][j - 1]) && (s.charAt(i) == s.charAt(j));
                //  P(i,j)=(P(i+1,j−1) and Si==Sj
                if(result[i][j]&&i>start&&j>end){
                    start=i;
                    end=j;
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        return s.substring(start,end);

    }

    String max = "";

    /**
     * 中心拓展法
     *
     * @param s
     * @return
     */
    public String Expand_longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i);
            expandAroundCenter(s, i, i + 1);
        }
        return max;

    }

    /**
     * 这个是参考了647的解法，官方也给出了题解4 叫做中心扩展法
     *
     * @param s
     * @param start
     * @param end
     */
    public void expandAroundCenter(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            String substring = s.substring(start, end + 1);
            //  System.out.println(substring);
            if (substring.length() > max.length()) {
                max = substring;
            }
            start--;
            end++;
        }
    }
}
