package org.example;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.Handle;
import java.util.Random;

public class Main  {

    private static final String URL = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11678198";
    private static final String USERNAME = "sql11678198";
    private static final String PASSWORD = "wVJ6TIBGWB";

    public static void main(String[] args) {
        try {
            Jdbi jdbi = Jdbi.create(URL, USERNAME, PASSWORD);
            Handle handle = jdbi.open();

            // Tablo oluşturma
            createTable(handle);

            // Rastgele bir kayıt ekleme
            String randomAdSoyad = getRandomAdSoyad();
            insertRecord(handle, randomAdSoyad);

            // Eklenen kaydı gösterme
            System.out.println("Eklenen kayıt: " + randomAdSoyad);

            // Eklenen kaydı silme
            deleteRecord(handle, randomAdSoyad);

            // Bağlantıyı kapatma
            handle.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Handle handle) {
        handle.execute("CREATE TABLE IF NOT EXISTS ad_soyad (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "ad_soyad VARCHAR(100)" +
                ")");
    }

    private static void insertRecord(Handle handle, String adSoyad) {
        handle.execute("INSERT INTO ad_soyad (ad_soyad) VALUES (?)", adSoyad);
    }

    private static void deleteRecord(Handle handle, String adSoyad) {
        handle.execute("DELETE FROM ad_soyad WHERE ad_soyad = ?", adSoyad);
    }

    private static String getRandomAdSoyad() {
        String[] adlar = {"Ahmet", "Ayşe", "Mehmet", "Fatma", "Mustafa", "Zeynep"};
        String[] soyadlar = {"Yılmaz", "Kaya", "Demir", "Şahin", "Çelik", "Doğan"};

        Random random = new Random();
        String ad = adlar[random.nextInt(adlar.length)];
        String soyad = soyadlar[random.nextInt(soyadlar.length)];

        return ad + " " + soyad;
    }
}
