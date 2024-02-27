package com.company.db;

import com.company.db.interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDB implements IDB {
    private static PostgresDB instanceOfMe;
    private PostgresDB(){

    }

    public static PostgresDB getInstance(){
        if(instanceOfMe==null){
            instanceOfMe=new PostgresDB();
        }
        return instanceOfMe;
    }
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/dngdb";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "1379");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


}
