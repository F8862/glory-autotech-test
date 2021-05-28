package test;
import java.sql.*;
public class DBConnection {
	private static Connection con;

	private DBConnection(){}
	static{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		}catch(Exception e){e.printStackTrace();}
	}
	public static  Connection getcon()
	{
		return con;
	}

}
