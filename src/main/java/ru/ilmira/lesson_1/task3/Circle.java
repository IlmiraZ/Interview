package ru.ilmira.lesson_1.task3;

public class Circle extends Shape {
    private double r;

    public Circle(double r) {
        this.r = r;
    }
    @Override
    public double shapeArea() {
        return Math.PI * Math.pow(r, 2);
    }
}
