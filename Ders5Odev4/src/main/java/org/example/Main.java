package org.example;

import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}

class HRDepartment {
    private List<Employee> employees;

    public HRDepartment() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

public class Main {
    public static void main(String[] args) {
        HRDepartment hrDepartment = new HRDepartment();

        // Personel ekleme
        hrDepartment.addEmployee(new Employee("Ahmet", "Muhasebe"));
        hrDepartment.addEmployee(new Employee("Ayşe", "İnsan Kaynakları"));
        hrDepartment.addEmployee(new Employee("Mehmet", "Yönetici Asistanı"));

        // Personel listesini alma ve yazdırma
        List<Employee> employees = hrDepartment.getEmployees();
        for (Employee employee : employees) {
            System.out.println("İsim: " + employee.getName() + ", Pozisyon: " + employee.getPosition());
        }
    }
}
