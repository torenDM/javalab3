package ru.demidov.works;

import java.util.ArrayList;
import java.util.List;

// Класс для представления сотрудника
public class Employee {
    private final String name; // Имя сотрудника
    private Department department; // Отдел, к которому принадлежит сотрудник

    // Конструктор для создания сотрудника с именем
    public Employee(String name) {
        this.name = name;
    }

    // Метод для установки отдела для сотрудника
    public void setDepartment(Department department) {
        if (this.department != null && this.department != department) {
            throw new IllegalArgumentException("Сотрудник уже принадлежит другому отделу.");
        }
        this.department = department;
        department.addEmployee(this); // Добавляем сотрудника в отдел
    }

    // Метод для получения имени сотрудника
    public String getName() {
        return name;
    }

    // Метод для получения отдела, к которому принадлежит сотрудник
    public Department getDepartment() {
        return department;
    }

    // Метод для получения списка коллег в одном отделе
    public List<Employee> getColleagues() {
        return department != null ? department.getEmployees() : new ArrayList<>();
    }

    @Override
    public String toString() { // Форматируем строку представления сотрудника
        if (department != null && department.head == this) { // Используем protected доступ к head
            return name + " - начальник отдела " + department.getName();
        } else if (department != null) {
            return name + " работает в отделе " + department.getName() +
                    ", начальник которого " + department.getHead().getName();
        } else {
            return name + " не принадлежит ни одному отделу.";
        }
    }
}