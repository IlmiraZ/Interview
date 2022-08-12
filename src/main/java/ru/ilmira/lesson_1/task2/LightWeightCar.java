package ru.ilmira.lesson_1.task2;

public class LightWeightCar extends Car implements Moveable, Openable { // изначально не был реализован интерфейс Openable. (исправлено)


    @Override
    public void open() {
        System.out.println("Car is open");
    }

    // расширение видимости метода родительского класса
    @Override
    public void start() {
        super.start();
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}
