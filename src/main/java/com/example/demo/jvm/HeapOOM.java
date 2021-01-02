package com.example.demo.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {



    static class OOMObject {

    }

    /**
     * 实验  -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * 对象的数量 810000
     * 1. 数量到了160000， 第一次youngGC
     * 2.数量到了390000 , 第二次youngGc,紧接着就fullGC了
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true) {
            list.add(new OOMObject());
//            if (list.size() % 10000 == 0) {
//                System.out.println(list.size());
//            }
         }
    }
}
