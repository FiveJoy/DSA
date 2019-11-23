package cn.fivejoy.dsa.now.chapter7;

/**
 * @description: 求n!的结果
 * @author: liulu
 * @create: 2019/11/23 09:47
 */
public class Nno1 {

    /**
     * 满足递归的四大条件，使用递归
     *
     * @param n
     * @return
     */
    public int caculate(int n) {
        // basecase n=1,f(n)=1
        if (n == 1) {
            return 1;
        }
        return n * caculate(n - 1);
    }

    /**
     * 关心依赖状态
     * 从basecase往上看
     */
    public int caculate_dp(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * n;
        }
        return result;
    }

}
