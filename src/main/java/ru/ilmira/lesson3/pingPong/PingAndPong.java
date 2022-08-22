package ru.ilmira.lesson3.pingPong;


public class PingAndPong {
    WordChoice word = new WordChoice();

    protected void start() {
        Thread firstThread = new Thread(word, "ping");
        firstThread.start();
        Thread secondThread = new Thread(word, "pong");
        secondThread.start();
    }
}
