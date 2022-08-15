package ru.ilmira.lesson3.pingPong;

import static java.lang.Thread.sleep;

class WordChoice implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                printWord();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected synchronized void printWord() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        sleep(500);
        notify();
        wait();
    }
}
