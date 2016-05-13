package edu.csu.etl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class WorkerThread extends Thread {
	private String source;

	private String target = "Target";

	private Connection connect;
	
	public WorkerThread(String source) {
		this.source = source;
	}

	public void run() {
		// This will load the MySQL driver, each DB has its own driver
		try {
			connect();
			int count = getCount();
			if (count == 0) {
				init();
			}
			int sum = getSumVal();
			storeSum(sum);
			disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void connect() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		// Setup the connection with the DB
		this.connect = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=123456");
	}
	
	public void disconnect() throws SQLException{
		this.connect.close();
	}
	
	public int getCount() throws SQLException{
		// Statements allow to issue SQL queries to the database
		Statement statement = this.connect.createStatement();
		// Result set get the result of the SQL query
		ResultSet resultSet = statement.executeQuery("select count(*) from " + source + ".Foo");
		resultSet.next();
		int count = resultSet.getInt(1);
		return count;
	}
	public void init() throws SQLException{
		for (int i = 0; i < 1000; i++) {
			Random r = new Random();
			String sql = "insert into " + source + ".Foo (val) values (" + r.nextInt(1000) + ")";
			Statement statement = this.connect.createStatement();
			statement.execute(sql);
		}
	}
	public void clear() throws SQLException{
		String sql = "delete from " + source + ".Foo";
		Statement statement = this.connect.createStatement();
		statement.execute(sql);
	}
	public int getSumVal() throws SQLException{
		Statement statement = this.connect.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from " + source + ".Foo");
		int sum = 0;
		while (resultSet.next()) {
			int val = resultSet.getInt("val");
			sum += val;
		}
		return sum;
	}
	
	public int storeSum(int sum) throws SQLException{
		int id = 0;
		Statement statement = this.connect.createStatement();
		String sql = "insert into " + target + ".Stat (source, sum) values (" + source + "," + sum + ")";
		statement.execute(sql);
		return id;
	}
}
