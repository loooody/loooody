package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_connect {
	private Connection con = null;
	Statement statement = null;
	private String driver_name = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/sign_in?serverTimezone=UTC ";
	
	public Statement DB_connect() throws ClassNotFoundException, SQLException {
		//加载驱动
		Class.forName(driver_name);
		
		//连接数据库
		con = DriverManager.getConnection(url, "root" , "loooody");
		
		System.out.println(con);
	
	    statement = con.createStatement();
		return statement;
	}
}
