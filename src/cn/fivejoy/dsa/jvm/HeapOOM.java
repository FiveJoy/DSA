package cn.fivejoy.dsa.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: liulu
 * @create: 2019/11/10 11:03
 */
public class HeapOOM {
    public static void main(String[] args) {
        List<OOMobject>  list=new ArrayList<>();
        while (true){
            list.add(new OOMobject());
        }
    }
    static  class OOMobject{

    }
}
