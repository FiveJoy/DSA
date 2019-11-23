package cn.fivejoy.dsa.now.chapter7;

/**
 * @description: 打印一个字符串的全部子序列，包括空字符串
 * e.g. abc
 * 则
 * abc
 * ab
 * ac
 * bc
 * a
 * b
 * c
 * ""
 * 都是子序列
 * 所以说到底对于一个字符来说，要么 要，要么 不要
 * @author: liulu
 * @create: 2019/11/23 16:10
 */
public class Nno3 {
    public void printAllSubstring(String s){
        process(s,0,"");

    }
    public void process(String s,int i,String pre){
        if(i==s.length()){
            System.out.println(pre);
            return;
        }
        // pre就是不关心之前状态的过程，但是关心之前状态的结果，属于 无后向性的问题

        process(s,i+1,pre+s.charAt(i));
        process(s,i+1,pre);
        //交换这两行的顺序就会发现不一样的地方~~神奇。
    }

    public static void main(String[] args) {
        Nno3 nno3=new Nno3();
        nno3.printAllSubstring("abc");
    }
}
