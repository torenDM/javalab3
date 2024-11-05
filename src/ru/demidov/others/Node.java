package ru.demidov.others;

import java.util.ArrayList;
import java.util.List;

// Класс для представления узла бинарного дерева
public class Node {
    private Integer value; // Значение узла
    private Node parent; // Родитель
    private Node leftChild; // Левый потомок
    private Node rightChild; // Правый потомок

    // Конструктор без аргументов
    public Node() {
        this.value = null; // Изначально значение не задано
        this.parent = null; // Изначально родитель отсутствует
        this.leftChild = null; // Изначально левый потомок отсутствует
        this.rightChild = null; // Изначально правый потомок отсутствует
    }

    // Метод для добавления значения
    public void addValue(int newValue) {
        if (value == null) { // Если значение не задано
            value = newValue; // Устанавливаем новое значение
        } else if (newValue > value) { // Если новое значение больше текущего
            if (rightChild == null) { // Если правого потомка нет, создаем его
                rightChild = new Node();
                rightChild.parent = this; // Устанавливаем родителя
            }
            rightChild.addValue(newValue); // Рекурсивно добавляем в правый потомок
        } else { // Если новое значение меньше или равно текущему
            if (leftChild == null) { // Если левого потомка нет, создаем его
                leftChild = new Node();
                leftChild.parent = this; // Устанавливаем родителя
            }
            leftChild.addValue(newValue); // Рекурсивно добавляем в левый потомок
        }
    }

    // Метод для удаления значения
    public boolean removeValue(int valueToRemove) {
        if (value == null) {
            return false; // Значение не найдено
        }

        if (value.equals(valueToRemove)) {
            // Удаляем узел, но оставляем потомков прикрепленными
            if (leftChild != null) {
                leftChild.parent = null; // Отсоединяем левого потомка от родителя
            }
            if (rightChild != null) {
                rightChild.parent = null; // Отсоединяем правого потомка от родителя
            }
            this.value = null; // Удаляем значение узла
            return true;
        } else if (valueToRemove > value) {
            return rightChild != null && rightChild.removeValue(valueToRemove); // Рекурсивно ищем в правом поддереве
        } else {
            return leftChild != null && leftChild.removeValue(valueToRemove); // Рекурсивно ищем в левом поддереве
        }
    }

    // Метод для проверки существования значения
    public boolean containsValue(int valueToCheck) {
        if (value == null) {
            return false; // Значение не найдено
        }

        if (value.equals(valueToCheck)) {
            return true; // Значение найдено
        } else if (valueToCheck > value) {
            return rightChild != null && rightChild.containsValue(valueToCheck); // Рекурсивно ищем в правом поддереве
        } else {
            return leftChild != null && leftChild.containsValue(valueToCheck); // Рекурсивно ищем в левом поддереве
        }
    }

    // Метод для получения строкового представления узла и его потомков (левосторонний обход)
    public String toStringInOrder() {
        List<Integer> values = new ArrayList<>();
        if (leftChild != null) {
            values.addAll(leftChild.toStringInOrderList());
        }
        if (value != null) {
            values.add(value);
        }
        if (rightChild != null) {
            values.addAll(rightChild.toStringInOrderList());
        }
        return values.toString();
    }

    // Вспомогательный метод для получения списка значений в порядке обхода
    private List<Integer> toStringInOrderList() {         List<Integer> values = new ArrayList<>();
        if (leftChild != null) {
            values.addAll(leftChild.toStringInOrderList());
        }
        if (value != null) {
            values.add(value);
        }
        if (rightChild != null) {
            values.addAll(rightChild.toStringInOrderList());
        }
        return values;
    }
}
