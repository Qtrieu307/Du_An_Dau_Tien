package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {


	    public static Connection getConnection() {
	        Connection connection = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/cuoiky1", "root", "Phamnhuquocbin37@");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return connection;
	    }

	   
	    
	}
   

