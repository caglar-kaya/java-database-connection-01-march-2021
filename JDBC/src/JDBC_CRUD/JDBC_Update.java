package JDBC_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Update {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		String url = "jdbc:mysql://localhost:3306/ebookshop";
		
		String username = "root";
		
		String password = "Ofis270.";
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to the Database.");
			
			statement = connection.createStatement();
			
			String sqlUpdate = "update books set price = price * 0.9 where id = 3 or id = 5;";
			System.out.println("The SQL statement is " + sqlUpdate);
			
			int rows = statement.executeUpdate(sqlUpdate);
			System.out.println("Number of rows : " + rows);
			
			String sqlQuery = "select * from books;";
			System.out.println("The SQL Query is " + sqlQuery);
			
			resultSet = statement.executeQuery(sqlQuery);
			
			while (resultSet.next()) {
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				double price = resultSet.getDouble("price");
				System.out.println(title + " - " + author + " - " + price);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
