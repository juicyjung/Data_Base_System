package myDB;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String userInfo = null, passwdInfo = null;
		
		try {
			FileReader reader = new FileReader("dbInfo.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            userInfo = bufferedReader.readLine();
            passwdInfo = bufferedReader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/mydb";
			String user = userInfo, passwd = passwdInfo;
			con = DriverManager.getConnection(url, user, passwd);
			System.out.println(con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// database operations ...
		
		try {
			if (con != null && !con.isClosed()) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
