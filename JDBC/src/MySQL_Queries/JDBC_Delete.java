package MySQL_Queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Delete {

	public static void main(String[] args) throws SQLException {

		Connection myConnection = null;
		Statement myStatement = null;
		ResultSet myResultSet = null;
		
		try {
			// 1. Get a connection to database
			myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo"
			  		+ "?useUnicode=true"
			  		+ "&useJDBCCompliantTimezoneShift=true"
			  		+ "&useLegacyDatetimeCode=false"
			  		+ "&serverTimezone=UTC", "caglar", "Ofis270.");
			
			System.out.println("Database connection successful!\n");
			
			// 2. Create a statement
			myStatement = myConnection.createStatement();
			
			// 3. Before the delete to display the employee's info
			System.out.println("--BEFORE DELETE--");
			// helper method
			displayEmployee(myConnection, "Caglar", "Kaya");
			
			// 4. DELETE the employee
			System.out.println("\nDELETING THE EMPLOYEE FOR: Caglar Kaya\n");
			
			int rowsAffected = myStatement.executeUpdate(
					"delete from employees " +
					"where last_name = 'Kaya' and first_name = 'Caglar'"
					);
			
			// 5. Verify Deleting
			System.out.println("--AFTER DELETE--");
			// helper method
			displayEmployee(myConnection, "Caglar", "Kaya");
			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			close(myConnection, myStatement, myResultSet);
		}
	}
	
	private static void displayEmployee(Connection myConnection, String firstName, String lastName) throws SQLException {
		PreparedStatement myStatement = null;
		ResultSet myResultSet = null;
		try {
			// Prepare Statement
			myStatement = myConnection
						.prepareStatement("select last_name, first_name, email, department, salary "
								+ "from employees where last_name = ? and first_name = ?");
			myStatement.setString(1, lastName);
			myStatement.setString(2, firstName);
			
			// Execute SQL query
			myResultSet = myStatement.executeQuery();
			
			// Process result set
			boolean found = false;
			
			while (myResultSet.next()) {
				String theLastName = myResultSet.getString("last_name");
				String theFirstName = myResultSet.getString("first_name");
				String email = myResultSet.getString("email");
				String department = myResultSet.getString("department");
				int salary = myResultSet.getInt("salary");
				
				System.out.printf("%s, %s, %s, %s, %d\n", theFirstName, theLastName, email, department, salary);
				found = true;
			}
			
			if(!found) {
				System.out.println("Employee NOT FOUND : " + firstName + " " + lastName);
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			close(myStatement, myResultSet);
		}
	}
	
	private static void close(Connection myConnection, Statement myStatement, ResultSet myResultSet) throws SQLException {
		if (myResultSet != null) {
			myResultSet.close();
		}
		if (myStatement != null) {
			myStatement.close();
		}
		if (myConnection != null) {
			myConnection.close();
		}
	}
	
	private static void close(Statement myStatement, ResultSet myResultSet) throws SQLException {
		close(null, myStatement, myResultSet);
	}

}
