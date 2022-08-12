package ru.ilmira.lesson_1.task3;

public class Shape {
    public void shapeArea() {
        System.out.println("Площади фигур: ");
    }

    public void shapeArea(int r) {
        System.out.println("Площадь круга = " + 3.14 * r * r);
    }

    public void shapeArea(int a, int b) {
        System.out.println("Площадь квадрата = " + a * b);
    }

    public void shapeArea(double c, double d) {
        System.out.println("Площадь треугольника = " + 0.5 * c * d);
    }
}
