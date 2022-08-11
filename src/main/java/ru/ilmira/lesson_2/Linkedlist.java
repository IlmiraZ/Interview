package ru.ilmira.lesson_2;

import java.util.LinkedList;
import java.util.ListIterator;

public class Linkedlist {
    public static void main(String[] args) {

        LinkedList<String> ListOfSongsByTheKino = new LinkedList<>();
        // Добавление элементов
        ListOfSongsByTheKino.add("Кукушка");
        ListOfSongsByTheKino.add("Группа крови");
        ListOfSongsByTheKino.add("Пачка сигарет");
        ListOfSongsByTheKino.add("Звезда по имени Солнце");
        System.out.println("Содержимое списка: " + ListOfSongsByTheKino);
        System.out.println("=======================================");

        // Добавляем первый и последний элементы
        ListOfSongsByTheKino.addFirst("Муравейник");
        ListOfSongsByTheKino.addLast("Алюминевые огурцы");
        System.out.println("Содержимое списка после добавления: " + ListOfSongsByTheKino);
        System.out.println("=======================================");

        // Добавляем элементы по индексу
        ListOfSongsByTheKino.add(2, "Малыш");
        ListOfSongsByTheKino.add(3, "Перемен");
        System.out.println("Обновленное содержимое списка: " + ListOfSongsByTheKino);
        System.out.println("=======================================");


        // Получаем элементы
        Object firstItem = ListOfSongsByTheKino.get(0);
        System.out.println("Первый элемент: " + firstItem);
        ListOfSongsByTheKino.set(0, "Последний герой");
        System.out.println("Содержимое спика после обновления первого элемента: " + ListOfSongsByTheKino);
        System.out.println("=======================================");

        // Удаляем элементы по индексу
        ListOfSongsByTheKino.remove(1);
        ListOfSongsByTheKino.remove(2);
        System.out.println("Список после удаления элемента по индексу: " + ListOfSongsByTheKino);
        System.out.println("=======================================");

        //Удаляем первый и последний элементы
        ListOfSongsByTheKino.removeFirst();
        ListOfSongsByTheKino.removeLast();
        System.out.println("Список после удаления первого и последнего элемента: " + ListOfSongsByTheKino);
        System.out.println("=======================================");

        // Иттерация
        ListIterator<String> iterator = ListOfSongsByTheKino.listIterator();
        System.out.println("Cписок: ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }
    }
}