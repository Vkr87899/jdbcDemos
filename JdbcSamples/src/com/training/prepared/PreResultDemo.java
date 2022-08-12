package com.training.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class PreResultDemo {
   public static void main(String[] args) {
	   String url ="jdbc:mysql://localhost:3306/traildb";
		String username = "root";
		String password = "root";
		Connection connection = null;
		Statement statement =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
       try {
		 connection = DriverManager.getConnection(url,username,password);
		 String type = "veg";
		 String sql ="select * from food where type=?";
		 preparedStatement = connection.prepareStatement(sql);
		 resultset = preparedStatement.executeQuery();
		 while(resultset.next()) {
		String name = resultset.getString("name") ;
		int foodId = resultset.getInt ("food ID");
		String type1 = resultset.getString("type");
		float cost = resultset.getFloat("cost");
		System.out.println(name + "\t" + foodId + "\t" +type1 + "\t" +cost);
		 
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
			if(preparedStatement!=null)
				preparedStatement.close();
			}catch (SQLException e)
			
			{
				e.printStackTrace();
			}
		}
       
	}
}

