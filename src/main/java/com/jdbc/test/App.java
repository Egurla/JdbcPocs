package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {

	static Connection con = null;

	public static Connection CreateConnection() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("given connection--------");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "Mahu@1209");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public void update(int id, String FN, String LN) {

		String qu = "UPDATE Emp SET Fname='" + FN + "',Lname='" + LN + "'where eid=103";
		// String qu="select * from Emp";
		System.out.println(qu);
		try {
			con = App.CreateConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			System.out.println("statement");
			Statement stmt = con.createStatement();
			System.out.println("--------------");
			stmt.executeUpdate(qu);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void read() throws ClassNotFoundException {
		String sql = "select * from Emp";

		Statement statement = null;
		try {

			con = App.CreateConnection();
			statement = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet result = null;
		try {
			result = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int count = 0;

		try {
			while (result.next()) {
				int eid = result.getInt(1);
				String lname = result.getString(2);
				String fname = result.getString(3);
				System.out.println(eid + " " + lname + "  " + fname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void create() {
		// TODO Auto-generated method stub

	}
}
