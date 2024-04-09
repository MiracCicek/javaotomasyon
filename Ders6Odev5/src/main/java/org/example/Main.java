package org.example;

import java.util.Scanner;

class Employee {
    private String name;
    private String position;
    private int dailyWage;

    public Employee(String name, String position, int dailyWage) {
        this.name = name;
        this.position = position;
        this.dailyWage = dailyWage;
    }

    public int calculateSalary(int workedDays) {
        int salary = workedDays * dailyWage;
        if (workedDays > 25) {
            int extraDays = workedDays - 25;
            salary += extraDays * 1000; // 1000 TL ekstra prim
        }
        return salary;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Çalışanın adını girin: ");
        String name = scanner.nextLine();

        System.out.print("Çalışanın pozisyonunu girin: ");
        String position = scanner.nextLine();

        System.out.print("Günlük ücreti girin: ");
        int dailyWage = scanner.nextInt();

        System.out.print("Çalışılan gün sayısını girin: ");
        int workedDays = scanner.nextInt();

        Employee employee = new Employee(name, position, dailyWage);
        int salary = employee.calculateSalary(workedDays);

        System.out.println("Maaş: " + salary + " TL");
    }
}