package org.example;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Örnek oluşturulmasını sınırla
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Singleton işlemi başarıyla gerçekleştirildi.");
    }
}