package ru.demidov.birds;

import java.util.Random;

// Класс Попугай
public class Parrot extends Bird {
    private final String text;

    // Конструктор с обязательным параметром текста
    public Parrot(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Текст не может быть пустым.");
        }
        this.text = text;
    }

    @Override
    public void sing() {
        Random random = new Random();
        int n = random.nextInt(text.length()) + 1; // Случайное число от 1 до длины текста
        System.out.println(text.substring(0, n));
    }
}
