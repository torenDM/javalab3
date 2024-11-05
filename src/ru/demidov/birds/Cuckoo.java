package ru.demidov.birds;

import java.util.Random;

// Класс Кукушка
public class Cuckoo extends Bird {
    private static final Random random = new Random();

    @Override
    public void sing() {
        int times = random.nextInt(10) + 1; // Случайное число от 1 до 10
        for (int i = 0; i < times; i++) {
            System.out.print("ку-ку ");
        }
        System.out.println(); // Для новой строки после пения
    }
}
