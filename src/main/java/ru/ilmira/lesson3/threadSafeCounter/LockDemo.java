package ru.ilmira.lesson3.threadSafeCounter;

public class LockDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread[] t = new Thread[3];

        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new CounterDemo(counter), "Thread " + i);
        }
        for (Thread thread : t) {
            thread.start();
        }
    }
}