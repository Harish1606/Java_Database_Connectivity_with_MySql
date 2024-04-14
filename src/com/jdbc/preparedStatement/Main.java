package com.jdbc.preparedStatement;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/userdb";
        String username = "root";
        String password = "Harish@1606";
        String updateQuery = "insert into employee values(?,?,?,?,?)";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the employee id : ");
        int employeeId = scanner.nextInt();

        System.out.println("Enter the employee qualification : ");
        String employeeQualification = scanner.next();

        System.out.println("Enter the employee email : ");
        String employeeEmail = scanner.next();

        System.out.println("Enter the employee number : ");
        String employeeNumber = scanner.next();

        System.out.println("Enter the employee name : ");
        String employeeName = scanner.next();

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, username, password);

        PreparedStatement statement = connection.prepareStatement(updateQuery);

        statement.setInt(1, employeeId);
        statement.setString(2, employeeQualification);
        statement.setString(3, employeeEmail);
        statement.setString(4, employeeNumber);
        statement.setString(5, employeeName);

        int count = statement.executeUpdate();

        System.out.println(count + " rows affected");

        statement.close();
        connection.close();
    }
}