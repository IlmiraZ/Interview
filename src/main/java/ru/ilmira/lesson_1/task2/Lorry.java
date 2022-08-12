package ru.ilmira.lesson_1.task2;

 class Lorry extends Car implements Moveable, Stopable, Openable{  // класс Lorry наследуется от абстрактного класса Car и реализует интерфейсы Moveable, Stopable
                                               // изначально не указано слово implements и добавлен интрефейс Openable. (исправлено)

     @Override
     public void move(){  // не указана аннотация @Override,
                          // при изменении интерфейса компилятор сообщит об ошибке. (исправлено)
        System.out.println("Car is moving");
    }

    @Override
    public void stop(){  // не указана аннотация @Override,
                         // при изменении интерфейса компилятор сообщит об ошибке. (исправлено)
        System.out.println("Car is stop");
    }

     @Override
     public void open() { // Не был реализован метод open() класса Car.
                          // Метод open() вынесен отдельно в интерфейс Openable

     }

     @Override  // изначально не был реализован. Расширение видимости метода public  родительского класса.
     public void start() {
         super.start();
     }
 }
