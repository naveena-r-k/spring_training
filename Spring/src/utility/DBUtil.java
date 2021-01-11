package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	public static Connection getMysqlDbConnection() {
		String driverClassName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/java_training";
		String dbUserName="root";
		String dbPassword="12345";
		
		Connection con= null;
		
		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, dbUserName, dbPassword);
		}
		catch(Exception e) {
			System.out.println("Exception:"+e);
		}
		return con;
	}
}
