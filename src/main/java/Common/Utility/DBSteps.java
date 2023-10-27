package Common.Utility;

import Common.Data.SQLConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBSteps {
    Connection connection= SQLConn.getConnection();

    public DBSteps insertAcc(String userName,String password) throws SQLException {
        String insertSql = "INSERT INTO redditAccs (userName, password) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            // Execute the INSERT statement
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Insert operation failed.");
            }
        }

        return this;
    }
}
