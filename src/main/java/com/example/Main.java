package com.example;

import com.acender.dbone.core.connection.AbstractDBConnection;
import com.acender.dbone.core.connection.DBConnection;
import com.acender.dbone.core.connection.DBConnectionFactory;


import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException{
        DBConnection connection = DBConnectionFactory.getConnection(
                "postgresql", "localhost", "5432", "testDB", "postgres", "root");

        connection.connect();
        System.out.println("Database connected successfully!");
        connection.disconnect();
    }
}
