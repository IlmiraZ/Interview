package ru.ilmira.lesson_1.task3;

public class TestClass {
    public static void main(String[] args) {

        Circle circle = new Circle(5);
        System.out.println(circle.shapeArea());

        Square square = new Square(3);
        System.out.println(square.shapeArea());

        Triangle triangle = new Triangle(2, 3);
        System.out.println(triangle.shapeArea());

    }
}


