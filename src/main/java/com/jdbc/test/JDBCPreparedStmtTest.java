package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPreparedStmtTest {

	static final String sqlinsert="insert into Emp values(?,?,?)";
	static final String sql = "delete from Emp where eid=?";
	static final String createQUERY = "SELECT * FROM Emp";
	
	static final String url="jdbc:mysql://localhost:3306/mydatabase";
	static final String username="root";
	static final String pass="Mahu@1209";
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		JDBCPreparedStmtTest jdbcprestmt = new JDBCPreparedStmtTest();
		jdbcprestmt.update();

		jdbcprestmt.readData();

		jdbcprestmt.create();

		jdbcprestmt.delete();
	}

	static Connection con = null;

	public static Connection CreateConnection() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("given connection--------");

			con = DriverManager.getConnection(url, username, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	private void delete() throws ClassNotFoundException {
		
		JDBCPreparedStmtTest.CreateConnection();
		

	    try {
	    	PreparedStatement stmt = con.prepareStatement(sql);
	    
	      
	      stmt.setInt(1, 104);
	      stmt.executeUpdate();
	      
	      System.out.println("Record deleted successfully");
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }

	}

	private void create() throws ClassNotFoundException {
		// TODO Auto-generated method stub

	
			JDBCPreparedStmtTest.CreateConnection();
		
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sqlinsert);
			stmt.setInt(1, 101);

			stmt.setString(2, "Ratan");
			stmt.setString(3, "T");

			int i = stmt.executeUpdate();
			System.out.println(i + " records inserted");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void readData() throws ClassNotFoundException {
		JDBCPreparedStmtTest.CreateConnection();
	
		try {
			PreparedStatement statement = 
				     con.prepareStatement(createQUERY);
			
			ResultSet resultSet = statement.executeQuery();
			  if (resultSet.next()) {
				  System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
			  }
			  
			  
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	private void update() throws ClassNotFoundException {
		String updateQ="Update Emp Set Fname='mahi',Lname='TE' where eid=103";
		System.out.println(updateQ);
		JDBCPreparedStmtTest.CreateConnection();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(updateQ);
	
		int rs=pstmt.executeUpdate();
		System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            
	}
	}


