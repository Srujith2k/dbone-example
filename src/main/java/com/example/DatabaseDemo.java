package com.example;

import com.acender.dbone.core.connection.DBConnection;
import com.acender.dbone.core.connection.DBConnectionFactory;
import com.acender.dbone.core.utils.QueryExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;
public class DatabaseDemo {
    public static void main(String[] args) {
        DBConnection connection = DBConnectionFactory.getConnection(
                "postgresql", "localhost", "5432", "testDB", "postgres", "root");
        try {
            // Establish the connection
            connection.connect();
            System.out.println("connected to Postgres");

            // Execute a query using QueryExecutor
            String query = "SELECT * FROM \"Employees\".\"Department\"\r\n"
                    + "ORDER BY \"Emp_id\" ASC ";
            ResultSet resultSet = QueryExecutor.executeQuery(connection, query);

            // Process results
            while(resultSet.next()) {
                System.out.println("Data: " + resultSet.getString("Emp_id") + " " + resultSet.getString("Emp_name")
                        + " " + resultSet.getString("Emp_dept"));
            }

            //Getting Cached result to the resultSet2
            String query2 = "SELECT * FROM \"Employees\".\"Department\"\r\n"
                    + "ORDER BY \"Emp_id\" ASC ";
            ResultSet resultSet2 = QueryExecutor.executeQuery(connection, query2);

            // Process results
            while(resultSet2.next()) {
                System.out.println("Data: " + resultSet.getString("Emp_id") + " " + resultSet.getString("Emp_name")
                        + " " + resultSet.getString("Emp_dept"));
            }

            resultSet.close();
            resultSet2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
    }
}
