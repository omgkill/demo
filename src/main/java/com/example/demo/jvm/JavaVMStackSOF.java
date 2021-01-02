package com.example.demo.jvm;

public class JavaVMStackSOF {

    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    /**
     * java vm :-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -Xss128K
     * stack length:998
     * 抛异常
     *
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
