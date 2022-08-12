package com.training.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ResultDemo {

	public static void main(String[] args) {
       
		String url ="jdbc:mysql://localhost:3306/traildb";
		String username = "root";
		String password = "root";
		Connection connection = null;
		Statement statement =null;
		ResultSet rs = null;
        try {
		 connection = DriverManager.getConnection(url,username,password);
			 statement = connection.createStatement();
			 String Sql = "select * from policy";
			 rs = statement.executeQuery(Sql);
			 while(rs.next()) {
				 String name = rs.getString("name");
				 int policyId = rs.getInt("policy_id");
				 String type = rs.getString(3);
				 float premium = rs.getFloat("premium");
				 System.out.println(name+"\t"+policyId+"\t"+type+"\t"+premium);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				
			if (connection!= null )
			       connection.close();
			if(statement!=null)
				statement.close();
			if (rs !=null)
				rs.close();
			}catch (SQLException e)
			
			{
				e.printStackTrace();
			}
		}
        
	}
		
	}


