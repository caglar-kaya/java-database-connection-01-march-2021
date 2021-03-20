package JDBC_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Insert {

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
			
			String sqlInsert = "insert into books values (7, 'Python for Data Scince', 'Yves Hilpsich', 59.99, 60);";
			
			// int rows = statement.executeUpdate(sqlInsert);
			// System.out.println("Total rows inserted : " + rows);
			
			String sqlQuery = "select * from books;";
			System.out.println("The SQL Query is " + sqlQuery);
			
			resultSet = statement.executeQuery(sqlQuery);
			
			while (resultSet.next()) {
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				double price = resultSet.getDouble("price");
				System.out.println(title + " - " + author + " - " + price);
			}
			
			sqlQuery = "select * from books where id = 3";
			resultSet = statement.executeQuery(sqlQuery);
			System.out.println();
			
			while (resultSet.next()) {
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				double price = resultSet.getDouble("price");
				int quantity = resultSet.getInt("qty");
				System.out.println(title + " - " + author + " - " + price + " - " + quantity);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
