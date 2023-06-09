package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.jdbc.Driver;

public class JDBCUtil {
	public static Connection getConnection() {
		
		Connection c = null;
		
		try {
			DriverManager.registerDriver(new Driver());
			
			String url ="jdbc:mySQL://localhost:3306/myweb";
			String username="root";
			String password="";
			
			c= DriverManager.getConnection(url,username,password);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return c;
		
	}  
	
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printInfo(Connection c) {
		try {
			if(c!=null) {
				DatabaseMetaData mtdt = (DatabaseMetaData) c.getMetaData();
				
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
