package cn.fivejoy.dsa.now.chapter7;

/**
 * @description: 母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只 母牛，假设不会死。求N年后，母牛的数量
 * f(n)=f(n-1)+f(n-3)
 * 第一年 只有母牛A  -1
 * 第二年 AB  -2
 * 3 ABC  -3
 * 4 ABCD -4
 * 5 ABCDE F  -6
 * 6 ABCDEH FI J  --9
 *
 *
 * f(n-1)表示 去年的全部牛 都能留到今年
 * f(n-3)= 当时还未成熟的牛（如今都能生了）+ 当时能生的（如今还能生），所以是f(n-3)
 * 所以还是分析，当前解和前一个状态的关系
 *
 *
 * 那如果说牛只能活十年呢
 * 则f(n)=f(n-1)+f(n-3)-f(n-10)
 * @author: liulu
 * @create: 2019/11/23 16:51
 */
public class Nno5 {
}
