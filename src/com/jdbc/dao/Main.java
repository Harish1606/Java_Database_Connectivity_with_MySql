package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        Employee employee = main.getEmployee(5);
        System.out.println(employee);
    }

    private Employee getEmployee(int id) throws Exception {
        Employee employee = new Employee();
        employee.setId(id);

        String url = "jdbc:mysql://localhost:3306/userdb";
        String username = "root";
        String password = "Harish@1606";
        String query = "SELECT * FROM employee where id=" + id;

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();

        employee.setQualification(resultSet.getString(2));
        employee.setEmailId(resultSet.getString(3));
        employee.setMobileNo(resultSet.getString(4));
        employee.setName(resultSet.getString(5));

        return employee;
    }
}
