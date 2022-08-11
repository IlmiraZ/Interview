package ru.ilmira.lesson_2;

import java.util.ArrayList;
import java.util.Comparator;

public class ArrayListTest {
    public static void main(String[] args) {

        ArrayList<String> days = new ArrayList<>();

        //Добавление элементов
        days.add("Вторник");
        days.add("Среда");
        days.add("Четверг");
        days.add("Суббота");
        days.add("Воскресенье");
        System.out.println("Содержимое: " + days);
        System.out.println("=======================================");

        //Добавление элемента в начало
        days.add(0, "Понедельник");
        System.out.println("Добавление в начало списка: " + days);
        System.out.println("=======================================");

        //Добавление элемента в середину
        days.add(4, "Пятница");
        System.out.println("Добавление в середину списка: " + days);
        System.out.println("=======================================");

        //Получение элемента по индексу
        System.out.println(days.get(3));
        System.out.println("=======================================");

        //Индекс определенного элемента
        System.out.println(days.indexOf("Суббота"));
        System.out.println("=======================================");

        //Заменить один элемент на другой
        days.set(0, "Выходной");
        System.out.println("Содержимое списка после редактирования: " + days);
        System.out.println("=======================================");

        //Удаление по индексу
        System.out.println(days.remove(1));
        System.out.println("=======================================");

        //Удаление элемента
        days.remove("Четверг");
        for (var day : days) {
            System.out.println(day);
        }
        System.out.println("=======================================");

        //Размер списка
        System.out.println(days.size());
        System.out.println("=======================================");

        //Сортировка
        days.sort(Comparator.naturalOrder());
        for (var day:days) {
            System.out.println(day + ", ");
        }
        System.out.println("=======================================");

        //Проверка на пустоту
        System.out.println(days.isEmpty());

        System.out.println("=======================================");

        //Метод clone()
        System.out.println("Первый ArrayList: " + days);
        var daysNew = (ArrayList<String>)days.clone();
        days.clear();
        System.out.println("Второй ArrayList: " + daysNew);
        System.out.println("=======================================");
    }
}


