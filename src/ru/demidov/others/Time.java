package ru.demidov.others;

public class Time {
    private final int seconds;

    // Конструктор для инициализации времени по количеству секунд с начала суток
    public Time(int seconds) {
        if (seconds < 0 || seconds >= 86400) {
            throw new IllegalArgumentException("Количество секунд должно быть в диапазоне от 0 до 86399.");
        }
        this.seconds = seconds;
    }

    // Конструктор для инициализации времени по часам, минутам и секундам
    public Time(int hours, int minutes, int seconds) {
        if (hours < 0 || hours >= 24) {
            throw new IllegalArgumentException("Количество часов должно быть в диапазоне от 0 до 23.");
        }
        if (minutes < 0 || minutes >= 60) {
            throw new IllegalArgumentException("Количество минут должно быть в диапазоне от 0 до 59.");
        }
        if (seconds < 0 || seconds >= 60) {
            throw new IllegalArgumentException("Количество секунд должно быть в диапазоне от 0 до 59.");
        }
        this.seconds = (hours * 3600 + minutes * 60 + seconds);
    }

    // Метод для получения текстового представления времени
    public String toString() {
        int hours = (seconds / 3600) % 24;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        return String.format("%d:%02d:%02d", hours, minutes, secs);
    }

    // Метод для получения текущего часа
    public int getHours() {
        return (seconds / 3600) % 24;
    }

    // Метод для получения минут, прошедших с начала текущего часа
    public int getMinutes() {
        return (seconds % 3600) / 60;
    }

    // Метод для получения секунд, прошедших с начала текущей минуты
    public int getSeconds() {
        return seconds % 60;
    }
}