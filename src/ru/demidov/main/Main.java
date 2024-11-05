package ru.demidov.main;

import ru.demidov.birds.*;
import ru.demidov.points.*;
import ru.demidov.works.*;
import ru.demidov.others.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Задача 1.2: Время от начала суток
        System.out.println("\nЗадача 1.2: Время от начала суток");
        System.out.println("Часы для времени 34056: " + new Time(34056).getHours());
        System.out.println("Минуты для времени 4532: " + new Time(4532).getMinutes());
        System.out.println("Секунды для времени 123: " + new Time(123).getSeconds());
        Time time1 = new Time(10000);
        System.out.println("Время для time1: " + time1);
        Time time2 = new Time(20, 4, 5);
        System.out.println("Время для time2: " + time2);

        // Задача 1.11: Начальник отдела
        System.out.println("\nЗадача 1.11: Начальник отдела");

        Department itDepartment = new Department("IT");
        Employee petrov = new Employee("Петров");
        Employee sidorov = new Employee("Сидоров");
        Employee kozlov = new Employee("Козлов");

        petrov.setDepartment(itDepartment);
        sidorov.setDepartment(itDepartment);
        kozlov.setDepartment(itDepartment); // Если не установить Козлова сотрудником, то программа не даст сделать его начальником

        itDepartment.setHead(kozlov);

            // В примере ниже, если попробовать установить Козлова сотрудником другого отдела, то программа также выдаст ошибку
            // Department TestDepartment = new Department("Test");
            // kozlov.setDepartment(TestDepartment);


        System.out.println(petrov);
        System.out.println(sidorov);
        System.out.println(kozlov);

        // Задача 2.4: Бинарное дерево
        Node rootNode = new Node(); // Создаем корневой узел
        int[] valuesToAdd = {3, 5, 4, 7, 1, 2}; // Числа для добавления в дерево

        for (int value : valuesToAdd) {
            rootNode.addValue(value); // Добавляем значения в дерево
        }

        System.out.println("\nЗадача 2.4: Бинарное дерево");
        System.out.print("Строковое представление узла: ");
        System.out.println(rootNode.toStringInOrder()); // Выводим строковое представление дерева

        // Задача 3.5: Трехмерная точка
        Point3D point1 = new Point3D(1.0, 2.0, 3.0);
        Point3D point2 = new Point3D(4.5, 5.5, 6.5);
        Point3D point3 = new Point3D(-1.0, -2.0, -3.0);

        System.out.println("\nЗадача 3.5: Трехмерная точка");
        System.out.println("Точка 1: " + point1);
        System.out.println("Точка 2: " + point2);
        System.out.println("Точка 3: " + point3);

        // Задача 4.3: Птицы
        Bird sparrow = new Sparrow();
        Bird cuckoo = new Cuckoo();
        Bird parrot = new Parrot("Привет, я попугай!");

        System.out.println("\nЗадача 4.3: Птицы");
        System.out.print("Воробей поет: ");
        sparrow.sing();

        System.out.print("Кукушка поет: ");
        cuckoo.sing();

        System.out.print("Попугай поет: ");
        parrot.sing();

        // Задача 5.2: Птичий рынок
        List<Bird> birds = new ArrayList<>();
        birds.add(new Sparrow());
        birds.add(new Sparrow());
        birds.add(new Cuckoo());
        birds.add(new Cuckoo());
        birds.add(new Parrot("Привет, я попугай номер один!"));
        birds.add(new Parrot("Привет, я попугай номер два!"));

        System.out.println("\nЗадача 5.2: Птичий рынок");
        MainBirds.makeBirdsSing(birds);

        // Задача 6.2: Сравнение точек
        Point2D point4 = new Point2D(1.0, 2.0);
        Point2D point5 = new Point2D(1.0, 2.0);
        Point2D point6 = new Point2D(2.0, 3.0);
        System.out.println("\nЗадача 6.2: Сравнение точек");
        System.out.println("Сравнение точек " + point4 + " и " + point5 + ": " + point4.equals(point5));
        System.out.println("Сравнение точек " + point5 + " и " + point6 + ": " + point5.equals(point6));
        System.out.println("Сравнение точек " + point6 + " и " + null + ": " + point6.equals(null));

        // Задача 7.1:
        /*
            Созданы пакеты:
             1. ru.demidov с классом Main
             2. ru.demidov.birds с классами Bird, Cuckoo, Parrot, Sparrow, MainBirds
             3. ru.demidov.points с классами Point2D, Point3D
             4. ru.demidov.works с классами Department, Employee
             5. ru.demodiv.others с классами Node, Time
            Работоспособность приложения проверена.
        */

        // Задача 7.2:
        /*
             1. Создан пакет ru.demidov.main, в который был перемещен класс Main
             2. Класс MainBirds, созданный в рамках задачи 5.2, перемещен в указанный пакет
             3. Проведена проверка, что ни в одном другом пакете нет классов, имеющих точку входа в исполнении программы
            Работоспособность приложения проверена.
        */

        // Задача 7.3: Возведение в степень
        System.out.println("\nЗадача 7.3: Возведение в степень");

        // Для передачи аргументов используется командная строка (ALT+SHIFT+F10 -> Main -> Edit -> Program Arguments)
        if (args.length < 2) {
            System.out.println("Ошибка: При запуске не были переданы два числа.");
            return;
        }
        String xStr = args[0]; // Первое число из аргументов командной строки
        String yStr = args[1]; // Второе число из аргументов командной строки
        System.out.println("В программу были переданы числа: " + args[0] + " " + args[1]);
        try {
            Calculator degree = new Calculator(xStr,yStr);
            System.out.println("Возведение числа " + args[0] + " в " + args[1] + " степень: " + degree.calculatePower()); // Вывод результата
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: убедитесь, что оба аргумента являются целыми числами.");
        }

        // Задача 8.1:
        /*
             1. Поле head в классе Department сделано protected, чтобы его можно было использовать в классе Employee
             2. Методы getEmployees() и setDepartment() теперь имеют package-private доступ (без явного модификатора), что
             позволяет им взаимодействовать друг с другом внутри одного пакета, но скрывает их от внешнего использования
             3. Убедились, что методы, которые должны оставаться публичными, такими и остаются
            Работоспособность приложения проверена.
        */
    }
}