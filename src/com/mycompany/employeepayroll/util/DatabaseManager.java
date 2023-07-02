/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employeepayroll.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Arian
 */

public class DatabaseManager {
//    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XEPDB1";
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521/xepdb1";
//    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
//    private static final String DB_USER = "system";
//    private static final String DB_PASSWORD = "root";
    private static final String DB_USER = "HR";
    private static final String DB_PASSWORD = "hr";
//    private static final String JDBCDRIVER = "oracle.jdbc.driver.OracleDriver";

    private Connection connection;

    public DatabaseManager() {
	Statement stmt;
        try {
//	    Class.forName(JDBCDRIVER);
	    Class.forName("oracle.jdbc.driver.OracleDriver");  
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//		    stmt = connection.createStatement();
//		stmt.execute ("ALTER SESSION SET CURRENT_SCHEMA=human_resource");
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException cnfe){
		cnfe.printStackTrace();
	}
    }

    public Connection getConnection() {
        return connection;
    }
}
