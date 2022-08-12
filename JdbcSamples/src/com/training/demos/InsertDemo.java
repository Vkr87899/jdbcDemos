package com.training.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDemo {

	public static void main(String[] args) {
	//	System.out.println("\'java\'");
	//	System.out.println("\"java is fun\"");
		
		String url ="jdbc:mysql://localhost:3306/traildb";
		String username = "root";
		String password = "root";
		Connection connection = null;
		Statement statement =null;
		Scanner scanner = null;
        try {
		 connection = DriverManager.getConnection(url,username,password);
			 statement = connection.createStatement();
	//		String Sql = "insert into policy values('jeevan',10,'life',2000)";
	//		int result = statement.executeUpdate(Sql);
	//		System.out.println("inserted" +result);
			 
			 scanner  = new Scanner(System.in);

			 for(int i = 0; i<4; i++) {
				 System.out.println("enter policy name");
				 String name = scanner.next();
				 System.out.println("enter policy id");
				 int policyId = scanner.nextInt();
				 System.out.println("enter policy type");
				 String type = scanner.next();
				 System.out.println("enter policy premium");
				 float premium = scanner.nextFloat();
				 
				 String Sql = "insert into policy values('"+name+"',"+policyId+",'"+type+"',"+premium+")";
							int result = statement.executeUpdate(Sql);
						System.out.println("inserted" +result);
						
						
							 
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
			}catch (SQLException e)
			
			{
				e.printStackTrace();
			}
		}

	}

}
