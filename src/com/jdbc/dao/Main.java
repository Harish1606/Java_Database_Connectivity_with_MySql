package com.jdbc.dao;

import java.sql.*;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/userdb";
    private static final String username = "root";
    private static final String password = "Harish@1606";

    public static void main(String[] args) throws Exception {
        Main main = new Main();

        //Get the particular employee from the table
        Employee employee = main.getEmployee(5);
        System.out.println(employee);

        //Add the employee into the table
        Employee employee1 = new Employee(10, "BCom", "dinesh@gmail.com", "9340290374", "Dinesh");
        main.addEmployee(employee1);
    }

    private Employee getEmployee(int id) throws Exception {
        Employee employee = new Employee();
        employee.setId(id);

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

    private void addEmployee(Employee employee) throws Exception {
        String updateQuery = "insert into employee values(?,?,?,?,?)";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, username, password);

        PreparedStatement statement = connection.prepareStatement(updateQuery);
        statement.setInt(1,employee.getId());
        statement.setString(2,employee.getQualification());
        statement.setString(3,employee.getEmailId());
        statement.setString(4,employee.getMobileNo());
        statement.setString(5,employee.getName());

        int count = statement.executeUpdate();

        System.out.println(count + " rows affected");
    }
}
