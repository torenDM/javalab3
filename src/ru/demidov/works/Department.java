package ru.demidov.works;

import java.util.ArrayList;
import java.util.List;

// Класс для представления отдела
public class Department {
    private final String name; // Имя отдела
    protected Employee head; // Начальник отдела (protected для доступа в Employee)
    private final List<Employee> employees; // Список сотрудников отдела

    // Конструктор для создания отдела с именем
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>(); // Инициализируем список сотрудников
    }

    // Метод для установки начальника отдела
    public void setHead(Employee employee) {
        if (employee.getDepartment() != this) {
            throw new IllegalArgumentException("Начальник отдела должен работать в этом отделе.");
        }
        this.head = employee;
    }

    // Метод для получения имени отдела
    public String getName() {
        return name;
    }

    // Метод для получения начальника отдела
    public Employee getHead() {
        return head;
    }

    // Метод для получения списка сотрудников отдела
    List<Employee> getEmployees() { // package-private доступ
        return employees;
    }

    // Метод для добавления сотрудника в список сотрудников отдела
    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) { // Проверяем, чтобы избежать дублирования
            employees.add(employee);
            employee.setDepartment(this); // Устанавливаем отдел для сотрудника
        }
    }
}