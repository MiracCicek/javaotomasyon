package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123456";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if (!usersTableExists(connection)) {
                createUsersTable(connection);
                kullaniciEkle(connection, "Ahmet", 25);
                kullaniciEkle(connection, "Ayşe", 30);
                kullaniciEkle(connection, "Mehmet", 20);
            } else {
                System.out.println("Users tablosu bulunuyor. Kullanıcıları listeliyor...");
                listUsers(connection);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean usersTableExists(Connection connection) throws SQLException {
        String checkTableExistsQuery = "SELECT EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'users')";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(checkTableExistsQuery);
        resultSet.next();
        boolean tableExists = resultSet.getBoolean(1);
        statement.close();
        return tableExists;
    }

    private static void createUsersTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE users (" +
                "id SERIAL PRIMARY KEY," +
                "ad VARCHAR(100)," +
                "yas INT" +
                ")";
        Statement statement = connection.createStatement();
        statement.execute(createTableSQL);
        statement.close();
    }

    private static void kullaniciEkle(Connection connection, String ad, int yas) throws SQLException {
        String insertUserSQL = "INSERT INTO users (ad, yas) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertUserSQL);
        preparedStatement.setString(1, ad);
        preparedStatement.setInt(2, yas);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private static void listUsers(Connection connection) throws SQLException {
        String listUsersSQL = "SELECT * FROM users";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(listUsersSQL);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String ad = resultSet.getString("ad");
            int yas = resultSet.getInt("yas");
            System.out.println("ID: " + id + ", Ad: " + ad + ", Yaş: " + yas);
        }
        resultSet.close();
        statement.close();
    }
}
