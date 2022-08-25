package ru.ilmira.lesson_1.task3;

public class Square extends Shape {

    private double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public double shapeArea() {
        return Math.pow(a, 2);
    }
}
