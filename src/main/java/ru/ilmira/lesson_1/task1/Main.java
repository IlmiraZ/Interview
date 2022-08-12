package ru.ilmira.lesson_1.task1;

public class Main {
    public static void main(String[] args) {
        Person person = Person.newBuilder()
                .setFirstName("Петров")
                .setLastName("Иван")
                .setMiddleName("Иванович")
                .setCountry("Россия")
                .setAddress("Москва, Валовая улица")
                .setPhone("89990001112233")
                .setAge(33)
                .setGender("М")
                .build();

        System.out.println(person);
    }
}





