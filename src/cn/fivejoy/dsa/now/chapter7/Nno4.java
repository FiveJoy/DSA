package cn.fivejoy.dsa.now.chapter7;

/**
 * @description: 打印一个字符串的全部排列
 * 全排列指的是
 * e.g. ABC
 * 则全排列为
 * ABC
 * ACB
 * BAC
 * BCA
 * CAB
 * CBA
 * E.G. ACC
 * ACC
 * ACC
 * CAC
 * CAC。。。。可能要求打印无重复的全排列
 * 想要不重复，每次For循环保证swap到开头的字符没有重复就可以了，如果set里面已经有了就continue被
 * @author: liulu
 * @create: 2019/11/23 16:23
 */
public class Nno4 {
    public void printString(String s) {
        process(s.toCharArray(), 0);


    }

    public void process(char[] chars, int index) {
        if(index==chars.length){
            System.out.println(chars);
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            process(chars, index + 1);
        }

        //对于任何一个字符，=这个字符和剩余所有字符的全排列》》》
        //要还是不要 解决不了，是顺序问题
        // 举例子ABCD 一个0-N-1长度的字符串，对于i问题，现在0-i-1位置已经形成一个解 从i-n-1所有位置的字符都可以作为i位置的字符，后面剩下的字符自由变换// 最开始的想法没有错
        // 巧妙在于通过swap把已经提溜出来的放到开头。 这样就没有必要非得再搞出来没处理的字符串了、
    }

    private void swap(char[] chars, int i, int index) {
        char t = chars[i];
        chars[i] = chars[index];
        chars[index] = t;
    }

    public static void main(String[] args) {
        String s="ABC";
        Nno4 nno4=new Nno4();
        nno4.printString(s);
    }
}
