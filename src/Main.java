import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/userdb";
        String username = "root";
        String password = "Harish@1606";
        String query = "select user_name from employee where id=5";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();

        String name = resultSet.getString("user_name");

        System.out.println(name);

        statement.close();
        connection.close();
    }
}