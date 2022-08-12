package com.training.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreUpdateDemo {
	 public static void main(String[] args) {
		   String url ="jdbc:mysql://localhost:3306/traildb";
			String username = "root";
			String password = "root";
			Connection connection = null;
			Statement statement =null;
			PreparedStatement preparedStatement = null;
			
	       try {
			 connection = DriverManager.getConnection(url,username,password);
			
			 String sql = "update policy set type =? where policy_id=? ";
			 preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setString(1, "wealth");
			 preparedStatement.setInt(2, 6);
			 preparedStatement.execute();
			 
			 
			 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					
				if (connection!= null )
				       connection.close();
				if(statement!=null)
					statement.close();
				if(preparedStatement!=null)
					preparedStatement.close();
				}catch (SQLException e)
				
				{
					e.printStackTrace();
				}
			}
	       
		}
}
