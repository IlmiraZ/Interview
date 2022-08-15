package ru.ilmira.lesson3.threadSafeCounter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    int count = 0;
    Lock lock = new ReentrantLock();

    void incCounter() {
        lock.lock();
        try {
            count++;
        } finally {
            System.out.println(Thread.currentThread().getName() + ":" + " Counter value: " + count);
            lock.unlock();
        }
    }
}