package ru.ilmira.lesson3.threadSafeCounter;

class CounterDemo implements Runnable {
   private final Counter counter;

    public CounterDemo(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName());
        counter.incCounter();
    }
}
