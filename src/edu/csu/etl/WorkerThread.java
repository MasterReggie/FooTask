package edu.csu.etl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class WorkerThread extends Thread {
	private String source;

	private String target = "Target";

	public WorkerThread(String source) {
		this.source = source;
	}

	public void run() {

		// This will load the MySQL driver, each DB has its own driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost/" + source + "?user=root&password=123456");

			// Statements allow to issue SQL queries to the database
			Statement statement = connect.createStatement();
			// Result set get the result of the SQL query
			ResultSet resultSet = statement.executeQuery("select count(*) from "+source+".Foo");
			int count = resultSet.getInt(0);
			if(count==0){
				
			}
			
			//sum
			
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
