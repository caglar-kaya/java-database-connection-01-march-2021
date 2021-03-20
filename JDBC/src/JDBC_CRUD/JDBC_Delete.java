package JDBC_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Delete {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		String url = "jdbc:mysql://localhost:3306/ebookshop";
		
		String username = "root";
		
		String password = "Ofis270.";
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to the Database!");
			
			statement = connection.createStatement();
			
			String sqlDelete = "delete from books where id>= 2 and id < 4;";
			
			int countRows = statement.executeUpdate(sqlDelete);
			System.out.println("Number of Rows " + countRows);
			
			System.out.println();
			
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
