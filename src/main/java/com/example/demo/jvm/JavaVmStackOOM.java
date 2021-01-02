package com.example.demo.jvm;

public class JavaVmStackOOM {

    private void dontStop() {
        while(true) {

        }
    }

    public void stackLeakByThread() {
        while(true) {
            Thread thread = new Thread(() -> {
                dontStop();
            });
            thread.start();
        }
    }
    public static void main(String[] args) {
        JavaVmStackOOM oom = new JavaVmStackOOM();
        oom.stackLeakByThread();
    }
}
