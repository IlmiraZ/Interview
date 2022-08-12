package ru.ilmira.lesson_1.task2;

abstract class Car {
    private Engine engine;   // Изначально класс Engine был не реализован. (исправлено)
                             //нарушен принцип инкапсуляции, было public, сделать поле private или protected. (исправлено)
    private String color;
    private String name;

    protected void start() {   // ограничение области видимости protected. Нужно сделать метод start() публичным,
                               // или создать публичный метод у наследников использующий родительский метод start(). (исправлено)

        System.out.println("Car starting");
    }
//    abstract void open();  // Необходимо создать отдельный интерфейс Openable с методом open(). (исправлено)


    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;

    }
}
