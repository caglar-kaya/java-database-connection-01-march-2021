package MySQL_Queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Test {

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
			
			// 3. Execute SQL query
			myResultSet = myStatement.executeQuery("select * from employees");
			
			// 4. Process the result set
			while (myResultSet.next()) {
				System.out.println(myResultSet.getString("last_name") + " --- " + myResultSet.getString("first_name"));
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
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
		
	}

}
















