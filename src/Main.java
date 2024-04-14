import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/userdb";
        String username = "root";
        String password = "Harish@1606";
        String query = "SELECT * FROM employee;";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String employeeData = resultSet.getInt(1) + " : " + resultSet.getString(2) + " : " + resultSet.getString(3) + " : " + resultSet.getString(4) + " : " + resultSet.getString(5);
            System.out.println(employeeData);
        }

        statement.close();
        connection.close();
    }
}