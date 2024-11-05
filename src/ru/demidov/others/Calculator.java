package ru.demidov.others;

public class Calculator {
    private final int x;
    private final int y;

    // Метод для возведения X в степень Y
    public Calculator(String xStr, String yStr) {
        this.x = Integer.parseInt(xStr); // Преобразование строки X в целое число
        this.y = Integer.parseInt(yStr); // Преобразование строки Y в целое число
    }

    public double calculatePower() {
        return Math.pow(getX(),getY()); // Возведение X в степень Y
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
