package com.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/userdb";
        String username = "root";
        String password = "Harish@1606";
        String query = "SELECT * FROM employee";
        String updateQuery = "insert into employee values(7,'BE','harish@gmail.com','9309430930','harish')";

        //forName will load the driver which internally also register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();

        //executeQuery for fetching the records from the table
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String employeeData = resultSet.getInt(1) + " : " + resultSet.getString(2) + " : " + resultSet.getString(3) + " : " + resultSet.getString(4) + " : " + resultSet.getString(5);
            System.out.println(employeeData);
        }

        //executeUpdate for updating the records in the table
        int count = statement.executeUpdate(updateQuery);

        System.out.println(count + " rows affected");

        statement.close();
        connection.close();
    }
}