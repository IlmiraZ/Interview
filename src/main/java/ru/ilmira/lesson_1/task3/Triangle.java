package ru.ilmira.lesson_1.task3;

public class Triangle extends Shape {
    private double a;
    private double b;

    public Triangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double shapeArea() {
        return 0.5 * a * b;
    }
}
